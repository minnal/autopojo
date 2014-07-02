/**
 * 
 */
package org.minnal.autopojo;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.minnal.autopojo.resolver.ArrayResolver;
import org.minnal.autopojo.resolver.AttributeResolver;
import org.minnal.autopojo.resolver.BigDecimalResolver;
import org.minnal.autopojo.resolver.BigIntegerResolver;
import org.minnal.autopojo.resolver.BooleanResolver;
import org.minnal.autopojo.resolver.ByteResolver;
import org.minnal.autopojo.resolver.CharacterResolver;
import org.minnal.autopojo.resolver.CollectionResolver;
import org.minnal.autopojo.resolver.DateResolver;
import org.minnal.autopojo.resolver.DoubleResolver;
import org.minnal.autopojo.resolver.EnumResolver;
import org.minnal.autopojo.resolver.FloatResolver;
import org.minnal.autopojo.resolver.IntegerResolver;
import org.minnal.autopojo.resolver.LongResolver;
import org.minnal.autopojo.resolver.MapResolver;
import org.minnal.autopojo.resolver.ObjectResolver;
import org.minnal.autopojo.resolver.ShortResolver;
import org.minnal.autopojo.resolver.StringResolver;
import org.minnal.autopojo.resolver.TimestampResolver;

/**
 * @author ganeshs
 *
 */
public class GenerationStrategy {
	
	private Map<Class<?>, AttributeResolver> resolvers = new LinkedHashMap<Class<?>, AttributeResolver>();
	
	private Configuration configuration;
	
	public GenerationStrategy(Configuration configuration) {
		this.configuration = configuration;
		register(String.class, StringResolver.class);
		register(Integer.class, IntegerResolver.class);
		register(int.class, IntegerResolver.class);
		register(Long.class, LongResolver.class);
		register(long.class, LongResolver.class);
		register(Boolean.class, BooleanResolver.class);
		register(boolean.class, BooleanResolver.class);
		register(Double.class, DoubleResolver.class);
		register(double.class, DoubleResolver.class);
		register(Float.class, FloatResolver.class);
		register(float.class, FloatResolver.class);
		register(Short.class, ShortResolver.class);
		register(short.class, ShortResolver.class);
		register(Byte.class, ByteResolver.class);
		register(byte.class, ByteResolver.class);
		register(Character.class, CharacterResolver.class);
		register(char.class, CharacterResolver.class);
		register(BigInteger.class, BigIntegerResolver.class);
		register(BigDecimal.class, BigDecimalResolver.class);
		register(Date.class, DateResolver.class);
		register(java.util.Date.class, DateResolver.class);
		register(Timestamp.class, TimestampResolver.class);
		register(Enum.class, EnumResolver.class);
		register(Object[].class, ArrayResolver.class);
		register(int[].class, ArrayResolver.class);
		register(long[].class, ArrayResolver.class);
		register(boolean[].class, ArrayResolver.class);
		register(double[].class, ArrayResolver.class);
		register(float[].class, ArrayResolver.class);
		register(byte[].class, ArrayResolver.class);
		register(short[].class, ArrayResolver.class);
		register(char[].class, ArrayResolver.class);
		register(Collection.class, CollectionResolver.class);
		register(Map.class, MapResolver.class);
		register(Object.class, ObjectResolver.class);		
	}
	
	/**
	 * Register the attribute class with the resolver
	 * 
	 * @param attributeClass
	 * @param resolverClass
	 */
	public void register(Class<?> attributeClass, Class<? extends AttributeResolver> resolverClass) {
		AttributeResolver resolver = null;
		try {
			resolver = resolverClass.newInstance();
		} catch (Exception e) {
			throw new AutoPojoException("Failed while instantiating the resolver - " + resolverClass, e);
		}
		resolver.init(this, configuration);
		resolvers.put(attributeClass, resolver);
	}

	protected AttributeResolver resolverFor(Class<?> type) {
		AttributeResolver resolver = resolvers.get(type);
		if (resolver == null) {
			for (Entry<Class<?>, AttributeResolver> entry : resolvers.entrySet()) {
				if (entry.getKey().isAssignableFrom(type)) {
					resolver = entry.getValue();
					break;
				}
			}
		}
		return resolver;
	}
	
	public <T> T resolve(Class<T> type, int maxDepth, Type... genericTypes) {
		return (T) resolverFor(type).resolve(type, maxDepth, genericTypes);
	}
	
	public void resolve(Object pojo, AttributeMetaData attribute, int maxDepth) {
		resolverFor(attribute.getType()).resolve(pojo, attribute, maxDepth);
	}
}

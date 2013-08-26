/**
 * 
 */
package org.minnal.autopojo;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.commons.lang3.ClassUtils;
import org.minnal.autopojo.resolver.ArrayResolver;
import org.minnal.autopojo.resolver.AttributeResolver;
import org.minnal.autopojo.resolver.BigDecimalResolver;
import org.minnal.autopojo.resolver.BigIntegerResolver;
import org.minnal.autopojo.resolver.BooleanResolver;
import org.minnal.autopojo.resolver.ByteResolver;
import org.minnal.autopojo.resolver.CharacterResolver;
import org.minnal.autopojo.resolver.CollectionResolver;
import org.minnal.autopojo.resolver.DoubleResolver;
import org.minnal.autopojo.resolver.FloatResolver;
import org.minnal.autopojo.resolver.IntegerResolver;
import org.minnal.autopojo.resolver.LongResolver;
import org.minnal.autopojo.resolver.MapResolver;
import org.minnal.autopojo.resolver.ObjectResolver;
import org.minnal.autopojo.resolver.ShortResolver;
import org.minnal.autopojo.resolver.StringResolver;
import org.minnal.autopojo.util.PropertyUtil;

/**
 * @author ganeshs
 *
 */
public class GenerationStrategy {

	protected AttributeResolver getStringResolver() {
		return new StringResolver();
	}
	
	protected AttributeResolver getBooleanResolver() {
		return new BooleanResolver();
	}
	
	protected AttributeResolver getByteResolver() {
		return new ByteResolver();
	}
	
	protected AttributeResolver getCharacterResolver() {
		return new CharacterResolver();
	}
	
	protected AttributeResolver getLongResolver() {
		return new LongResolver();
	}
	
	protected AttributeResolver getIntegerResolver() {
		return new IntegerResolver();
	}
	
	protected AttributeResolver getDoubleResolver() {
		return new DoubleResolver();
	}
	
	protected AttributeResolver getFloatResolver() {
		return new FloatResolver();
	}
	
	protected AttributeResolver getShortResolver() {
		return new ShortResolver();
	}
	
	protected AttributeResolver getBigIntegerResolver() {
		return new BigIntegerResolver();
	}
	
	protected AttributeResolver getBigDecimalResolver() {
		return new BigDecimalResolver();
	}
	
	protected AttributeResolver getCollectionResolver() {
		return new CollectionResolver(this);
	}
	
	protected AttributeResolver getMapResolver() {
		return new MapResolver(this);
	}
	
	protected AttributeResolver getArrayResolver() {
		return new ArrayResolver(this);
	}
	
	protected AttributeResolver getObjectResolver() {
		return new ObjectResolver(this);
	}
	
	protected AttributeResolver resolverFor(Class<?> type) {
		AttributeResolver resolver = null;
		if (PropertyUtil.isCollectionProperty(type, false)) {
			resolver = getCollectionResolver();
		} else if (PropertyUtil.isMapProperty(type)) {
			resolver = getMapResolver();
		} else if (type.isArray()) {
			resolver = getArrayResolver();
		} else if (type.equals(String.class)) {
			resolver = getStringResolver();
		} else if (ClassUtils.isAssignable(type, Long.class)) {
			resolver = getLongResolver();
		} else if (ClassUtils.isAssignable(type, Integer.class)) {
			resolver = getIntegerResolver();
		} else if (ClassUtils.isAssignable(type, Short.class)) {
			resolver = getShortResolver();
		} else if (ClassUtils.isAssignable(type, Double.class)) {
			resolver = getDoubleResolver();
		} else if (ClassUtils.isAssignable(type, Float.class)) {
			resolver = getFloatResolver();
		} else if (ClassUtils.isAssignable(type, Byte.class)) {
			resolver = getByteResolver();
		} else if (type.equals(BigInteger.class)) {
			resolver = getBigIntegerResolver();
		} else if (type.equals(BigDecimal.class)) {
			resolver = getBigDecimalResolver();
		} else if (ClassUtils.isAssignable(type, Boolean.class)) {
			resolver = getBooleanResolver();
		} else if (ClassUtils.isAssignable(type, Character.class)) {
			resolver = getCharacterResolver();
		} else if (CharSequence.class.isAssignableFrom(type)) {
			resolver = getStringResolver();
		} else {
			resolver = getObjectResolver();
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

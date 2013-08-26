/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.minnal.autopojo.AttributeMetaData;
import org.minnal.autopojo.GenerationStrategy;
import org.minnal.autopojo.annotations.Exclude;
import org.minnal.autopojo.util.PropertyUtil;

/**
 * @author ganeshs
 *
 */
public class ObjectResolver extends AbstractAttributeResolver {
	
	private List<Class<? extends Annotation>> excludeAnnotations = new ArrayList<Class<? extends Annotation>>();
	
	private List<String> excludeFields = new ArrayList<String>();
	
	private GenerationStrategy strategy;
	
	/**
	 * @param strategy
	 */
	public ObjectResolver(GenerationStrategy strategy) {
		this.strategy = strategy;
		excludeAnnotations.add(Exclude.class);
	}

	/**
	 * @param strategy
	 * @param excludeAnnotations
	 * @param excludeFields
	 */
	public ObjectResolver(GenerationStrategy strategy, List<Class<? extends Annotation>> excludeAnnotations, List<String> excludeFields) {
		this(strategy);
		if (excludeAnnotations != null) {
			this.excludeAnnotations.addAll(excludeAnnotations);
		}
		if (excludeFields != null) {
			this.excludeFields.addAll(excludeFields);
		}
	}

	public Object resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		if (clazz.equals(Object.class)) {
			return new Object();
		}
		maxDepth -= 1;
		Map<TypeVariable<?>, Type> genericParameters = getGenericParameterMap(clazz, genericTypes);
		Object pojo = constructPojo(clazz, genericParameters, maxDepth);
		
		for (PropertyDescriptor descriptor : PropertyUtils.getPropertyDescriptors(clazz)) {
			if (shouldExclude(descriptor)) {
				continue;
			}
			strategy.resolve(pojo, new AttributeMetaData(descriptor, genericParameters), maxDepth);
		}
		return pojo;
	}
	
	protected boolean shouldExclude(PropertyDescriptor descriptor) {
		for (Class<? extends Annotation> annotation : excludeAnnotations) {
			if (PropertyUtil.hasAnnotation(descriptor, annotation)) {
				return true;
			}
		}
		if (descriptor.getReadMethod().getDeclaringClass().equals(Object.class)) {
			return true;
		}
		return excludeFields.contains(descriptor.getName());
	}
	
	protected Object constructPojo(Class<?> clazz, Map<TypeVariable<?>, Type> genericParameters, int maxDepth) {
		Object pojo = constructPojoUsingDefaultConstructor(clazz);
		if (pojo != null) {
			return pojo;
		}
		maxDepth -= 1;
		Constructor<?>[] constructors = clazz.getConstructors();
		for (Constructor<?> constructor : constructors) {
			pojo = constructPojoUsingConstructorWithArgs(constructor, genericParameters, maxDepth);
			if (pojo != null) {
				return pojo;
			}
		}
		// TODO Should we throw an exception here??
		return null;
	}
	
	private Object constructPojoUsingDefaultConstructor(Class<?> clazz) {
		try {
			Constructor<?> constructor = clazz.getConstructor();
			constructor.setAccessible(true);
			return constructor.newInstance();
		} catch (Exception e) {
			// log error
			return null;
		}
	}
	
	private Object constructPojoUsingConstructorWithArgs(Constructor<?> constructor, Map<TypeVariable<?>, Type> genericParameters, int maxDepth) {
		Type[] parameterTypes = constructor.getGenericParameterTypes();
		if (parameterTypes.length == 0) {
			return null;
		}
		Object[] parameters = new Object[parameterTypes.length];
		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i] instanceof TypeVariable) {
				
			} else if (parameterTypes[i] instanceof ParameterizedType) {
				Type[] arguments = ((ParameterizedType) parameterTypes[i]).getActualTypeArguments();
				parameters[i] = strategy.resolve(PropertyUtil.getRawType(parameterTypes[i]), maxDepth, getGenericTypes(arguments, genericParameters));
			}
		}
		try {
			constructor.setAccessible(true);
			return constructor.newInstance(parameters);
		} catch (Exception e) {
			// log error
			return null;
		}
	}
	
	private Type[] getGenericTypes(Type[] parameters, Map<TypeVariable<?>, Type> genericParameters) {
		Type[] types = new Type[parameters.length];
		for (int i = 0 ; i < parameters.length; i++) {
			types[i] = genericParameters.containsKey(parameters[i]) ? genericParameters.get(parameters[i]) : Object.class;
		}
		return types;
	}
	
	private Map<TypeVariable<?>, Type> getGenericParameterMap(Class<?> clazz, Type[] genericTypes) {
		Map<TypeVariable<?>, Type> genericParameters = new HashMap<TypeVariable<?>, Type>();
		TypeVariable<?>[] params = clazz.getTypeParameters();
		for (int i = 0; i < params.length; i++) {
			if (genericTypes != null && genericTypes.length > i) {
				genericParameters.put(params[i], genericTypes[i]);
			} else {
				genericParameters.put(params[i], Object.class);
			}
		}
		return genericParameters;
	}
}

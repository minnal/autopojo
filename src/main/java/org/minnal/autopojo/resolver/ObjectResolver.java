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
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.minnal.autopojo.AttributeMetaData;
import org.minnal.autopojo.util.PropertyUtil;

/**
 * @author ganeshs
 *
 */
public class ObjectResolver extends AbstractAttributeResolver {
	
	public Object resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		if (clazz.equals(Object.class)) {
			return new Object();
		}
		maxDepth -= 1;
		Map<TypeVariable<?>, Type> genericParameters = getGenericParameterMap(clazz, genericTypes);
		Object pojo = constructPojo(clazz, genericParameters, maxDepth);
		
		if (! PropertyUtil.isSimpleProperty(clazz)) {
			for (PropertyDescriptor descriptor : PropertyUtils.getPropertyDescriptors(clazz)) {
				if (shouldExclude(descriptor)) {
					continue;
				}
				strategy.resolve(pojo, new AttributeMetaData(descriptor, genericParameters), maxDepth);
			}
		}
		return pojo;
	}
	
	protected boolean shouldExclude(PropertyDescriptor descriptor) {
		if (descriptor.getWriteMethod() == null) {
			return true;
		}
		for (Class<? extends Annotation> annotation : configuration.getExcludeAnnotations()) {
			if (PropertyUtil.hasAnnotation(descriptor, annotation)) {
				return true;
			}
		}
		if (descriptor.getReadMethod().getDeclaringClass().equals(Object.class)) {
			return true;
		}
		return configuration.getExcludeFields().contains(descriptor.getName());
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
				parameters[i] = strategy.resolve(PropertyUtil.getRawType(genericParameters.get(parameterTypes[i])), maxDepth, 
						PropertyUtil.getTypeArguments(genericParameters.get(parameterTypes[i])));
			} else if (parameterTypes[i] instanceof ParameterizedType) {
				Type[] arguments = ((ParameterizedType) parameterTypes[i]).getActualTypeArguments();
				parameters[i] = strategy.resolve(PropertyUtil.getRawType(parameterTypes[i]), maxDepth, getGenericTypes(arguments, genericParameters));
			} else {
				parameters[i] = strategy.resolve(PropertyUtil.getRawType(parameterTypes[i]), maxDepth, PropertyUtil.getTypeArguments(parameterTypes[i]));
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

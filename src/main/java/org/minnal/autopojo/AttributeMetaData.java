/**
 * 
 */
package org.minnal.autopojo;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.minnal.autopojo.util.PropertyUtil;


/**
 * @author ganeshs
 *
 */
public class AttributeMetaData {

	private String name;
	
	private List<Annotation> annotations = new ArrayList<Annotation>();
	
	private Class<?> type;
	
	private List<Type> typeArguments = new ArrayList<Type>();
	
	public AttributeMetaData(PropertyDescriptor descriptor) {
		this(descriptor, new HashMap<TypeVariable<?>, Type>());
	}
	
	/**
	 * @param descriptor
	 * @param genericParameters
	 */
	public AttributeMetaData(PropertyDescriptor descriptor, Map<TypeVariable<?>, Type> genericParameters) {
		this.name = descriptor.getName();
		this.annotations.addAll(PropertyUtil.getAnnotations(descriptor));
		Type genericType = descriptor.getReadMethod().getGenericReturnType();
		if (genericType instanceof ParameterizedType) {
			for (Type argument : ((ParameterizedType) genericType).getActualTypeArguments()) {
				if (argument instanceof TypeVariable) {
					typeArguments.add(genericParameters.get(argument));
				} else {
					typeArguments.add(argument);
				}
			}
			this.type = (Class<?>) ((ParameterizedType) genericType).getRawType();
		} else if (genericType instanceof TypeVariable) {
			this.type = (Class<?>) genericParameters.get(genericType);
		} else if (genericType instanceof Class) {
			this.type = (Class<?>) genericType;
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the annotations
	 */
	public List<Annotation> getAnnotations() {
		return annotations;
	}

	/**
	 * @return the type
	 */
	public Class<?> getType() {
		return type;
	}

	/**
	 * @return the typeArguments
	 */
	public Type[] getTypeArguments() {
		return typeArguments.toArray(new Type[0]);
	}
	
	public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
		for (Annotation annotation : annotations) {
			if (annotation.annotationType().equals(annotationClass)) {
				return (T) annotation;
			}
		}
		return null;
	}
}

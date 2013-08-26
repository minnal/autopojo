/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;


/**
 * @author ganeshs
 *
 */
public abstract class NumberResolver<T extends Number> extends AbstractAttributeResolver {
	
	protected T minValue;
	
	protected T maxValue;
	
	/**
	 * @param minValue
	 * @param maxValue
	 */
	public NumberResolver(T minValue, T maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	
	public Object resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		return minValue.equals(maxValue) ? minValue : null;
	}
}
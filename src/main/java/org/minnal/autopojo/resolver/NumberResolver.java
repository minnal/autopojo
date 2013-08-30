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
	
	public Object resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		return getMinValue().equals(getMaxValue()) ? getMinValue() : null;
	}
	
	protected abstract T getMinValue();
	
	protected abstract T getMaxValue();
}
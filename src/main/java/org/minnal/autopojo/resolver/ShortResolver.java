/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;



/**
 * @author ganeshs
 *
 */
public class ShortResolver extends NumberResolver<Short> {
	
	public Short resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Short value = (Short) super.resolve(clazz, maxDepth, genericTypes);
		return value != null ? value : (short) (configuration.getShortMinValue() + (short) (Math.random() * (configuration.getShortMaxValue() - configuration.getShortMinValue() + 1)));
	}
	
	@Override
	protected Short getMaxValue() {
		return configuration.getShortMaxValue();
	}
	
	@Override
	protected Short getMinValue() {
		return configuration.getShortMinValue();
	}
}

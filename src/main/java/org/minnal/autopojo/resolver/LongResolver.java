/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;


/**
 * @author ganeshs
 *
 */
public class LongResolver extends NumberResolver<Long> {
	
	public Long resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Long value = (Long) super.resolve(clazz, maxDepth, genericTypes);
		return value != null ? value : configuration.getLongMinValue() + (long) (Math.random() * (configuration.getLongMaxValue() - configuration.getLongMinValue() + 1));
	}

	@Override
	protected Long getMaxValue() {
		return configuration.getLongMaxValue();
	}
	
	@Override
	protected Long getMinValue() {
		return configuration.getLongMinValue();
	}
}

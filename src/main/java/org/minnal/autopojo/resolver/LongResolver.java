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
	
	public LongResolver() {
		super(0L, Long.MAX_VALUE / 2);
	}

	/**
	 * @param minValue
	 * @param maxValue
	 */
	public LongResolver(Long minValue, Long maxValue) {
		super(minValue, maxValue);
	}
	
	public Long resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Long value = (Long) super.resolve(clazz, maxDepth, genericTypes);
		return value != null ? value : minValue + (long) (Math.random() * (maxValue - minValue + 1));
	}
	
}

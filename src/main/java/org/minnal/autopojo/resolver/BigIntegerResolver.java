/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;
import java.math.BigInteger;

/**
 * @author ganeshs
 *
 */
public class BigIntegerResolver extends NumberResolver<Long> {
	
	public BigIntegerResolver() {
		super(0L, Long.MAX_VALUE / 2);
	}

	/**
	 * @param minValue
	 * @param maxValue
	 */
	public BigIntegerResolver(Long minValue, Long maxValue) {
		super(minValue, maxValue);
	}
	
	public BigInteger resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Long value = (Long) super.resolve(clazz, maxDepth, genericTypes);
		return BigInteger.valueOf(value != null ? value : minValue + (long) (Math.random() * (maxValue - minValue + 1)));
	}
	
}

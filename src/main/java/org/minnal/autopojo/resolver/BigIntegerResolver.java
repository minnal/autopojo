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
	
	public BigInteger resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Long value = (Long) super.resolve(clazz, maxDepth, genericTypes);
		return BigInteger.valueOf(value != null ? value : getMinValue() + (long) (Math.random() * (getMaxValue() - getMinValue() + 1)));
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

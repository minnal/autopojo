/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * @author ganeshs
 *
 */
public class BigDecimalResolver extends NumberResolver<Double> {
	
	public BigDecimalResolver() {
		super(0d, Double.MAX_VALUE / 2);
	}

	/**
	 * @param minValue
	 * @param maxValue
	 */
	public BigDecimalResolver(Double minValue, Double maxValue) {
		super(minValue, maxValue);
	}
	
	public BigDecimal resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Double value = (Double) super.resolve(clazz, maxDepth, genericTypes);
		return BigDecimal.valueOf(value != null ? value : minValue + (double) (Math.random() * (maxValue - minValue)));
	}
	
}

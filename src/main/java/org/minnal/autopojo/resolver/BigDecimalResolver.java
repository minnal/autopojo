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
	
	public BigDecimal resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Double value = (Double) super.resolve(clazz, maxDepth, genericTypes);
		return BigDecimal.valueOf(value != null ? value : getMinValue() + (double) (Math.random() * (getMaxValue() - getMinValue())));
	}

	@Override
	protected Double getMaxValue() {
		return configuration.getDoubleMaxValue();
	}
	
	@Override
	protected Double getMinValue() {
		return configuration.getDoubleMinValue();
	}
}

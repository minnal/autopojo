/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;

/**
 * @author ganeshs
 *
 */
public class DoubleResolver extends NumberResolver<Double> {
	
	public Double resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Double value = (Double) super.resolve(clazz, maxDepth, genericTypes);
		return value != null ? value : configuration.getDoubleMinValue() + (double) (Math.random() * (configuration.getDoubleMaxValue() - configuration.getDoubleMinValue()));
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

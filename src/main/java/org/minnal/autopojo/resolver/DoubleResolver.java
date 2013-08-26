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
	
	/**
	 * @param minValue
	 * @param maxValue
	 */
	public DoubleResolver(double minValue, double maxValue) {
		super(minValue, maxValue);
	}

	public DoubleResolver() {
		super(0d, Double.MAX_VALUE/2);
	}

	public Double resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Double value = (Double) super.resolve(clazz, maxDepth, genericTypes);
		return value != null ? value : minValue + (double) (Math.random() * (maxValue - minValue));
	}
}

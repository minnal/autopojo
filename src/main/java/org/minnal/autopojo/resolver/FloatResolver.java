/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;



/**
 * @author ganeshs
 *
 */
public class FloatResolver extends NumberResolver<Float> {
	
	/**
	 * @param minValue
	 * @param maxValue
	 */
	public FloatResolver(float minValue, float maxValue) {
		super(minValue, maxValue);
	}

	public FloatResolver() {
		super(0f, Float.MAX_VALUE/2);
	}

	public Float resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Float value = (Float) super.resolve(clazz, maxDepth, genericTypes);
		return value != null ? value : minValue + (float) (Math.random() * (maxValue - minValue));
	}
}

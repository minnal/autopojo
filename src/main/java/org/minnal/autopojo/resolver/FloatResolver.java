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
	
	public Float resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Float value = (Float) super.resolve(clazz, maxDepth, genericTypes);
		return value != null ? value : configuration.getFloatMinValue() + (float) (Math.random() * (configuration.getFloatMaxValue() - configuration.getFloatMinValue()));
	}
	
	@Override
	protected Float getMaxValue() {
		return configuration.getFloatMaxValue();
	}
	
	@Override
	protected Float getMinValue() {
		return configuration.getFloatMinValue();
	}
}

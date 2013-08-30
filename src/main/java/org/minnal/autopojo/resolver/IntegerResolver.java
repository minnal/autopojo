/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;



/**
 * @author ganeshs
 *
 */
public class IntegerResolver extends NumberResolver<Integer> {
	
	public Integer resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Integer value = (Integer) super.resolve(clazz, maxDepth, genericTypes);
		return value != null ? value : configuration.getIntegerMinValue() + (int) (Math.random() * (configuration.getIntegerMaxValue() - configuration.getIntegerMinValue() + 1));
	}
	
	@Override
	protected Integer getMaxValue() {
		return null;
	}
	
	@Override
	protected Integer getMinValue() {
		return configuration.getIntegerMinValue();
	}
}

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
	
	/**
	 * @param minValue
	 * @param maxValue
	 */
	public IntegerResolver(int minValue, int maxValue) {
		super(minValue, maxValue);
	}

	public IntegerResolver() {
		super(0, Integer.MAX_VALUE/2);
	}

	public Integer resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Integer value = (Integer) super.resolve(clazz, maxDepth, genericTypes);
		return value != null ? value : minValue + (int) (Math.random() * (maxValue - minValue + 1));
	}
}

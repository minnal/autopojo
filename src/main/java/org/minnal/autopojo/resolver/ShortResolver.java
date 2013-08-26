/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;



/**
 * @author ganeshs
 *
 */
public class ShortResolver extends NumberResolver<Short> {
	
	/**
	 * @param minValue
	 * @param maxValue
	 */
	public ShortResolver(short minValue, short maxValue) {
		super(minValue, maxValue);
	}

	public ShortResolver() {
		super((short) 0, (short) (Short.MAX_VALUE/2));
	}

	public Short resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Short value = (Short) super.resolve(clazz, maxDepth, genericTypes);
		return value != null ? value : (short) (minValue + (short) (Math.random() * (maxValue - minValue + 1)));
	}
}

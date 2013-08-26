/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;



/**
 * @author ganeshs
 *
 */
public class ByteResolver extends NumberResolver<Byte> {
	
	/**
	 * @param minValue
	 * @param maxValue
	 */
	public ByteResolver(byte minValue, byte maxValue) {
		super(minValue, maxValue);
	}

	public ByteResolver() {
		this((byte) 0, (byte) (Byte.MAX_VALUE/2));
	}

	public Byte resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Byte value = (Byte) super.resolve(clazz, maxDepth, genericTypes);
		return value != null ? value : (byte) (minValue + (int) (Math.random() * (maxValue - minValue + 1)));
	}
}

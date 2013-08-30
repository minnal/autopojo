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
	
	public Byte resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Byte value = (Byte) super.resolve(clazz, maxDepth, genericTypes);
		return value != null ? value : (byte) (getMinValue() + (int) (Math.random() * (getMaxValue() - getMinValue() + 1)));
	}
	
	@Override
	protected Byte getMaxValue() {
		return configuration.getByteMaxValue();
	}
	
	@Override
	protected Byte getMinValue() {
		return configuration.getByteMinValue();
	}
}

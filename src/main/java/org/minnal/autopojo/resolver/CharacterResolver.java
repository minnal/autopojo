/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;



/**
 * @author ganeshs
 *
 */
public class CharacterResolver extends AbstractAttributeResolver {
	
	private char minValue = Character.MIN_VALUE;
	
	private char maxValue = Character.MAX_VALUE;
	
	public CharacterResolver() {
	}

	/**
	 * @param minValue
	 * @param maxValue
	 */
	public CharacterResolver(char minValue, char maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public Character resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		if (minValue == maxValue) {
			return minValue;
		}
		return (char) (minValue + (char) (Math.random() * (maxValue - minValue + 1)));
	}
}

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
	
	public Character resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		if (configuration.getCharMinValue() == configuration.getCharMaxValue()) {
			return configuration.getCharMinValue();
		}
		return (char) (configuration.getCharMinValue() + (char) (Math.random() * (configuration.getCharMaxValue() - configuration.getCharMinValue() + 1)));
	}
}

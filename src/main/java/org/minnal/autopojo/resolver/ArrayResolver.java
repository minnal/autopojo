/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

/**
 * @author ganeshs
 *
 */
public class ArrayResolver extends AbstractAttributeResolver {
	
	public ArrayResolver() {
	}

	public Object[] resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Class<?> elementType = ((Class<?>) clazz).getComponentType();
		Object array = Array.newInstance(elementType, configuration.getNoOfElementsInCollection());
		for (int i = 0; i < configuration.getNoOfElementsInCollection(); i++) {
            Array.set(array, i, strategy.resolve(elementType, maxDepth));
		}
		return (Object[]) array;
	}

}

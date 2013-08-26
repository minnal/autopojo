/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

import org.minnal.autopojo.GenerationStrategy;

/**
 * @author ganeshs
 *
 */
public class ArrayResolver extends AbstractAttributeResolver {
	
	private GenerationStrategy strategy;
	
	private int noOfElements = DEFAULT_NO_OF_ELEMENTS;
	
	public static final int DEFAULT_NO_OF_ELEMENTS = 3;

	/**
	 * @param strategy
	 * @param noOfElements
	 */
	public ArrayResolver(GenerationStrategy strategy, int noOfElements) {
		this.strategy = strategy;
		this.noOfElements = noOfElements;
	}

	/**
	 * @param strategy
	 */
	public ArrayResolver(GenerationStrategy strategy) {
		this.strategy = strategy;
	}

	public Object[] resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Class<?> elementType = ((Class<?>) clazz).getComponentType();
		Object array = Array.newInstance(elementType, noOfElements);
		for (int i = 0; i < noOfElements; i++) {
            Array.set(array, i, strategy.resolve(elementType, maxDepth));
		}
		return (Object[]) array;
	}

}

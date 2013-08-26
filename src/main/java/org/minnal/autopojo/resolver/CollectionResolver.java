/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.minnal.autopojo.GenerationStrategy;
import org.minnal.autopojo.util.PropertyUtil;



/**
 * @author ganeshs
 *
 */
public class CollectionResolver extends AbstractAttributeResolver {
	
	private int noOfElements = DEFAULT_NO_OF_ELEMENTS;
	
	private GenerationStrategy strategy;
	
	public static final int DEFAULT_NO_OF_ELEMENTS = 3;
	
	/**
	 * @param noOfElements
	 * @param strategy
	 */
	public CollectionResolver(int noOfElements, GenerationStrategy strategy) {
		this.noOfElements = noOfElements;
		this.strategy = strategy;
	}

	/**
	 * @param strategy
	 */
	public CollectionResolver(GenerationStrategy strategy) {
		this.strategy = strategy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Collection resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		Type genericElementType = genericTypes != null && genericTypes.length > 0 ? genericTypes[0] : Object.class;
		Class<?> elementType = PropertyUtil.getRawType(genericElementType);
		Type[] genericParameters = PropertyUtil.getTypeArguments(genericElementType);
		
		Collection value = null;
		if (List.class.isAssignableFrom(clazz)) {
			value = new ArrayList();
		} else if (Set.class.isAssignableFrom(clazz)) {
			value = new HashSet();
		} else if (Queue.class.isAssignableFrom(clazz)) {
			value = new LinkedList();
		}
		
		maxDepth -= 1;
		for (int i = 0; i < noOfElements; i++) {
			value.add(strategy.resolve(elementType, maxDepth, genericParameters));
		}
		return value;
	}

}

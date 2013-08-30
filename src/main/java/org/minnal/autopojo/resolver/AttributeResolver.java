/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;

import org.minnal.autopojo.AttributeMetaData;
import org.minnal.autopojo.Configuration;
import org.minnal.autopojo.GenerationStrategy;

/**
 * @author ganeshs
 *
 */
public interface AttributeResolver {
	
	void init(GenerationStrategy strategy, Configuration configuration);

	void resolve(Object pojo, AttributeMetaData attribute, int maxDepth);
	
	Object resolve(Class<?> clazz, int maxDepth, Type... genericTypes);
}

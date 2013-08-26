/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;

import org.minnal.autopojo.AttributeMetaData;

/**
 * @author ganeshs
 *
 */
public interface AttributeResolver {

	void resolve(Object pojo, AttributeMetaData attribute, int maxDepth);
	
	Object resolve(Class<?> clazz, int maxDepth, Type... genericTypes);
}

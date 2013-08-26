/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;


/**
 * @author ganeshs
 *
 */
public class BooleanResolver extends AbstractAttributeResolver {

	public Boolean resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		return true;
	}

}

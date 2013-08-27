/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;

/**
 * @author ganeshs
 *
 */
public class EnumResolver extends AbstractAttributeResolver {

	@Override
	public Object resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		return clazz.getEnumConstants()[0];
	}

}

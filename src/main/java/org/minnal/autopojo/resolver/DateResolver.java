/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author ganeshs
 *
 */
public class DateResolver extends AbstractAttributeResolver {

	@Override
	public Object resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		return new Date(System.currentTimeMillis());
	}

}

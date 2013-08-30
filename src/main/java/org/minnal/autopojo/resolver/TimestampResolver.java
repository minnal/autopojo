/**
 * 
 */
package org.minnal.autopojo.resolver;

import java.lang.reflect.Type;
import java.sql.Timestamp;

/**
 * @author ganeshs
 *
 */
public class TimestampResolver extends AbstractAttributeResolver {

	@Override
	public Object resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		return new Timestamp(System.currentTimeMillis());
	}

}

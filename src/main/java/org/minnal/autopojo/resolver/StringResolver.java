/**
 * 
 */
package org.minnal.autopojo.resolver;


import java.lang.reflect.Type;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author ganeshs
 *
 */
public class StringResolver extends AbstractAttributeResolver {
	
	public String resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		return configuration.getStringPrefix() + RandomStringUtils.random(configuration.getStringLength(), true, 
				configuration.isAlphanumericString()) + configuration.getStringSuffix();
	}
}

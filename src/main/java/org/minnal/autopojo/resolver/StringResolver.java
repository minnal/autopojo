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
	
	public static final int DEFAULT_LENGTH = 10;
	
	private String prefix = "";
	
	private String suffix = "";
	
	private boolean alphaNumeric;
	
	private int length = DEFAULT_LENGTH;
	
	public StringResolver() {
	}

	/**
	 * @param prefix
	 * @param suffix
	 * @param alphaNumeric
	 * @param length
	 */
	public StringResolver(String prefix, String suffix, boolean alphaNumeric,
			int maxLength) {
		this.prefix = prefix;
		this.suffix = suffix;
		this.alphaNumeric = alphaNumeric;
		this.length = maxLength;
	}

	/**
	 * @param length
	 */
	public StringResolver(int length) {
		this.length = length;
	}

	/**
	 * @param prefix
	 * @param suffix
	 */
	public StringResolver(String prefix, String suffix) {
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
	public String resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
		return prefix + RandomStringUtils.random(length, true, alphaNumeric) + suffix;
	}
}

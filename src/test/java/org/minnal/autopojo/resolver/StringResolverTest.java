/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.minnal.autopojo.Configuration;
import org.minnal.autopojo.GenerationStrategy;
import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class StringResolverTest {
	
	@Test
	public void shouldGenerateDefaultLengthString() {
		StringResolver resolver = new StringResolver();
		Configuration configuration = new Configuration();
		resolver.init(new GenerationStrategy(configuration), configuration);
		String value = resolver.resolve(String.class, 0);
		assertNotNull(value);
		assertEquals(value.length(), configuration.getStringLength());
	}
	
	@Test
	public void shouldGenerateCustomLengthString() {
		StringResolver resolver = getInstance("", "", false, 4);
		String value = resolver.resolve(String.class, 0);
		assertEquals(value.length(), 4);
	}
	
	@Test
	public void shouldGenerateStringWithPrefixAndSuffix() {
		StringResolver resolver = getInstance("foo", "bar", false, 10);
		String value = resolver.resolve(String.class, 0);
		assertTrue(value.startsWith("foo"));
		assertTrue(value.endsWith("bar"));
		assertEquals(value.length(), 10 + 6);
	}
	
	@Test
	public void shouldGenerateCustomLengthStringWithPrefixAndSuffix() {
		StringResolver resolver = getInstance("foo", "bar", false, 4);
		String value = resolver.resolve(String.class, 0);
		assertTrue(value.startsWith("foo"));
		assertTrue(value.endsWith("bar"));
		assertEquals(value.length(), 10);
	}
	
	@Test
	public void shouldGenerateAlphanumericString() {
		StringResolver resolver = getInstance("foo", "bar", true, 4);
		String value = resolver.resolve(String.class, 0);
		assertTrue(StringUtils.isAlphanumeric(value));
	}
	
	@Test
	public void shouldGenerateAlphabeticString() {
		StringResolver resolver = getInstance("foo", "bar", false, 10);
		String value = resolver.resolve(String.class, 0);
		assertTrue(StringUtils.isAlpha(value));
	}
	
	private StringResolver getInstance(String prefix, String suffix, boolean alphanumeric, int length) {
		Configuration configuration = new Configuration();
		configuration.setStringPrefix(prefix);
		configuration.setStringSuffix(suffix);
		configuration.setAlphanumericString(alphanumeric);
		configuration.setStringLength(length);
		StringResolver resolver = new StringResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
		return resolver;
	}
}

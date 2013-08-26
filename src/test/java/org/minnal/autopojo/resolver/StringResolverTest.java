/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class StringResolverTest {
	
	@Test
	public void shouldGenerateDefaultLengthString() {
		StringResolver resolver = new StringResolver();
		String value = resolver.resolve(String.class, 0);
		assertNotNull(value);
		assertEquals(value.length(), StringResolver.DEFAULT_LENGTH);
	}
	
	@Test
	public void shouldGenerateCustomLengthString() {
		StringResolver resolver = new StringResolver(4);
		String value = resolver.resolve(String.class, 0);
		assertEquals(value.length(), 4);
	}
	
	@Test
	public void shouldGenerateStringWithPrefixAndSuffix() {
		StringResolver resolver = new StringResolver("foo", "bar");
		String value = resolver.resolve(String.class, 0);
		assertTrue(value.startsWith("foo"));
		assertTrue(value.endsWith("bar"));
		assertEquals(value.length(), StringResolver.DEFAULT_LENGTH + 6);
	}
	
	@Test
	public void shouldGenerateCustomLengthStringWithPrefixAndSuffix() {
		StringResolver resolver = new StringResolver("foo", "bar", false, 4);
		String value = resolver.resolve(String.class, 0);
		assertTrue(value.startsWith("foo"));
		assertTrue(value.endsWith("bar"));
		assertEquals(value.length(), 10);
	}
	
	@Test
	public void shouldGenerateAlphanumericString() {
		StringResolver resolver = new StringResolver("foo", "bar", true, 4);
		String value = resolver.resolve(String.class, 0);
		assertTrue(StringUtils.isAlphanumeric(value));
	}
	
	@Test
	public void shouldGenerateAlphabeticString() {
		StringResolver resolver = new StringResolver("foo", "bar", false, 10);
		String value = resolver.resolve(String.class, 0);
		assertTrue(StringUtils.isAlpha(value));
	}
}

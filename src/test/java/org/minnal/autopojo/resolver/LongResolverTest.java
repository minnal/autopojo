/**
 * 
 */
package org.minnal.autopojo.resolver;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author ganeshs
 *
 */
public class LongResolverTest {

	@Test
	public void shouldGenerateLong() {
		LongResolver resolver = new LongResolver();
		assertNotNull(resolver.resolve(Long.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		LongResolver resolver = new LongResolver(1L, 10L);
		Long value = resolver.resolve(Long.class, 0);
		assertTrue(value >= 1L);
		assertTrue(value <= 10L);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		LongResolver resolver = new LongResolver(-10L, -1L);
		Long value = resolver.resolve(Long.class, 0);
		assertTrue(value >= -10L);
		assertTrue(value <= -1L);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		LongResolver resolver = new LongResolver(10L, 10L);
		Long value = resolver.resolve(Long.class, 0);
		assertEquals(value, Long.valueOf(10));
	}
}

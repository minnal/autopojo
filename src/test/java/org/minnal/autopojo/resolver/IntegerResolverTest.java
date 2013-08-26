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
public class IntegerResolverTest {

	@Test
	public void shouldGenerateInteger() {
		IntegerResolver resolver = new IntegerResolver();
		assertNotNull(resolver.resolve(Integer.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		IntegerResolver resolver = new IntegerResolver(1, 10);
		Integer value = resolver.resolve(Integer.class, 0);
		assertTrue(value >= 1);
		assertTrue(value <= 10);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		IntegerResolver resolver = new IntegerResolver(-10, -1);
		Integer value = resolver.resolve(Integer.class, 0);
		assertTrue(value >= -10);
		assertTrue(value <= -1);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		IntegerResolver resolver = new IntegerResolver(10, 10);
		Integer value = resolver.resolve(Integer.class, 0);
		assertEquals(value, Integer.valueOf(10));
	}
}

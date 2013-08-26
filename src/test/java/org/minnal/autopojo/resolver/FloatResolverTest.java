/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class FloatResolverTest {

	@Test
	public void shouldGenerateFloat() {
		FloatResolver resolver = new FloatResolver();
		assertNotNull(resolver.resolve(Float.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		FloatResolver resolver = new FloatResolver(1.505f, 1.509f);
		Float value = resolver.resolve(Float.class, 0);
		assertTrue(value >= 1.505f);
		assertTrue(value <= 1.509f);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		FloatResolver resolver = new FloatResolver(-10.5f, -1.5f);
		Float value = resolver.resolve(Float.class, 0);
		assertTrue(value >= -10.5d);
		assertTrue(value <= -1.5d);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		FloatResolver resolver = new FloatResolver(10.5f, 10.5f);
		Float value = resolver.resolve(Float.class, 0);
		assertEquals(value, Float.valueOf(10.5f));
	}
}

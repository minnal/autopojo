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
public class DoubleResolverTest {

	@Test
	public void shouldGenerateDouble() {
		DoubleResolver resolver = new DoubleResolver();
		assertNotNull(resolver.resolve(Double.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		DoubleResolver resolver = new DoubleResolver(1.505, 1.509);
		Double value = resolver.resolve(Double.class, 0);
		assertTrue(value >= 1.505d);
		assertTrue(value <= 1.509d);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		DoubleResolver resolver = new DoubleResolver(-10.5, -1.5);
		Double value = resolver.resolve(Double.class, 0);
		assertTrue(value >= -10.5d);
		assertTrue(value <= -1.5d);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		DoubleResolver resolver = new DoubleResolver(10.5, 10.5);
		Double value = resolver.resolve(Double.class, 0);
		assertEquals(value, Double.valueOf(10.5));
	}
}

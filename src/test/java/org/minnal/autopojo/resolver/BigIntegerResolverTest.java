/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.math.BigInteger;

import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class BigIntegerResolverTest {

	@Test
	public void shouldGenerateLong() {
		BigIntegerResolver resolver = new BigIntegerResolver();
		assertNotNull(resolver.resolve(BigInteger.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		BigIntegerResolver resolver = new BigIntegerResolver(1L, 10L);
		BigInteger value = resolver.resolve(BigInteger.class, 0);
		assertTrue(value.longValue() >= 1L);
		assertTrue(value.longValue() <= 10L);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		BigIntegerResolver resolver = new BigIntegerResolver(-10L, -1L);
		BigInteger value = resolver.resolve(BigInteger.class, 0);
		assertTrue(value.longValue() >= -10L);
		assertTrue(value.longValue() <= -1L);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		BigIntegerResolver resolver = new BigIntegerResolver(10L, 10L);
		BigInteger value = resolver.resolve(BigInteger.class, 0);
		assertEquals(value.longValue(), 10L);
	}
}

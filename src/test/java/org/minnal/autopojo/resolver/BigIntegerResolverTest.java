/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.math.BigInteger;

import org.minnal.autopojo.Configuration;
import org.minnal.autopojo.GenerationStrategy;
import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class BigIntegerResolverTest {

	@Test
	public void shouldGenerateLong() {
		BigIntegerResolver resolver = new BigIntegerResolver();
		Configuration configuration = new Configuration();
		resolver.init(new GenerationStrategy(configuration), configuration);
		assertNotNull(resolver.resolve(BigInteger.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		BigIntegerResolver resolver = getInstance(1L, 10L);
		BigInteger value = resolver.resolve(BigInteger.class, 0);
		assertTrue(value.longValue() >= 1L);
		assertTrue(value.longValue() <= 10L);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		BigIntegerResolver resolver = getInstance(-10L, -1L);
		BigInteger value = resolver.resolve(BigInteger.class, 0);
		assertTrue(value.longValue() >= -10L);
		assertTrue(value.longValue() <= -1L);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		BigIntegerResolver resolver = getInstance(10L, 10L);
		BigInteger value = resolver.resolve(BigInteger.class, 0);
		assertEquals(value.longValue(), 10L);
	}
	
	private BigIntegerResolver getInstance(long minValue, long maxValue) {
		Configuration configuration = new Configuration();
		configuration.setLongMinValue(minValue);
		configuration.setLongMaxValue(maxValue);
		BigIntegerResolver resolver = new BigIntegerResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
		return resolver;
	}
}

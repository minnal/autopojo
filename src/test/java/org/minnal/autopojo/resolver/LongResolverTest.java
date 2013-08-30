/**
 * 
 */
package org.minnal.autopojo.resolver;

import org.minnal.autopojo.Configuration;
import org.minnal.autopojo.GenerationStrategy;
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
		Configuration configuration = new Configuration();
		resolver.init(new GenerationStrategy(configuration), configuration);
		assertNotNull(resolver.resolve(Long.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		LongResolver resolver = getInstance(1L, 10L);
		Long value = resolver.resolve(Long.class, 0);
		assertTrue(value >= 1L);
		assertTrue(value <= 10L);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		LongResolver resolver = getInstance(-10L, -1L);
		Long value = resolver.resolve(Long.class, 0);
		assertTrue(value >= -10L);
		assertTrue(value <= -1L);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		LongResolver resolver = getInstance(10L, 10L);
		Long value = resolver.resolve(Long.class, 0);
		assertEquals(value, Long.valueOf(10));
	}
	
	private LongResolver getInstance(long minValue, long maxValue) {
		Configuration configuration = new Configuration();
		configuration.setLongMinValue(minValue);
		configuration.setLongMaxValue(maxValue);
		LongResolver resolver = new LongResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
		return resolver;
	}
}

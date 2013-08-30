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
public class IntegerResolverTest {

	@Test
	public void shouldGenerateInteger() {
		IntegerResolver resolver = new IntegerResolver();
		Configuration configuration = new Configuration();
		resolver.init(new GenerationStrategy(configuration), configuration);
		assertNotNull(resolver.resolve(Integer.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		IntegerResolver resolver = getInstance(1, 10);
		Integer value = resolver.resolve(Integer.class, 0);
		assertTrue(value >= 1);
		assertTrue(value <= 10);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		IntegerResolver resolver = getInstance(-10, -1);
		Integer value = resolver.resolve(Integer.class, 0);
		assertTrue(value >= -10);
		assertTrue(value <= -1);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		IntegerResolver resolver = getInstance(10, 10);
		Integer value = resolver.resolve(Integer.class, 0);
		assertEquals(value, Integer.valueOf(10));
	}
	
	private IntegerResolver getInstance(int minValue, int maxValue) {
		Configuration configuration = new Configuration();
		configuration.setIntegerMinValue(minValue);
		configuration.setIntegerMaxValue(maxValue);
		IntegerResolver resolver = new IntegerResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
		return resolver;
	}
}

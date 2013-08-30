/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.minnal.autopojo.Configuration;
import org.minnal.autopojo.GenerationStrategy;
import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class DoubleResolverTest {

	@Test
	public void shouldGenerateDouble() {
		DoubleResolver resolver = new DoubleResolver();
		Configuration configuration = new Configuration();
		resolver.init(new GenerationStrategy(configuration), configuration);
		assertNotNull(resolver.resolve(Double.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		DoubleResolver resolver = getInstance(1.505, 1.509);
		Double value = resolver.resolve(Double.class, 0);
		assertTrue(value >= 1.505d);
		assertTrue(value <= 1.509d);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		DoubleResolver resolver = getInstance(-10.5, -1.5);
		Double value = resolver.resolve(Double.class, 0);
		assertTrue(value >= -10.5d);
		assertTrue(value <= -1.5d);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		DoubleResolver resolver = getInstance(10.5, 10.5);
		Double value = resolver.resolve(Double.class, 0);
		assertEquals(value, Double.valueOf(10.5));
	}
	
	private DoubleResolver getInstance(double minValue, double maxValue) {
		Configuration configuration = new Configuration();
		configuration.setDoubleMinValue(minValue);
		configuration.setDoubleMaxValue(maxValue);
		DoubleResolver resolver = new DoubleResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
		return resolver;
	}
}

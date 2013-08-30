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
public class FloatResolverTest {

	@Test
	public void shouldGenerateFloat() {
		FloatResolver resolver = new FloatResolver();
		Configuration configuration = new Configuration();
		resolver.init(new GenerationStrategy(configuration), configuration);
		assertNotNull(resolver.resolve(Float.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		FloatResolver resolver = getInstance(1.505f, 1.509f);
		Float value = resolver.resolve(Float.class, 0);
		assertTrue(value >= 1.505f);
		assertTrue(value <= 1.509f);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		FloatResolver resolver = getInstance(-10.5f, -1.5f);
		Float value = resolver.resolve(Float.class, 0);
		assertTrue(value >= -10.5d);
		assertTrue(value <= -1.5d);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		FloatResolver resolver = getInstance(10.5f, 10.5f);
		Float value = resolver.resolve(Float.class, 0);
		assertEquals(value, Float.valueOf(10.5f));
	}
	
	private FloatResolver getInstance(float minValue, float maxValue) {
		Configuration configuration = new Configuration();
		configuration.setFloatMinValue(minValue);
		configuration.setFloatMaxValue(maxValue);
		FloatResolver resolver = new FloatResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
		return resolver;
	}
}

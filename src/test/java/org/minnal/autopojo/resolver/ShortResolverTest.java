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
public class ShortResolverTest {

	@Test
	public void shouldGenerateShort() {
		ShortResolver resolver = new ShortResolver();
		Configuration configuration = new Configuration();
		resolver.init(new GenerationStrategy(configuration), configuration);
		assertNotNull(resolver.resolve(Short.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		ShortResolver resolver = getInstance((short)1, (short)10);
		Short value = resolver.resolve(Short.class, 0);
		assertTrue(value >= 1);
		assertTrue(value <= 10);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		ShortResolver resolver = getInstance((short)-10, (short)-1);
		Short value = resolver.resolve(Short.class, 0);
		assertTrue(value >= -10);
		assertTrue(value <= -1);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		ShortResolver resolver = getInstance((short)10, (short)10);
		Short value = resolver.resolve(Short.class, 0);
		assertEquals(value, Short.valueOf((short) 10));
	}
	
	private ShortResolver getInstance(short minValue, short maxValue) {
		Configuration configuration = new Configuration();
		configuration.setShortMinValue(minValue);
		configuration.setShortMaxValue(maxValue);
		ShortResolver resolver = new ShortResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
		return resolver;
	}
}

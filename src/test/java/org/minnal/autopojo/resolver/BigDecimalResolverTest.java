/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;

import org.minnal.autopojo.Configuration;
import org.minnal.autopojo.GenerationStrategy;
import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class BigDecimalResolverTest {
	
	@Test
	public void shouldGenerateBigDecimal() {
		BigDecimalResolver resolver = new BigDecimalResolver();
		Configuration configuration = new Configuration();
		resolver.init(new GenerationStrategy(configuration), configuration);
		assertNotNull(resolver.resolve(BigDecimal.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		BigDecimalResolver resolver = getInstance(1.505, 1.509);
		BigDecimal value = resolver.resolve(BigDecimal.class, 0);
		assertTrue(value.doubleValue() >= 1.505d);
		assertTrue(value.doubleValue() <= 1.509d);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		BigDecimalResolver resolver = getInstance(-10.5, -1.5);
		BigDecimal value = resolver.resolve(BigDecimal.class, 0);
		assertTrue(value.doubleValue() >= -10.5d);
		assertTrue(value.doubleValue() <= -1.5d);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		BigDecimalResolver resolver = getInstance(10.5, 10.5);
		BigDecimal value = resolver.resolve(BigDecimal.class, 0);
		assertEquals(value, BigDecimal.valueOf(10.5));
	}
	
	private BigDecimalResolver getInstance(double minValue, double maxValue) {
		Configuration configuration = new Configuration();
		configuration.setDoubleMinValue(minValue);
		configuration.setDoubleMaxValue(maxValue);
		BigDecimalResolver resolver = new BigDecimalResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
		return resolver;
	}
}

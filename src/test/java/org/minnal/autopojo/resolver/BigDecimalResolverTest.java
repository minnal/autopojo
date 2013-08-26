/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;

import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class BigDecimalResolverTest {

	@Test
	public void shouldGenerateBigDecimal() {
		BigDecimalResolver resolver = new BigDecimalResolver();
		assertNotNull(resolver.resolve(BigDecimal.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		BigDecimalResolver resolver = new BigDecimalResolver(1.505, 1.509);
		BigDecimal value = resolver.resolve(BigDecimal.class, 0);
		assertTrue(value.doubleValue() >= 1.505d);
		assertTrue(value.doubleValue() <= 1.509d);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		BigDecimalResolver resolver = new BigDecimalResolver(-10.5, -1.5);
		BigDecimal value = resolver.resolve(BigDecimal.class, 0);
		assertTrue(value.doubleValue() >= -10.5d);
		assertTrue(value.doubleValue() <= -1.5d);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		BigDecimalResolver resolver = new BigDecimalResolver(10.5, 10.5);
		BigDecimal value = resolver.resolve(BigDecimal.class, 0);
		assertEquals(value, BigDecimal.valueOf(10.5));
	}
}

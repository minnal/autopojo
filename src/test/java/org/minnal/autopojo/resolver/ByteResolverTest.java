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
public class ByteResolverTest {

	@Test
	public void shouldGenerateByte() {
		ByteResolver resolver = new ByteResolver();
		Configuration configuration = new Configuration();
		resolver.init(new GenerationStrategy(configuration), configuration);
		assertNotNull(resolver.resolve(Byte.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		ByteResolver resolver = getInstance((byte)1, (byte)10);
		Byte value = resolver.resolve(Byte.class, 0);
		assertTrue(value >= 1);
		assertTrue(value <= 10);
	}
	
	@Test
	public void shouldGenerateWithinNegativeRange() {
		ByteResolver resolver = getInstance((byte)-10, (byte)-1);
		Byte value = resolver.resolve(Byte.class, 0);
		assertTrue(value >= -10);
		assertTrue(value <= -1);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		ByteResolver resolver = getInstance((byte)10, (byte)10);
		Byte value = resolver.resolve(Byte.class, 0);
		assertEquals(value, Byte.valueOf((byte) 10));
	}
	
	private ByteResolver getInstance(byte minValue, byte maxValue) {
		Configuration configuration = new Configuration();
		configuration.setByteMinValue(minValue);
		configuration.setByteMaxValue(maxValue);
		ByteResolver resolver = new ByteResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
		return resolver;
	}
}

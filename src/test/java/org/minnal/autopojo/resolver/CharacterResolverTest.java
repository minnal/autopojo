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
public class CharacterResolverTest {

	@Test
	public void shouldGenerateCharacter() {
		CharacterResolver resolver = new CharacterResolver();
		Configuration configuration = new Configuration();
		resolver.init(new GenerationStrategy(configuration), configuration);
		assertNotNull(resolver.resolve(Character.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		CharacterResolver resolver = getInstance((char)1, (char)10);
		Character value = resolver.resolve(Character.class, 0);
		assertTrue(value >= 1);
		assertTrue(value <= 10);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		CharacterResolver resolver = getInstance((char)10, (char)10);
		Character value = resolver.resolve(Character.class, 0);
		assertEquals(value, Character.valueOf((char) 10));
	}
	
	private CharacterResolver getInstance(char minValue, char maxValue) {
		Configuration configuration = new Configuration();
		configuration.setCharMinValue(minValue);
		configuration.setCharMaxValue(maxValue);
		CharacterResolver resolver = new CharacterResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
		return resolver;
	}
}

/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class CharacterResolverTest {

	@Test
	public void shouldGenerateCharacter() {
		CharacterResolver resolver = new CharacterResolver();
		assertNotNull(resolver.resolve(Character.class, 0));
	}
	
	@Test
	public void shouldGenerateWithinRange() {
		CharacterResolver resolver = new CharacterResolver((char)1, (char)10);
		Character value = resolver.resolve(Character.class, 0);
		assertTrue(value >= 1);
		assertTrue(value <= 10);
	}
	
	@Test
	public void shouldGenerateOnNoRange() {
		CharacterResolver resolver = new CharacterResolver((char)10, (char)10);
		Character value = resolver.resolve(Character.class, 0);
		assertEquals(value, Character.valueOf((char) 10));
	}
}

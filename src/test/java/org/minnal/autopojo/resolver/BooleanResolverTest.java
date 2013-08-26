/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class BooleanResolverTest {

	@Test
	public void shouldGenerateBoolean() {
		BooleanResolver resolver = new BooleanResolver();
		assertTrue(resolver.resolve(Boolean.class, 0));
	}
}

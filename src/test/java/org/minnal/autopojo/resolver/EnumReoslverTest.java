/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;

import org.minnal.autopojo.SimpleEnum;
import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class EnumReoslverTest {

	@Test
	public void shouldGenerateEnum() {
		EnumResolver resolver = new EnumResolver();
		assertEquals(resolver.resolve(SimpleEnum.class, 1), SimpleEnum.value1);
	}
}

/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;

import java.sql.Date;

import org.minnal.autopojo.Configuration;
import org.minnal.autopojo.GenerationStrategy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class DateResolverTest {
	
	private DateResolver resolver;
	
	private Configuration configuration; 
	
	@BeforeMethod
	public void setup() {
		configuration = new Configuration();
		resolver = new DateResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
	}

	@Test
	public void shouldGenerateDate() {
		assertEquals(resolver.resolve(Date.class, 1), new Date(System.currentTimeMillis()));
	}
}

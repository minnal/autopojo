/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;

import java.sql.Timestamp;

import org.minnal.autopojo.Configuration;
import org.minnal.autopojo.GenerationStrategy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class TimestampResolverTest {
	
	private TimestampResolver resolver;
	
	private Configuration configuration; 
	
	@BeforeMethod
	public void setup() {
		configuration = new Configuration();
		resolver = new TimestampResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
	}

	@Test
	public void shouldGenerateTimestamp() {
		assertEquals(resolver.resolve(Timestamp.class, 1), new Timestamp(System.currentTimeMillis()));
	}
}

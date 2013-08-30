/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.beans.PropertyDescriptor;

import org.minnal.autopojo.AttributeMetaData;
import org.minnal.autopojo.CollectionModel;
import org.minnal.autopojo.Configuration;
import org.minnal.autopojo.GenerationStrategy;
import org.minnal.autopojo.SimpleObject;
import org.minnal.autopojo.util.PropertyUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class ArrayResolverTest {
	
	private ArrayResolver resolver;
	
	private Configuration configuration; 
	
	@BeforeMethod
	public void setup() {
		configuration = new Configuration();
		resolver = new ArrayResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
	}

	@Test
	public void shouldGenerateAnyObjectArray() {
		generateAndCheckArray("anyObjectArray", Object.class);
	}
	
	@Test
	public void shouldGenerateGenericString() {
		generateAndCheckArray("stringArray", String.class);
	}
	
	@Test
	public void shouldGenerateGenericObjectArray() {
		generateAndCheckArray("objectArray", SimpleObject.class);
	}
	
	@Test
	public void shouldGenerateSpecifiedNoOfElements() {
		configuration.setNoOfElementsInCollection(10);
		resolver = new ArrayResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
		generateAndCheckArray("anyObjectArray", Object.class, 10);
	}
	
	private void generateAndCheckArray(String propertyName, Class<?> elementClass) {
		generateAndCheckArray(propertyName, elementClass, configuration.getNoOfElementsInCollection());
	}
	
	private void generateAndCheckArray(String propertyName, Class<?> elementClass, int count) {
		CollectionModel model = new CollectionModel();
		PropertyDescriptor descriptor = PropertyUtil.getDescriptor(CollectionModel.class, propertyName);
		resolver.resolve(model, new AttributeMetaData(descriptor), 10);
		Object[] array = null;
		try {
			array = (Object[]) descriptor.getReadMethod().invoke(model);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		assertEquals(array.length, count);
		assertTrue(array[0].getClass().equals(elementClass));
	}
}

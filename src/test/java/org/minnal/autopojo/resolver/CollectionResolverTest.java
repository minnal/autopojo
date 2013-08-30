/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
public class CollectionResolverTest {
	
	private CollectionResolver resolver;
	
	private Configuration configuration; 
	
	@BeforeMethod
	public void setup() {
		configuration = new Configuration();
		resolver = new CollectionResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
	}

	@Test
	public void shouldGenerateNonGenericList() {
		generateAndCheckCollection("nonGenericList", List.class, Object.class);
	}
	
	@Test
	public void shouldGenerateGenericStringList() {
		generateAndCheckCollection("genericStringList", List.class, String.class);
	}
	
	@Test
	public void shouldGenerateGenericObjectList() {
		generateAndCheckCollection("genericObjectList", List.class, SimpleObject.class);
	}
	
	@Test
	public void shouldGenerateNonGenericSet() {
		generateAndCheckCollection("nonGenericSet", Set.class, Object.class);
	}
	
	@Test
	public void shouldGenerateGenericStringSet() {
		generateAndCheckCollection("genericStringSet", Set.class, String.class);
	}
	
	@Test
	public void shouldGenerateGenericObjectSet() {
		generateAndCheckCollection("genericObjectSet", Set.class, SimpleObject.class);
	}
	
	@Test
	public void shouldGenerateNonGenericQueue() {
		generateAndCheckCollection("nonGenericQueue", Queue.class, Object.class);
	}
	
	@Test
	public void shouldGenerateGenericStringQueue() {
		generateAndCheckCollection("genericStringQueue", Queue.class, String.class);
	}
	
	@Test
	public void shouldGenerateGenericObjectQueue() {
		generateAndCheckCollection("genericObjectQueue", Queue.class, SimpleObject.class);
	}
	
	@Test
	public void shouldGenerateSpecifiedNoOfElements() {
		configuration.setNoOfElementsInCollection(10);
		resolver = new CollectionResolver();
		resolver.init(new GenerationStrategy(configuration), configuration);
		generateAndCheckCollection("nonGenericList", List.class, Object.class, 10);
	}
	
	private void generateAndCheckCollection(String propertyName, Class<?> collectionType, Class<?> elementClass) {
		generateAndCheckCollection(propertyName, collectionType, elementClass, configuration.getNoOfElementsInCollection());
	}
	
	private void generateAndCheckCollection(String propertyName, Class<?> collectionType, Class<?> elementClass, int count) {
		CollectionModel model = new CollectionModel();
		PropertyDescriptor descriptor = PropertyUtil.getDescriptor(CollectionModel.class, propertyName);
		resolver.resolve(model, new AttributeMetaData(descriptor), 10);
		Collection<?> collection = null;
		try {
			collection = (Collection<?>) descriptor.getReadMethod().invoke(model);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		assertEquals(collection.size(), count);
		assertTrue(collection.iterator().next().getClass().equals(elementClass));
	}
}

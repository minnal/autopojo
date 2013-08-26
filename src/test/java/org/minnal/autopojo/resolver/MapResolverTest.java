/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.beans.PropertyDescriptor;
import java.util.Map;

import org.minnal.autopojo.AttributeMetaData;
import org.minnal.autopojo.CollectionModel;
import org.minnal.autopojo.GenerationStrategy;
import org.minnal.autopojo.SimpleObject;
import org.minnal.autopojo.util.PropertyUtil;
import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class MapResolverTest {
	
	private MapResolver resolver = new MapResolver(new GenerationStrategy());

	@Test
	public void shouldGenerateNonGenericMap() {
		generateAndCheckMap("nonGenericMap", Object.class, Object.class);
	}
	
	@Test
	public void shouldGenerateGenericStringObjectMap() {
		generateAndCheckMap("genericStringObjectMap", String.class, SimpleObject.class);
	}
	
	@Test
	public void shouldGenerateGenericObjectObjectMap() {
		generateAndCheckMap("genericObjectObjectMap", SimpleObject.class, SimpleObject.class);
	}
	
	@Test
	public void shouldGenerateSpecifiedNoOfElements() {
		resolver = new MapResolver(new GenerationStrategy(), 10);
		generateAndCheckMap("nonGenericMap", Object.class, Object.class, 10);
	}
	
	private void generateAndCheckMap(String propertyName, Class<?> keyClass, Class<?> valueClass) {
		generateAndCheckMap(propertyName, keyClass, valueClass, MapResolver.DEFAULT_NO_OF_ELEMENTS);
	}
	
	private void generateAndCheckMap(String propertyName, Class<?> keyClass, Class<?> valueClass, int count) {
		CollectionModel model = new CollectionModel();
		PropertyDescriptor descriptor = PropertyUtil.getDescriptor(CollectionModel.class, propertyName);
		resolver.resolve(model, new AttributeMetaData(descriptor), 5);
		Map<?, ?> map = null;
		try {
			map = (Map<?, ?>) descriptor.getReadMethod().invoke(model);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		assertEquals(map.size(), count);
		assertTrue(map.entrySet().iterator().next().getKey().getClass().equals(keyClass));
		assertTrue(map.entrySet().iterator().next().getValue().getClass().equals(valueClass));
	}
}

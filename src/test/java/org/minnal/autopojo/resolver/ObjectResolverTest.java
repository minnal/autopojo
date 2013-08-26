/**
 * 
 */
package org.minnal.autopojo.resolver;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.minnal.autopojo.CustomExclude;
import org.minnal.autopojo.GenerationStrategy;
import org.minnal.autopojo.GenericObject;
import org.minnal.autopojo.NestedObjectThroughCollection;
import org.minnal.autopojo.ObjectWithExcludeFields;
import org.minnal.autopojo.OneLevelNestedObject;
import org.minnal.autopojo.SimpleObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author ganeshs
 *
 */
public class ObjectResolverTest {
	
	private ObjectResolver resolver;
	
	@BeforeMethod
	public void setup() {
		resolver = new ObjectResolver(new GenerationStrategy());
	}

	@Test
	public void shouldResolveSimpleObject() {
		SimpleObject object = (SimpleObject) resolver.resolve(SimpleObject.class, 1);
		verifySimpleObject(object);
	}
	
	@Test
	public void shouldResolveOneLevelNestedObject() {
		OneLevelNestedObject object = (OneLevelNestedObject) resolver.resolve(OneLevelNestedObject.class, 10);
		verifyOneLevelNestedObject(object);
	}
	
	@Test
	public void shouldResolvedNestedObjectThroughCollection() {
		NestedObjectThroughCollection collection = (NestedObjectThroughCollection) resolver.resolve(NestedObjectThroughCollection.class, 10);
		assertNotNull(collection.getNestedObjectList());
		assertNotNull(collection.getSimpleObjectSet());
		assertNotNull(collection.getSimpleObjectMap());
		verifyOneLevelNestedObject(collection.getNestedObjectList().get(0));
		verifySimpleObject(collection.getSimpleObjectSet().iterator().next());
		verifySimpleObject(collection.getSimpleObjectMap().entrySet().iterator().next().getValue());
	}
	
	@Test
	public void shouldExcludeFieldsMarkedWithExcludeAnnotation() {
		ObjectWithExcludeFields object = (ObjectWithExcludeFields) resolver.resolve(ObjectWithExcludeFields.class, 10);
		assertNull(object.getSimpleExcludedObject());
		assertNotNull(object.getString());
		assertNotNull(object.getLongValue());
		verifySimpleObject(object.getCustomExcludedObject());
	}
	
	@Test
	public void shouldExcludeFieldsMarkedWithCustomExcludeAnnotation() {
		List<Class<? extends Annotation>> annotations = new ArrayList<Class<? extends Annotation>>();
		annotations.add(CustomExclude.class);
		resolver = new ObjectResolver(new GenerationStrategy(), annotations, null);
		ObjectWithExcludeFields object = (ObjectWithExcludeFields) resolver.resolve(ObjectWithExcludeFields.class, 10);
		assertNull(object.getSimpleExcludedObject());
		assertNull(object.getCustomExcludedObject());
		assertNotNull(object.getString());
		assertNotNull(object.getLongValue());
		assertNotNull(object.getFieldToBeExcluded());
	}
	
	@Test
	public void shouldExcludeFieldsFromExcludedFieldList() {
		resolver = new ObjectResolver(new GenerationStrategy(), null, Arrays.asList("fieldToBeExcluded"));
		ObjectWithExcludeFields object = (ObjectWithExcludeFields) resolver.resolve(ObjectWithExcludeFields.class, 10);
		assertNull(object.getFieldToBeExcluded());
	}
	
	@Test
	public void shouldResolveGenericObject() {
		resolver.resolve(GenericObject.class, 0, String.class, Long.class);
	}
	
	private void verifyOneLevelNestedObject(OneLevelNestedObject object) {
		verifySimpleObject(object.getFirstObject());
		verifySimpleObject(object.getSecondObject());
	}
	
	private void verifySimpleObject(SimpleObject object) {
		assertTrue(object.getPrimitiveInteger() > 0);
		assertTrue(object.getPrimitiveLong() > 0);
		assertTrue(object.getPrimitiveDouble() > 0);
		assertTrue(object.getPrimitiveFloat() > 0);
		assertTrue(object.getPrimitiveShort() > 0);
		System.out.println(object.getPrimitiveByte());
		assertTrue(object.getPrimitiveByte() > 0);
		assertTrue(object.getPrimitiveChar() > 0);
		assertTrue(object.isPrimitiveBoolean());
		assertNotNull(object.getString());
		assertNotNull(object.getWrapperInteger());
		assertNotNull(object.getWrapperLong());
		assertNotNull(object.getWrapperBoolean());
		assertNotNull(object.getWrapperDouble());
		assertNotNull(object.getWrapperFloat());
		assertNotNull(object.getWrapperShort());
		assertNotNull(object.getWrapperByte());
		assertNotNull(object.getWrapperChar());
	}
}

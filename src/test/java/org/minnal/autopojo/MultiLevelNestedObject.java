/**
 * 
 */
package org.minnal.autopojo;

/**
 * @author ganeshs
 *
 */
public class MultiLevelNestedObject {

	private OneLevelNestedObject nestedObject1;
	
	private OneLevelNestedObject nestedObject2;
	
	private SimpleObject simpleObject;
	
	private NestedObjectThroughCollection nestedObjectThroughCollection;

	/**
	 * @return the nestedObject1
	 */
	public OneLevelNestedObject getNestedObject1() {
		return nestedObject1;
	}

	/**
	 * @param nestedObject1 the nestedObject1 to set
	 */
	public void setNestedObject1(OneLevelNestedObject nestedObject1) {
		this.nestedObject1 = nestedObject1;
	}

	/**
	 * @return the nestedObject2
	 */
	public OneLevelNestedObject getNestedObject2() {
		return nestedObject2;
	}

	/**
	 * @param nestedObject2 the nestedObject2 to set
	 */
	public void setNestedObject2(OneLevelNestedObject nestedObject2) {
		this.nestedObject2 = nestedObject2;
	}

	/**
	 * @return the simpleObject
	 */
	public SimpleObject getSimpleObject() {
		return simpleObject;
	}

	/**
	 * @param simpleObject the simpleObject to set
	 */
	public void setSimpleObject(SimpleObject simpleObject) {
		this.simpleObject = simpleObject;
	}

	/**
	 * @return the nestedObjectThroughCollection
	 */
	public NestedObjectThroughCollection getNestedObjectThroughCollection() {
		return nestedObjectThroughCollection;
	}

	/**
	 * @param nestedObjectThroughCollection the nestedObjectThroughCollection to set
	 */
	public void setNestedObjectThroughCollection(
			NestedObjectThroughCollection nestedObjectThroughCollection) {
		this.nestedObjectThroughCollection = nestedObjectThroughCollection;
	}
}

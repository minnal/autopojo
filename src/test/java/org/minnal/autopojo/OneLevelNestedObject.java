/**
 * 
 */
package org.minnal.autopojo;

/**
 * @author ganeshs
 *
 */
public class OneLevelNestedObject {

	private SimpleObject firstObject;
	
	private SimpleObject secondObject;

	/**
	 * @return the firstObject
	 */
	public SimpleObject getFirstObject() {
		return firstObject;
	}

	/**
	 * @param firstObject the firstObject to set
	 */
	public void setFirstObject(SimpleObject firstObject) {
		this.firstObject = firstObject;
	}

	/**
	 * @return the secondObject
	 */
	public SimpleObject getSecondObject() {
		return secondObject;
	}

	/**
	 * @param secondObject the secondObject to set
	 */
	public void setSecondObject(SimpleObject secondObject) {
		this.secondObject = secondObject;
	}
}

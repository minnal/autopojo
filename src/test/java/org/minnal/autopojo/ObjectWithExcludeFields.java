/**
 * 
 */
package org.minnal.autopojo;

import org.minnal.autopojo.annotations.Exclude;

/**
 * @author ganeshs
 *
 */
public class ObjectWithExcludeFields {

	@Exclude
	private SimpleObject simpleExcludedObject;
	
	@CustomExclude
	private SimpleObject customExcludedObject;
	
	private String string;
	
	private Long longValue;
	
	private SimpleObject fieldToBeExcluded;

	/**
	 * @return the simpleExcludedObject
	 */
	public SimpleObject getSimpleExcludedObject() {
		return simpleExcludedObject;
	}

	/**
	 * @param simpleExcludedObject the simpleExcludedObject to set
	 */
	public void setSimpleExcludedObject(SimpleObject simpleExcludedObject) {
		this.simpleExcludedObject = simpleExcludedObject;
	}

	/**
	 * @return the customExcludedObject
	 */
	public SimpleObject getCustomExcludedObject() {
		return customExcludedObject;
	}

	/**
	 * @param customExcludedObject the customExcludedObject to set
	 */
	public void setCustomExcludedObject(SimpleObject customExcludedObject) {
		this.customExcludedObject = customExcludedObject;
	}

	/**
	 * @return the string
	 */
	public String getString() {
		return string;
	}

	/**
	 * @param string the string to set
	 */
	public void setString(String string) {
		this.string = string;
	}

	/**
	 * @return the longValue
	 */
	public Long getLongValue() {
		return longValue;
	}

	/**
	 * @param longValue the longValue to set
	 */
	public void setLongValue(Long longValue) {
		this.longValue = longValue;
	}

	/**
	 * @return the fieldToBeExcluded
	 */
	public SimpleObject getFieldToBeExcluded() {
		return fieldToBeExcluded;
	}

	/**
	 * @param fieldToBeExcluded the fieldToBeExcluded to set
	 */
	public void setFieldToBeExcluded(SimpleObject fieldToBeExcluded) {
		this.fieldToBeExcluded = fieldToBeExcluded;
	}
}

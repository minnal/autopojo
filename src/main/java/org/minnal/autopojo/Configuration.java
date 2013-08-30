/**
 * 
 */
package org.minnal.autopojo;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.minnal.autopojo.annotations.Exclude;

/**
 * @author ganeshs
 *
 */
public class Configuration {

	private Set<Class<? extends Annotation>> excludeAnnotations = new HashSet<Class<? extends Annotation>>();
	
	private Set<String> excludeFields = new HashSet<String>();
	
	private int maxDepth = 5;
	
	private int maxCompositeDepth = 1;
	
	private String stringPrefix = "";
	
	private String stringSuffix = "";
	
	private int stringLength = 10;
	
	private boolean alphanumericString;
	
	private int noOfElementsInCollection = 5;
	
	private int integerMinValue = 100;
	
	private int integerMaxValue = 100000;
	
	private long longMinValue = 100;
	
	private long longMaxValue = 100000;
	
	private double doubleMinValue = 100;
	
	private double doubleMaxValue = 100000;
	
	private float floatMinValue = 100;
	
	private float floatMaxValue = 100000;
	
	private byte byteMinValue = 1;
	
	private byte byteMaxValue = 120;
	
	private char charMinValue = 45;
	
	private char charMaxValue = 96;
	
	private short shortMinValue = 10;
	
	private short shortMaxValue = 1000;
	
	/**
	 * Default constructor
	 */
	public Configuration() {
		excludeAnnotations.add(Exclude.class);
	}

	/**
	 * @return the excludeAnnotations
	 */
	public Set<Class<? extends Annotation>> getExcludeAnnotations() {
		return excludeAnnotations;
	}

	/**
	 * @param excludeAnnotations the excludeAnnotations to set
	 */
	public void setExcludeAnnotations(Set<Class<? extends Annotation>> excludeAnnotations) {
		this.excludeAnnotations.addAll(excludeAnnotations);
	}

	/**
	 * @return the excludeFields
	 */
	public Set<String> getExcludeFields() {
		return excludeFields;
	}

	/**
	 * @param excludeFields the excludeFields to set
	 */
	public void setExcludeFields(Set<String> excludeFields) {
		this.excludeFields.addAll(excludeFields);
	}

	/**
	 * @return the maxDepth
	 */
	public int getMaxDepth() {
		return maxDepth;
	}

	/**
	 * @param maxDepth the maxDepth to set
	 */
	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}

	/**
	 * @return the maxCompositeDepth
	 */
	public int getMaxCompositeDepth() {
		return maxCompositeDepth;
	}

	/**
	 * @param maxCompositeDepth the maxCompositeDepth to set
	 */
	public void setMaxCompositeDepth(int maxCompositeDepth) {
		this.maxCompositeDepth = maxCompositeDepth;
	}

	/**
	 * @return the stringPrefix
	 */
	public String getStringPrefix() {
		return stringPrefix;
	}

	/**
	 * @param stringPrefix the stringPrefix to set
	 */
	public void setStringPrefix(String stringPrefix) {
		this.stringPrefix = stringPrefix;
	}

	/**
	 * @return the stringSuffix
	 */
	public String getStringSuffix() {
		return stringSuffix;
	}

	/**
	 * @param stringSuffix the stringSuffix to set
	 */
	public void setStringSuffix(String stringPuffix) {
		this.stringSuffix = stringPuffix;
	}

	/**
	 * @return the alphanumericString
	 */
	public boolean isAlphanumericString() {
		return alphanumericString;
	}

	/**
	 * @param alphanumericString the alphanumericString to set
	 */
	public void setAlphanumericString(boolean alphanumericString) {
		this.alphanumericString = alphanumericString;
	}

	/**
	 * @return the noOfElementsInCollection
	 */
	public int getNoOfElementsInCollection() {
		return noOfElementsInCollection;
	}

	/**
	 * @param noOfElementsInCollection the noOfElementsInCollection to set
	 */
	public void setNoOfElementsInCollection(int noOfElementsInCollection) {
		this.noOfElementsInCollection = noOfElementsInCollection;
	}

	/**
	 * @return the integerMinValue
	 */
	public int getIntegerMinValue() {
		return integerMinValue;
	}

	/**
	 * @param integerMinValue the integerMinValue to set
	 */
	public void setIntegerMinValue(int integerMinValue) {
		this.integerMinValue = integerMinValue;
	}

	/**
	 * @return the integerMaxValue
	 */
	public int getIntegerMaxValue() {
		return integerMaxValue;
	}

	/**
	 * @param integerMaxValue the integerMaxValue to set
	 */
	public void setIntegerMaxValue(int integerMaxValue) {
		this.integerMaxValue = integerMaxValue;
	}

	/**
	 * @return the longMinValue
	 */
	public long getLongMinValue() {
		return longMinValue;
	}

	/**
	 * @param longMinValue the longMinValue to set
	 */
	public void setLongMinValue(long longMinValue) {
		this.longMinValue = longMinValue;
	}

	/**
	 * @return the longMaxValue
	 */
	public long getLongMaxValue() {
		return longMaxValue;
	}

	/**
	 * @param longMaxValue the longMaxValue to set
	 */
	public void setLongMaxValue(long longMaxValue) {
		this.longMaxValue = longMaxValue;
	}

	/**
	 * @return the doubleMinValue
	 */
	public double getDoubleMinValue() {
		return doubleMinValue;
	}

	/**
	 * @param doubleMinValue the doubleMinValue to set
	 */
	public void setDoubleMinValue(double doubleMinValue) {
		this.doubleMinValue = doubleMinValue;
	}

	/**
	 * @return the doubleMaxValue
	 */
	public double getDoubleMaxValue() {
		return doubleMaxValue;
	}

	/**
	 * @param doubleMaxValue the doubleMaxValue to set
	 */
	public void setDoubleMaxValue(double doubleMaxValue) {
		this.doubleMaxValue = doubleMaxValue;
	}

	/**
	 * @return the floatMinValue
	 */
	public float getFloatMinValue() {
		return floatMinValue;
	}

	/**
	 * @param floatMinValue the floatMinValue to set
	 */
	public void setFloatMinValue(float floatMinValue) {
		this.floatMinValue = floatMinValue;
	}

	/**
	 * @return the floatMaxValue
	 */
	public float getFloatMaxValue() {
		return floatMaxValue;
	}

	/**
	 * @param floatMaxValue the floatMaxValue to set
	 */
	public void setFloatMaxValue(float floatMaxValue) {
		this.floatMaxValue = floatMaxValue;
	}

	/**
	 * @return the byteMinValue
	 */
	public byte getByteMinValue() {
		return byteMinValue;
	}

	/**
	 * @param byteMinValue the byteMinValue to set
	 */
	public void setByteMinValue(byte byteMinValue) {
		this.byteMinValue = byteMinValue;
	}

	/**
	 * @return the byteMaxValue
	 */
	public byte getByteMaxValue() {
		return byteMaxValue;
	}

	/**
	 * @param byteMaxValue the byteMaxValue to set
	 */
	public void setByteMaxValue(byte byteMaxValue) {
		this.byteMaxValue = byteMaxValue;
	}

	/**
	 * @return the charMinValue
	 */
	public char getCharMinValue() {
		return charMinValue;
	}

	/**
	 * @param charMinValue the charMinValue to set
	 */
	public void setCharMinValue(char charMinValue) {
		this.charMinValue = charMinValue;
	}

	/**
	 * @return the charMaxValue
	 */
	public char getCharMaxValue() {
		return charMaxValue;
	}

	/**
	 * @param charMaxValue the charMaxValue to set
	 */
	public void setCharMaxValue(char charMaxValue) {
		this.charMaxValue = charMaxValue;
	}

	/**
	 * @return the shortMinValue
	 */
	public short getShortMinValue() {
		return shortMinValue;
	}

	/**
	 * @param shortMinValue the shortMinValue to set
	 */
	public void setShortMinValue(short shortMinValue) {
		this.shortMinValue = shortMinValue;
	}

	/**
	 * @return the shortMaxValue
	 */
	public short getShortMaxValue() {
		return shortMaxValue;
	}

	/**
	 * @param shortMaxValue the shortMaxValue to set
	 */
	public void setShortMaxValue(short shortMaxValue) {
		this.shortMaxValue = shortMaxValue;
	}

	/**
	 * @return the stringLength
	 */
	public int getStringLength() {
		return stringLength;
	}

	/**
	 * @param stringLength the stringLength to set
	 */
	public void setStringLength(int stringLength) {
		this.stringLength = stringLength;
	}
}

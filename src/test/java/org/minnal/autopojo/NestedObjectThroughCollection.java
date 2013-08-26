/**
 * 
 */
package org.minnal.autopojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ganeshs
 *
 */
public class NestedObjectThroughCollection {

	private List<OneLevelNestedObject> nestedObjectList;
	
	private Set<SimpleObject> simpleObjectSet;
	
	private Map<String, SimpleObject> simpleObjectMap;

	/**
	 * @return the simpleObjectSet
	 */
	public Set<SimpleObject> getSimpleObjectSet() {
		return simpleObjectSet;
	}

	/**
	 * @param simpleObjectSet the simpleObjectSet to set
	 */
	public void setSimpleObjectSet(Set<SimpleObject> simpleObjectSet) {
		this.simpleObjectSet = simpleObjectSet;
	}

	/**
	 * @return the nestedObjectList
	 */
	public List<OneLevelNestedObject> getNestedObjectList() {
		return nestedObjectList;
	}

	/**
	 * @param nestedObjectList the nestedObjectList to set
	 */
	public void setNestedObjectList(List<OneLevelNestedObject> nestedObjectList) {
		this.nestedObjectList = nestedObjectList;
	}

	/**
	 * @return the simpleObjectMap
	 */
	public Map<String, SimpleObject> getSimpleObjectMap() {
		return simpleObjectMap;
	}

	/**
	 * @param simpleObjectMap the simpleObjectMap to set
	 */
	public void setSimpleObjectMap(Map<String, SimpleObject> simpleObjectMap) {
		this.simpleObjectMap = simpleObjectMap;
	}
}

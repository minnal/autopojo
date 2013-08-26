/**
 * 
 */
package org.minnal.autopojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author ganeshs
 *
 */
@SuppressWarnings("rawtypes")
public class CollectionModel {

	private List<String> genericStringList = new ArrayList<String>();
	
	private List nonGenericList = new ArrayList();
	
	private List<SimpleObject> genericObjectList = new ArrayList<SimpleObject>();
	
	private Set<String> genericStringSet = new HashSet<String>();
	
	private Set nonGenericSet = new HashSet();
	
	private Queue<SimpleObject> genericObjectQueue = new LinkedList<SimpleObject>();
	
	private Queue<String> genericStringQueue = new LinkedList<String>();
	
	private Queue nonGenericQueue = new LinkedList();
	
	private Set<SimpleObject> genericObjectSet = new HashSet<SimpleObject>();
	
	private Map nonGenericMap = new HashMap();
	
	private Map<String, SimpleObject> genericStringObjectMap = new HashMap<String, SimpleObject>();
	
	private Map<SimpleObject, SimpleObject> genericObjectObjectMap = new HashMap<SimpleObject, SimpleObject>();
	
	private Object[] anyObjectArray = new Object[]{};
	
	private String[] stringArray = new String[]{};
	
	private SimpleObject[] objectArray = new SimpleObject[]{};

	/**
	 * @return the genericStringList
	 */
	public List<String> getGenericStringList() {
		return genericStringList;
	}

	/**
	 * @param genericStringList the genericStringList to set
	 */
	public void setGenericStringList(List<String> genericStringList) {
		this.genericStringList = genericStringList;
	}

	/**
	 * @return the nonGenericList
	 */
	public List getNonGenericList() {
		return nonGenericList;
	}

	/**
	 * @param nonGenericList the nonGenericList to set
	 */
	public void setNonGenericList(List nonGenericList) {
		this.nonGenericList = nonGenericList;
	}

	/**
	 * @return the genericObjectList
	 */
	public List<SimpleObject> getGenericObjectList() {
		return genericObjectList;
	}

	/**
	 * @param genericObjectList the genericObjectList to set
	 */
	public void setGenericObjectList(List<SimpleObject> genericObjectList) {
		this.genericObjectList = genericObjectList;
	}

	/**
	 * @return the genericStringSet
	 */
	public Set<String> getGenericStringSet() {
		return genericStringSet;
	}

	/**
	 * @param genericStringSet the genericStringSet to set
	 */
	public void setGenericStringSet(Set<String> genericStringSet) {
		this.genericStringSet = genericStringSet;
	}

	/**
	 * @return the nonGenericSet
	 */
	public Set getNonGenericSet() {
		return nonGenericSet;
	}

	/**
	 * @param nonGenericSet the nonGenericSet to set
	 */
	public void setNonGenericSet(Set nonGenericSet) {
		this.nonGenericSet = nonGenericSet;
	}

	/**
	 * @return the genericObjectQueue
	 */
	public Queue<SimpleObject> getGenericObjectQueue() {
		return genericObjectQueue;
	}

	/**
	 * @param genericObjectQueue the genericObjectQueue to set
	 */
	public void setGenericObjectQueue(Queue<SimpleObject> genericObjectQueue) {
		this.genericObjectQueue = genericObjectQueue;
	}

	/**
	 * @return the genericStringQueue
	 */
	public Queue<String> getGenericStringQueue() {
		return genericStringQueue;
	}

	/**
	 * @param genericStringQueue the genericStringQueue to set
	 */
	public void setGenericStringQueue(Queue<String> genericStringQueue) {
		this.genericStringQueue = genericStringQueue;
	}

	/**
	 * @return the nonGenericQueue
	 */
	public Queue getNonGenericQueue() {
		return nonGenericQueue;
	}

	/**
	 * @param nonGenericQueue the nonGenericQueue to set
	 */
	public void setNonGenericQueue(Queue nonGenericQueue) {
		this.nonGenericQueue = nonGenericQueue;
	}

	/**
	 * @return the genericObjectSet
	 */
	public Set<SimpleObject> getGenericObjectSet() {
		return genericObjectSet;
	}

	/**
	 * @param genericObjectSet the genericObjectSet to set
	 */
	public void setGenericObjectSet(Set<SimpleObject> genericObjectSet) {
		this.genericObjectSet = genericObjectSet;
	}

	/**
	 * @return the nonGenericMap
	 */
	public Map getNonGenericMap() {
		return nonGenericMap;
	}

	/**
	 * @param nonGenericMap the nonGenericMap to set
	 */
	public void setNonGenericMap(Map nonGenericMap) {
		this.nonGenericMap = nonGenericMap;
	}

	/**
	 * @return the genericStringObjectMap
	 */
	public Map<String, SimpleObject> getGenericStringObjectMap() {
		return genericStringObjectMap;
	}

	/**
	 * @param genericStringObjectMap the genericStringObjectMap to set
	 */
	public void setGenericStringObjectMap(Map<String, SimpleObject> genericStringObjectMap) {
		this.genericStringObjectMap = genericStringObjectMap;
	}

	/**
	 * @return the genericObjectObjectMap
	 */
	public Map<SimpleObject, SimpleObject> getGenericObjectObjectMap() {
		return genericObjectObjectMap;
	}

	/**
	 * @param genericObjectObjectMap the genericObjectObjectMap to set
	 */
	public void setGenericObjectObjectMap(Map<SimpleObject, SimpleObject> genericObjectObjectMap) {
		this.genericObjectObjectMap = genericObjectObjectMap;
	}

	/**
	 * @return the anyObjectArray
	 */
	public Object[] getAnyObjectArray() {
		return anyObjectArray;
	}

	/**
	 * @param anyObjectArray the anyObjectArray to set
	 */
	public void setAnyObjectArray(Object[] anyObjectArray) {
		this.anyObjectArray = anyObjectArray;
	}

	/**
	 * @return the stringArray
	 */
	public String[] getStringArray() {
		return stringArray;
	}

	/**
	 * @param stringArray the stringArray to set
	 */
	public void setStringArray(String[] stringArray) {
		this.stringArray = stringArray;
	}

	/**
	 * @return the objectArray
	 */
	public SimpleObject[] getObjectArray() {
		return objectArray;
	}

	/**
	 * @param objectArray the objectArray to set
	 */
	public void setObjectArray(SimpleObject[] objectArray) {
		this.objectArray = objectArray;
	}
}

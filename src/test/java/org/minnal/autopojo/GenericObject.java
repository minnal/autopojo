/**
 * 
 */
package org.minnal.autopojo;


/**
 * @author ganeshs
 *
 */
public class GenericObject<K, V> {

	private K key;
	
	private V value;

	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}
}

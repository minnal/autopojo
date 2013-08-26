/**
 * 
 */
package org.minnal.autopojo;


/**
 * @author ganeshs
 *
 */
public class AutoPojoFactory {

	public static final int MAX_DEPTH = 5;
	
	private GenerationStrategy strategy;
	
	public AutoPojoFactory() {
		this(new GenerationStrategy());
	}

	/**
	 * @param strategy
	 */
	public AutoPojoFactory(GenerationStrategy strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * Populate the pojo object
	 * 
	 * @param pojoClass
	 * @param genericTypes
	 * @return
	 */
	public <T> T populate(Class<T> pojoClass, Class<?>... genericTypes) {
		return populate(pojoClass, MAX_DEPTH, genericTypes);
	}

	/**
	 * Populate the pojo object
	 * 
	 * @param pojoClass
	 * @param maxDepth
	 * @param genericTypes
	 * @return
	 */
	public <T> T populate(Class<T> pojoClass, int maxDepth, Class<?>... genericTypes) {
		return (T) strategy.resolve(pojoClass, maxDepth, genericTypes);
	}
}

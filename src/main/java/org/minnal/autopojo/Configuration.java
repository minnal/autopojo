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
		this.excludeFields = excludeFields;
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
}

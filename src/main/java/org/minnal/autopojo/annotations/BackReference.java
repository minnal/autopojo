/**
 * 
 */
package org.minnal.autopojo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that marks the field/method as back reference. 
 * 
 * @see ForwardReference
 * 
 * @author ganeshs
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface BackReference {

	/**
	 * Name of the reference
	 * 
	 * @return
	 */
	public String value() default "defaultReference";
}

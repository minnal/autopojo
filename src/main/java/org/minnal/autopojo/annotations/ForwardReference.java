/**
 * 
 */
package org.minnal.autopojo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that marks the field/method as forward reference. If a back reference annotation is found in the field class, 
 * the back reference object will be set to the object that specified the forward reference.
 * 
 * <code>
 * public class Order {
 * 		private String email;
 * 		
 * 		@ForwardReference("orderItems")
 * 		private Set<OrderItem> orderItems;
 * }
 * 
 * public class Order {
 * 		private Long id;
 * 		
 * 		@BackReference("orderItems")
 * 		private Order order;
 * }
 * </code>
 * 
 * @author ganeshs
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ForwardReference {

	/**
	 * Name of the reference
	 * 
	 * @return
	 */
	public String value() default "defaultReference";
}

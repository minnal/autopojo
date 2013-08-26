/**
 * 
 */
package org.minnal.autopojo;

/**
 * @author ganeshs
 *
 */
public class AutoPojoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AutoPojoException() {
	}

	/**
	 * @param message
	 */
	public AutoPojoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AutoPojoException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AutoPojoException(String message, Throwable cause) {
		super(message, cause);
	}

}

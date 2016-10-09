/**
 * 
 */
package com.payments.finder.errors;

/**
 * @author attilio
 *
 */
public class DuePaymentsMalformed extends Error {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7520227543136059891L;

	/**
	 * 
	 */
	public DuePaymentsMalformed() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DuePaymentsMalformed(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DuePaymentsMalformed(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DuePaymentsMalformed(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DuePaymentsMalformed(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

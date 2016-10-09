/**
 * 
 */
package com.payments.finder.errors;

/**
 * @author attilio
 *
 */
public class BankTransferMalformed extends Error {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7520227543136059890L;

	/**
	 * 
	 */
	public BankTransferMalformed() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public BankTransferMalformed(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public BankTransferMalformed(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BankTransferMalformed(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public BankTransferMalformed(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

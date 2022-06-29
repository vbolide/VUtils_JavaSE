package com.vbolide.exception;

/**
 * Thrown when an application attempts to use {@code null} or {@code invalid} input than that is required by operation.
 * 
 * @author Vamshi Byagari
 */
public class InvalidParameterException extends Exception{

    private static final long serialVersionUID = -3623444791496220572L;

	/**
     * Constructs a new invalid parameter exception with the specified detail message.
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
	public InvalidParameterException(final String messge) {
		super(messge);
	}

}
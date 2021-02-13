package com.adobe.assignment.aem.core.number.impl;

public class NumberException extends Exception {

    /**
     * Default constructor.
     */
    public NumberException() {
    }

    /**
     * Constructor with an error message.
     *
     * @param message an error message
     */
    public NumberException(String message) {
        super(message);
    }

    /**
     * Constructor with an error message and a cause.
     * @param message an error message
     * @param cause a cause
     */
    public NumberException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause.
     * @param cause a cause
     */
    public NumberException(Throwable cause) {
        super(cause);
    }
}

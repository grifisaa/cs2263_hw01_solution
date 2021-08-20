package edu.isu.cs2263.hw01;

/**
 * Exception class for bringing up issues with the processing of expressions
 * @author Isaac D Griffith
 * @version 1.1.0
 */
public class ImproperlyFormattedExpressionException extends Exception {
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public ImproperlyFormattedExpressionException() {

    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ImproperlyFormattedExpressionException(String message) {
        super(message);
    }
}

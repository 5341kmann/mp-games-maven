package edu.grinnell.csc207.connect4.util;

/**
 * A custom exception for when the piece height of our board is exceeded.
 */
public class ColumnFullException extends RuntimeException {

  /**
   * The call to throw a ColumnFullException with a message.
   *
   * @param message
   *  The string to print when an exception is thrown.
   */
  public ColumnFullException(String message) {
    super(message);
  } // ColumnFullException(String)

  /**
   * A default exception for when the piece height of our board is exceeded.
   */
  public ColumnFullException() {
    super("Column full.");
  } // ColumnFullException()
} // class ColumnFullException

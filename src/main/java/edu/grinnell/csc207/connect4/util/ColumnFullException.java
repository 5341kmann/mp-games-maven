package edu.grinnell.csc207.connect4.util;

public class ColumnFullException extends RuntimeException {

  /**
   * A custom exception for when the piece height of our board is exceeded.
   * @param message
   */
  public ColumnFullException(String message) {
    super(message);
  }

  /**
   * A default exception for when the piece height of our board is exceeded.
   */
  public ColumnFullException() {
    super("Column full.");
  }
}

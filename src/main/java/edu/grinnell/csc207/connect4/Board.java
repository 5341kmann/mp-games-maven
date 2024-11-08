package edu.grinnell.csc207.connect4;

import edu.grinnell.csc207.connect4.util.ColumnFullException;
import edu.grinnell.csc207.util.MatrixV0;

/**
 * A class that implements a Connect 4 Board.
 *
 * @author Sarah Deschamps
 * @author Grant Sackmann
 */
public class Board {
  /**
   * The game board matrix.
   */
  private MatrixV0<Character> gameBoard;

  /**
   * Heights of the current board columns.
   */
  private int[] heights;

  /**
   * The constant width of the board.
   */
  private static final int BOARD_WIDTH = 7;

  /**
   * The constant height of the board.
   */
  private static final int BOARD_HEIGHT = 6;


  /**
   * The board constructor. Constructs a board of characters with defualt
   * height and width, filling ' ' as the default character.
   */
  public Board() {
    this.gameBoard = new MatrixV0<Character>(BOARD_WIDTH, BOARD_HEIGHT, ' ');
    this.heights = new int[BOARD_WIDTH];
  } // Board()

  /**
   * Returns the piece at the specified row and column.
   * @param row
   *  The row the piece is in.
   * @param col
   *  The column the piece is in.
   * @return the piece in the given space.
   */
  public Character getPiece(int row, int col) {
    return gameBoard.get(BOARD_HEIGHT - row - 1, col);
  } // getPiece(int, int)

  /**
   * Fills the space at the given row and column with the given value.
   * @param row
   *  The given row.
   * @param col
   *  The given height.
   * @param piece
   *  The character to fill the space with.
   */
  public void setPiece(int row, int col, Character piece) {
    gameBoard.set(BOARD_HEIGHT - row - 1, col, piece);
  } // setPiece(int, int, Character)

  /**
   * Returns the height of a given column.
   * @param col index of the column of interest.
   * @return The height of the given column.
   */
  public int getHeight(int col) {
    return heights[col];
  } // getHeight()

  /**
   * Increments the height of the given column.
   * @param col the column you would like to increment.
   * @pre the current height of col is < 6
   */
  public void incrementHeight(int col) throws ColumnFullException {
    if (heights[col] >= BOARD_HEIGHT){
      throw new  ColumnFullException();
    } // if
    heights[col]++;
  } // incrementHeight(int)

  /**
   * Determines whether the board is full.
   * @return true if there are no spaces left, false otherwise.
   */
  public boolean isFull() {
    for (int r = 0; r < BOARD_HEIGHT; r++) {
      for (int c = 0; c < BOARD_WIDTH; c++) {
        if (gameBoard.get(r, c).equals(' ')) {
          return false;
        } // if
      } // for
    } // for
    return true;
  } // isFull()

  /**
   * Builds a string representing the board.
   * @return the string representation of the board.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("+-+-+-+-+-+-+-+\n");
    for (int r = 0; r < BOARD_HEIGHT; r++) {
      sb.append("|");
      for (int c = 0; c < BOARD_WIDTH; c++) {
        sb.append(gameBoard.get(r, c) + "|");
      } // for
      sb.append("\n");
    } // for
    sb.append("+-+-+-+-+-+-+-+\n");
    sb.append(" 1 2 3 4 5 6 7\n");
    return sb.toString();
  } // toString()
} // class Board

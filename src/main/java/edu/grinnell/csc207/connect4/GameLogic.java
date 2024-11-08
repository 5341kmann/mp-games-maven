package edu.grinnell.csc207.connect4;

/**
 * Processing user inputs for the connect 4 game.
 *
 * @author Sarah Deschamps
 * @author Grant Sackmann
 */
public class GameLogic {
  /**
   * The number of characters in a row needed to win.
   */
  private static final int WIN_COUNT = 4;

  /**
   * Add a piece to the game board provided a location for the piece.
   *
   * @param col
   *  Column on Board where the piece will be placed.
   * @param piece
   *  The character to add to the board.
   * @param board
   *  The board to add the character to.
   * @return the row at which the piece was added.
   */
  public static int addPiece(int col, Character piece, Board board) {
    try {
      int height = board.getHeight(col);
      board.setPiece(height, col, piece);
      board.incrementHeight(col);
      return height;
    } catch (Exception e) {
      return -1;
    } // try-catch
  } // addPiece(int, Character, Board)


  /**
   * Checks if the current piece is a winning play.
   *
   * @param row
   *  Zero-indexed coordinate of piece row.
   * @param col
   *  Zero-indexed coordinate of piece col.
   * @param piece
   *  Character of piece of interest.
   * @param gameBoard
   *  Board of gameplay.
   * @return Whether the piece is part of a winning connection.
   */
  public static boolean checkForWinner(int row, int col, Character piece, Board gameBoard) {
    int matches = 0;

    // check horizontal
    for (int c = col - 3; c <= col + 3; c++) {
      if (isPieceAt(row, c, piece, gameBoard)) {
        matches++;
      } else {
        matches = 0;
      } // if-else
      if (matches == WIN_COUNT) {
        return true;
      } // if
    } // for

    matches = 0;

    // check vertical
    for (int r = row - 3; r <= row + 3; r++) {
      if (isPieceAt(r, col, piece, gameBoard)) {
        matches++;
      } else {
        matches = 0;
      } // if-else
      if (matches == WIN_COUNT) {
        return true;
      } // if
    } // for

    matches = 0;

    // check positive-slope diagonal
    for (int r = row - 3, c = col - 3; r <= row + 3 && c <= col + 3; r++, c++) {
      if (isPieceAt(r, c, piece, gameBoard)) {
        matches++;
      } else {
        matches = 0;
      } // if-else
      if (matches == WIN_COUNT) {
        return true;
      } // if
    } // for

    matches = 0;

    // check negative-slope diagonal
    for (int r = row - 3, c = col + 3; r <= row + 3 && c >= col - 3; r++, c--) {
      if (isPieceAt(r, c, piece, gameBoard)) {
        matches++;
      } else {
        matches = 0;
      } // if-else
      if (matches == WIN_COUNT) {
        return true;
      } // if
    } // for
    return false;
  } // checkForWinner(int, int, Character, Board)

  /**
   * Helper for checkForWinner() method returning whether the provided piece is located at a
   * position on the board.
   *
   * @param row
   *  Zero-indexed coordinate of board row.
   * @param col
   *  Zero-indexed coordinate of board col.
   * @param piece
   *  Character of piece of interest.
   * @param gameBoard
   *  Board of gameplay.
   * @return whether the piece was found at the location.
   */
  private static boolean isPieceAt(int row, int col, Character piece, Board gameBoard) {
    try {
      return gameBoard.getPiece(row, col).equals(piece);
    } catch (IndexOutOfBoundsException e) {
      return false;
    } // try-catch
  } // isPieceAt(int, int, Character, Board)
} // class GameLogic

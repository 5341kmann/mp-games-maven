package edu.grinnell.csc207.connect4;

import edu.grinnell.csc207.connect4.util.ColumnFullException;

/**
 * Processing user inputs for the connect 4 game.
 *
 * @author Sarah Deschamps
 * @author Grant Sackmann
 */
public class GameLogic {
//  Fields
  /**
   * Board containg the state of the game
   */
  Board gameBoard;
  /**
   * The current turn number for entire game
   */
  int turnCount;

  private static final int WIN_COUNT = 4;
//  Constructors

  // could we get rid of the constructor?
  public GameLogic(Board gameBoard) {
    this.gameBoard = gameBoard;
    this.turnCount = 0;
  }
//  Methods

  /**
   * Add a piece to the game board provided a location for the piece.
   *
   * @param col column on Board where the piece will be placed.
   * @return whether the piece could be successfully added.
   */
  public static int addPiece(int col, Character piece, Board board) {
    try {
      int height = board.getHeight(col);
      board.setPiece(height, col, piece);
      board.incrementHeight(col);
      return height;
    } catch (ColumnFullException e) {
      return -1;
    } // try-catch
  } // addPiece()


  /**
   * Checks if the current piece is a winning play.
   *
   * @param row       zero indexed coordinate of piece row
   * @param col       zero indexed coordinate of piece col
   * @param piece     Character of piece of interest
   * @param gameBoard Board of gameplay
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
  } // checkForWinner()

  /**
   * Helper for checkForWinner() method returning whether the provided piece is located at a
   * position on the board.
   *
   * @param row
   *  zero indexed coordinate of board row
   * @param col
   *  zero indexed coordinate of board col
   * @param piece
   *  Character of piece of interest
   * @param gameBoard
   *  Board of gameplay
   * @return whether the piece was found at the location
   */
  private static boolean isPieceAt(int row, int col, Character piece, Board gameBoard) {
    try {
      return gameBoard.getPiece(row, col).equals(piece);
    } catch (IndexOutOfBoundsException e) {
      return false;
    } // try-catch
  } // isPieceAt(int, int, Character, Board)
} // GameLogic class

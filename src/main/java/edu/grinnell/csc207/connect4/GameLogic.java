package edu.grinnell.csc207.connect4;

/**
 * Processing user inputs for the connect 4 game.
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
//  Constructors

  public GameLogic(Board gameBoard) {
    this.gameBoard = gameBoard;
    this.turnCount = 0;
  }
//  Methods

  /**
   * Add a piece to the game board provided a location for the piece.
   * @param col column on Board where the piece will be placed.
   * @return whether the piece could be successfully added.
   */
  public boolean addPiece(int col, char piece) {
    int height = this.gameBoard.getHeights()[col];

    if (height < 6){
      gameBoard.setPiece(height, col, piece);
      gameBoard.incrementHeight(col);
      return true;
    } // if
    return false;
  } //  addPiece()

  public static boolean checkForWinner(int row, int col, Character piece, Board gameBoard) {
    int matches = 0;

    // check horizontal
    for (int c = col - 3; c <= col + 3; c++) {
      try {
        if (gameBoard.getPiece(row, c).equals(piece)) {
          matches++;
        } else {
          matches = 0;
        } // if-else
      } catch (IndexOutOfBoundsException e) {
        // do nothing
      } // try-catch
      if (matches == 4) {
        return true;
      } // if
    } // for
    

    // check vertical
    for (int r = row - 3; r <= row + 3; r++) {
      try {
        if (gameBoard.getPiece(r, col).equals(piece)) {
          matches++;
        } else {
          matches = 0;
        } // if-else
      } catch (IndexOutOfBoundsException e) {
        // do nothing
      } // try-catch
      if (matches == 4) {
        return true;
      } // if
    } // for

    // check positive-slope diagonal
    for (int r = row - 3, c = col - 3; r <= row + 3 && c <= col + 3; r++, c++) {
      try {
        if (gameBoard.getPiece(r, c).equals(piece)) {
          matches++;
        } else {
          matches = 0;
        } // if-else
      } catch (IndexOutOfBoundsException e) {
        // do nothing
      } // try-catch
      if (matches == 4) {
        return true;
      } // if
    } // for

    // check negative-slope diagonal
    for (int r = row - 3, c = col + 3; r <= row + 3 && c >= col - 3; r++, c--) {
      try {
        if (gameBoard.getPiece(r, c).equals(piece)) {
          matches++;
        } else {
          matches = 0;
        } // if-else
      } catch (IndexOutOfBoundsException e) {
        // do nothing
      } // try-catch
      if (matches == 4) {
        return true;
      } // if
    } // for
    return false;
  } // checkForWinner()
} // GameLogic class

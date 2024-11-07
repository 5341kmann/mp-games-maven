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
//  Constructors

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
  public boolean addPiece(int col, char piece) {
    try {
      int height = this.gameBoard.getHeight(col);
      gameBoard.setPiece(height, col, piece);
      gameBoard.incrementHeight(col);
      return true;
    } catch (Exception e) {
      return false;
    } // try-catch
  } // addPiece()



  public boolean checkForWinner(int row, int col, Character piece) {
    int count = 0;
    int dx = -1;
    int dy = 0;
    int n = 1;
//    Work In Progress
//    while (count < 3) {
//      try {
//        if (gameBoard.getPiece(row + n * dx, col + n * dy).equals(piece)) {
//          count++;
//          n++;
//        } else {
//          dx = 1;
//        }
//      } catch (IndexOutOfBoundsException e) {
//
//      }
//    } // while

    return false;
  } // checkForWinner()
} // GameLogic class

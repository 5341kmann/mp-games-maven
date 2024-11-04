package edu.grinnell.csc207.connect4;

import edu.grinnell.csc207.util.MatrixV0;

public class Board {
  private MatrixV0<Character> gameBoard;

  public Board() {
    this.gameBoard = new MatrixV0<Character>(7, 6);
  } // Board()

  public Character getPiece(int row, int col) {
    return gameBoard.get(row, col);
  } // getPiece(int, int)

  public void setPiece(int row, int col, Character piece) {
    gameBoard.set(row, col, piece);
  } // setPiece(int, int, Character)

  public void drawBoard() {
    // STUB
  } // drawBoard()
}

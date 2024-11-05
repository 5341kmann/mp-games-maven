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

  public boolean checkForWinner(){
    int matches = 0;

    for (int i = 0; i <3 ; i++) {

    }
    return false;
  } // checkForWinner()


} // GameLogic class

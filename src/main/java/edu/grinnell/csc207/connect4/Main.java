package edu.grinnell.csc207.connect4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import edu.grinnell.csc207.util.IOUtils;
/**
 * The main class interacting with the user.
 * Gives the user instructions and runs Connect 4 game.
 *
 * @author Sarah Deschamps
 * @author Grant Sackmann
 */
public class Main {
  /**
   * The method that directly runs the game.
   * @param args
   *  Arguments sent to main.
   * @throws IOException 
   */
  public static void main(String[] args) throws IOException {
    // CONFIGURATION: ask the user if they want 1 Player or 2 Players.
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    pen.println("""
        Welcome to Connect 4!

        The object of this game is to connect four of your pieces in a row. This can be done
        vertically, horizontally, or diagonally.

        The game board is filled with X's, O's, and blanks. X's represent Player 1, 
        while O's represent Player 2.

        During gameplay, you can choose the column to put your next piece into. This is done
        by typing letters A through G in the command line, representing the columns.

        In one-player Connect 4, you will be Player 1 (represented by X's), and the computer
        will play as Player 2 (represented by O's).

        In two-player Connect 4, Player 1 is the first person who goes.

        The game will end as soon as one player has connected four of their pieces.

        Good luck!
        """);
    // determine whether the user wants one or two players
    String player = IOUtils.readCommand(pen, reader, "Would you like to play Connect 4 with one or two players?\n" +
    "Enter '1' if one-player, enter '2' if two-player: ", new String[] {"1", "2"});

    pen.println("We have collected your response. Let the game begin!");

    // the turn count: can check if it's even or odd this way.
    int turn = 0;

    // create the board
    Board playingBoard = new Board();

    // is the game over?
    boolean gameOver = false;

    while (!gameOver) {
      if (player.equals("1") && turn % 2 == 0) {
        gameOver = playerTurn(pen, reader, 'X', playingBoard);
      } else if (player.equals("1") && turn % 2 == 1) {
        gameOver = playerTurn(pen, reader, 'O', playingBoard);
      } else {
        // AI's turn
      } // if-else
      // if board full, game over.
    } // while
  } // main(String[])

  /**
   * Plays one player's move, updating the given game board.
   * @param pen
   *  The 
   * @param player
   *  The character this move will insert into the board.
   * @param gameBoard
   *  The board to modify.
   * @return whether the game is over.
      * @throws IOException 
      */
     private static boolean playerTurn(PrintWriter pen, BufferedReader reader, Character player, Board playingBoard) throws IOException {
    pen.println("Player " + player.toString() + " , you're up.");
    pen.println(playingBoard);
    // have user enter a letter
    int col = Integer.parseInt(IOUtils.readCommand(pen, reader, 
                                        "Pick a column between 1 and 7", 
                                        new String[] {"1", "2", "3", "4", "5", "6", "7"}));
    // determine lowest row
    int row = GameLogic.addPiece(col, player);
    while (row < 0) {
      pen.println("This row if full. Please pick a different row.");
      col = Integer.parseInt(IOUtils.readCommand(pen, reader, 
                                        "Pick a column between 1 and 7", 
                                        new String[] {"1", "2", "3", "4", "5", "6", "7"}));
      row = GameLogic.addPiece(col, player);
    } // while
    return GameLogic.checkForWinner(row, col, player, playingBoard);
  } // playerTurn(PrintWriter, Character, Board)
} // class Main

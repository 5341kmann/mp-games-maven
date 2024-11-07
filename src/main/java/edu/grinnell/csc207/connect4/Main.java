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

    // the turn count: can check if it's even or odd this way.
    int turn = 0;

    // create the board
    Board playingBoard = new Board();

    // is the game over?
    boolean gameOver = false;

    while (!gameOver) {
      if (player.equals("1") && turn % 2 == 0) {
        gameOver = playerTurn('X', playingBoard);
      } else if (player.equals("2") && turn % 2 == 0) {
        gameOver = playerTurn('O', playingBoard);
      } else {
        // AI's turn
      } // if-else
    } // while
  } // main(String[])

  /**
   * Plays one player's move, updating the given game board.
   * @param player
   *  The character this move will insert into the board.
   * @param gameBoard
   *  The board to modify.
   * @return whether the game is over.
   */
  private static boolean playerTurn(Character player, Board playingBoard) {
    // have user enter a letter

    // determine lowest row
        
    return GameLogic.checkForWinner(0, 0, player, playingBoard); // STUB
  } // playerTurn(Character, Board)
} // class Main

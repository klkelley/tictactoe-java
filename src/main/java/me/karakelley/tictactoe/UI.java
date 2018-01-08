package me.karakelley.tictactoe;

import java.io.PrintStream;

public class UI {
  public PrintStream output;
  private BoardInterface board;

  public UI(PrintStream out) {
    output = out;
    board = new BoardInterface();
  }

  public void welcomeMessage() {
    output.println("Welcome to Tic Tac Toe!");
  }


  public void displayBoard() {
    output.printf(board.setupBoard());
  }
}


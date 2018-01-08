package me.karakelley.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UI {
  private PrintStream out;
  private Scanner inputScanner;
  private BoardInterface board;

  public UI(PrintStream out, InputStream in) {
    this.out = out;
    inputScanner = new Scanner(in);
    board = new BoardInterface();
  }

  public void welcomeMessage() {
    out.println("Welcome to Tic Tac Toe!");
  }


  public void displayBoard() {
    out.printf(board.setupBoard());
  }

  public void promptEnterKey() {
    out.println("Please press \"ENTER\" to continue");

    inputScanner.nextLine();
  }
}


package me.karakelley.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UI {
  private PrintStream out;
  private Scanner inputScanner;
//  private BoardInterface board;

  public UI(PrintStream out, InputStream in) {
    this.out = out;
    inputScanner = new Scanner(in);
//    board = new BoardInterface();
  }

  public void display(String message) {
    out.printf(message);
  }

  public String getInput(String message) {
    display(message);
    String input = inputScanner.nextLine();
    return input;
  }
}


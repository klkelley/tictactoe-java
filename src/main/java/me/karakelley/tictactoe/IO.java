package me.karakelley.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UserInterface {
  private PrintStream out;
  private Scanner inputScanner;

  public UserInterface(PrintStream out, InputStream in) {
    this.out = out;
    inputScanner = new Scanner(in);
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


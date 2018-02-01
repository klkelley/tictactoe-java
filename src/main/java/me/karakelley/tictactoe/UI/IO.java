package me.karakelley.tictactoe.UI;

import java.io.*;
import java.util.Scanner;

public class IO {
  private PrintStream out;
  private Scanner inputScanner;
  private InputStream in;

  public IO(PrintStream out, InputStream in) {
    this.out = out;
    this.in = in;
    inputScanner = new Scanner(in);
  }

  public void display(String message) {
    out.printf(message);
  }

  public String getInput() {
    return inputScanner.nextLine();
  }

}


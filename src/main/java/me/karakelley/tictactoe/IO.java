package me.karakelley.tictactoe;

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

  public int anyKey() throws IOException, InterruptedException {
    int input = -1;
    enterCharacterMode();
    while (input < 0 ) {
      input = in.read();
    }
    enterLineMode();
    return input;
  }

  private void enterCharacterMode() throws IOException, InterruptedException {
    String[] cmd = new String[]{"/bin/sh", "-c", "stty raw </dev/tty"};
    Runtime.getRuntime().exec(cmd).waitFor();
  }

  private void enterLineMode() throws IOException, InterruptedException {
    String[] cmd = {"/bin/sh", "-c", "stty cooked </dev/tty"};
    Runtime.getRuntime().exec(cmd).waitFor();
  }
}


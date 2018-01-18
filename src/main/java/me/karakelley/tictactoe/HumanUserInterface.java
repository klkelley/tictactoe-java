package me.karakelley.tictactoe;

import java.io.IOException;

public class HumanUserInterface implements UserInterface {
  private IO io;
  private BoardPresenter boardPresenter;

  private static final String tie = "It's a tie!\n";
  private static final String welcome = "Welcome to Tic Tac Toe!\n";
  private static final String player1 = "Player one";
  private static final String player2 = "Player two";

  public HumanUserInterface(IO io, BoardPresenter boardPresenter) {
    this.io = io;
    this.boardPresenter = boardPresenter;
  }

  public String userPrompt(String message, Validator validator) {
    String input;

    do {
      displayMessage(message);
      input = io.getInput();

    } while(!validator.isValidInput(input));
      return input;
  }

  public void waitForKeyPress() {
    try {
      io.anyKey();
    } catch (IOException|InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void displayTie() {
    displayMessage(tie);
  }

  public void displayBoard(BoardState board) {
    displayMessage(boardPresenter.prettify(board.getGrid()));
  }

  public void greetUser() {
    displayMessage(welcome);
  }

  public void displayWinner(boolean firstPlayerWins) {
    displayMessage(String.format("%s wins!\n", winningStatement(firstPlayerWins)));
  }

  public void displayMessage(String message) {
    io.display(message);
  }

  private String winningStatement(boolean firstPlayerWins) {
    return firstPlayerWins ? player1 : player2;
  }
}

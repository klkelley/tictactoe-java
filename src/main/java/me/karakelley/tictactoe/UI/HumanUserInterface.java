package me.karakelley.tictactoe.UI;

import me.karakelley.tictactoe.UI.validators.Validator;
import me.karakelley.tictactoe.game.BoardPresenter;
import me.karakelley.tictactoe.game.BoardState;


public class HumanUserInterface implements UserInterface {
  private IO io;
  private BoardPresenter boardPresenter;
  private static final String TIE = "It's a tie!\n";
  private static final String WELCOME = "Welcome to Tic Tac Toe!\n";
  private String playerOneWins = "Player one wins!\n";
  private String playerTwoWins = "Player two wins!\n";


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

  public void setWinMessage(String message) {
    playerOneWins = message;
  }

  public void setLoseMessage(String message) {
    playerTwoWins = message;
  }

  public void displayTie() {
    displayMessage(TIE);
  }

  public void displayBoard(BoardState board) {
    displayMessage(boardPresenter.prettify(board.getGrid()));
  }

  public void greetUser() {
    displayMessage(WELCOME);
  }

  public void displayWinner(boolean firstPlayerWins) {
    displayMessage(String.format(winningStatement(firstPlayerWins)));
  }

  public void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public void displayMessage(String message) {
    io.display(message);
  }

  private String winningStatement(boolean firstPlayerWins) {
    return firstPlayerWins ? playerOneWins : playerTwoWins;
  }
}

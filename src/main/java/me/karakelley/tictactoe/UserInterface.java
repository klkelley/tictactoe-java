package me.karakelley.tictactoe;

public class UserInterface {
  private IO io;
  private BoardPresenter boardPresenter;
  Validator validator;

  public UserInterface(IO io, BoardPresenter boardPresenter, Validator validator) {
    this.io = io;
    this.boardPresenter = boardPresenter;
    this.validator = validator;
  }

  public void greetUser() {
    io.display("Welcome to Tic Tac Toe!\n");
    continueOn();
    displayBoard();
  }

  public String userPrompt() {
    String input;

    do {
      io.display("Please enter an available cell:\n");
      input = io.getInput();

    } while(!validator.isValidInput(input));
      return input;
  }

  public void displayBoard() {
    io.display(boardPresenter.setupBoard());
  }

  private void continueOn() {
    io.display("Please press \"ENTER\" to continue");
    io.getInput();
  }

}

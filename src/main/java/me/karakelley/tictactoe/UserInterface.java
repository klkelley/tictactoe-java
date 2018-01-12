package me.karakelley.tictactoe;

public class UserInterface {
  private IO io;
  private BoardPresenter boardPresenter;

  public UserInterface(IO io, BoardPresenter boardPresenter) {
    this.io = io;
    this.boardPresenter = boardPresenter;
  }

  public void greetUser() {
    io.display("Welcome to Tic Tac Toe!\n");
  }

  public String userPrompt(String message, Validator validator) {
    String input;

    do {
      io.display(message);
      input = io.getInput();

    } while(!validator.isValidInput(input));
      return input;
  }

  public void displayBoard(String[] board) {
    io.display(boardPresenter.prettify(board));
  }
}

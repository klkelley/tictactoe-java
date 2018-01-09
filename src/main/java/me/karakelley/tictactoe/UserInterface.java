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
    continueOn();
    displayBoard();
  }

  public void displayBoard() {
    io.display(boardPresenter.setupBoard());
  }

  private void continueOn() {
    io.display("Please press \"ENTER\" to continue");
    io.getInput();
  }
}

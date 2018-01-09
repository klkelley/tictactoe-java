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
    io.getInput("Please press \"ENTER\" to continue");
    io.display(boardPresenter.setupBoard());
  }
}

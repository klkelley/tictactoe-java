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
    io.display("Please press \"ENTER\" to continue");
    io.getInput();
    io.display(boardPresenter.setupBoard());
  }
}

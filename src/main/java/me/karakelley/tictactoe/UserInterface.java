package me.karakelley.tictactoe;

public class UserInterface {
  private IO io;
  private BoardPresenter board;

  public UserInterface(IO io, BoardPresenter board) {
    this.io = io;
    this.board = board;
  }

  public void greetUser() {
    io.display("Welcome to Tic Tac Toe!\n");
    io.getInput("Please press \"ENTER\" to continue");
    io.display(board.setupBoard());
  }
}

package me.karakelley.tictactoe;

public class HumanPlayer {
  private IO io;

  public HumanPlayer(IO io) {
    this.io = io;
  }

  public String nextMove() {
    io.display("Please pick an available cell\n");
    return io.getInput();
  }
}

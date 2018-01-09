package me.karakelley.tictactoe;

public class Main {


  public static void main(String args[]) {
    IO io = new IO(System.out, System.in);
    BoardPresenter boardPresenter = new BoardPresenter();
    UserInterface userInterface = new UserInterface(io, boardPresenter);
    GameRunner gameRunner = new GameRunner(userInterface);

    gameRunner.start();
  }
}

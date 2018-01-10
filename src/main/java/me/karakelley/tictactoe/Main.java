package me.karakelley.tictactoe;

public class Main {


  public static void main(String args[]) {
    IO io = new IO(System.out, System.in);
    HumanPlayer humanPlayer = new HumanPlayer(io);
    BoardState boardState = new BoardState(new String[]{"-", "-", "-", "-", "-", "-", "-", "-", "-"});
    BoardPresenter boardPresenter = new BoardPresenter(boardState);
    UserInterface userInterface = new UserInterface(io, boardPresenter);
    GameRunner gameRunner = new GameRunner(userInterface);

    gameRunner.start();
  }
}

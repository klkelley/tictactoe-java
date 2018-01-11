package me.karakelley.tictactoe;

public class Main {


  public static void main(String args[]) {
    IO io = new IO(System.out, System.in);
    HumanPlayer humanPlayer = new HumanPlayer("X");
    Validator validator = new NumberValidator();
    BoardState boardState = new BoardState(new String[]{"-", "-", "-", "-", "-", "-", "-", "-", "-"});
    BoardPresenter boardPresenter = new BoardPresenter(boardState);
    UserInterface userInterface = new UserInterface(io, boardPresenter, validator);
    Game game = new Game(userInterface, humanPlayer, boardState);

    game.start();
  }
}

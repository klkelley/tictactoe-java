package me.karakelley.tictactoe;

public class Main {


  public static void main(String args[]) {
    IO io = new IO(System.out, System.in);
    HumanPlayer humanPlayer = new HumanPlayer("X");
    ValidatorFactory validator = new ValidatorFactoryImplementation();
    BoardState boardState = new BoardState();
    BoardPresenter boardPresenter = new BoardPresenter();
    UserInterface userInterface = new UserInterface(io, boardPresenter);
    Game game = new Game(userInterface, humanPlayer, boardState, validator);

    game.start();
  }
}

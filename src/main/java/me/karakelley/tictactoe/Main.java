package me.karakelley.tictactoe;

public class Main {


  public static void main(String args[]) {
    IO io = new IO(System.out, System.in);
    HumanPlayer humanPlayer = new HumanPlayer("X");
    ValidatorFactory validator = new ValidatorFactoryImplementation();
    HumanPlayer humanPlayer1 = new HumanPlayer("O");
    BoardState boardState = new BoardState();
    BoardPresenter boardPresenter = new BoardPresenter();
    UserInterface userInterface = new UserInterface(io, boardPresenter);
    Game game = new Game(userInterface, humanPlayer, humanPlayer1, boardState, validator);

    game.start();
  }
}

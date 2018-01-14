package me.karakelley.tictactoe;

public class Main {


  public static void main(String args[]) {
    IO io = new IO(System.out, System.in);
    HumanPlayer humanPlayer = new HumanPlayer("X");
    HumanPlayer humanPlayer1 = new HumanPlayer("O");
    Game game = new Game();
    BoardState boardState = new BoardState();
    BoardPresenter boardPresenter = new BoardPresenter();
    UserInterface userInterface = new UserInterface(io, boardPresenter);
    GameLoop gameLoop = new GameLoop(userInterface, humanPlayer, humanPlayer1);

    gameLoop.start(boardState, game);
  }
}

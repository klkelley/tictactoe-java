package me.karakelley.tictactoe;

public class Main {


  public static void main(String args[]) {
    IO io = new IO(System.out, System.in);
    Player humanPlayer = new HumanPlayer("X");
    Player humanPlayer1 = new HumanPlayer("O");
    Game game = new Game();
    BoardState boardState = new BoardState();
    BoardPresenter boardPresenter = new BoardPresenter();
    UserInterface humanUserInterface = new HumanUserInterface(io, boardPresenter);
    GameLoop gameLoop = new GameLoop(humanUserInterface, humanPlayer, humanPlayer1);

    gameLoop.start(boardState, game);
  }
}

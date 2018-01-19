package me.karakelley.tictactoe;

public class Main {

  public static void main(String[] args) {

    IO io = new IO(System.out, System.in);
    Game game = new Game();
    BoardState boardState = new BoardState();
    BoardPresenter boardPresenter = new BoardPresenter();
    UserInterface humanUserInterface = new HumanUserInterface(io, boardPresenter);
    GameConfiguration gameConfiguration = new GameConfiguration();
    Player humanPlayer = new HumanPlayer(gameConfiguration.getPlayer1marker());
    Player humanPlayer1 = new HumanPlayer(gameConfiguration.getPlayer2marker());

    GameLoop gameLoop = new GameLoop(humanUserInterface, humanPlayer, humanPlayer1);
    gameLoop.start(boardState, game);
  }
}

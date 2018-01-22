package me.karakelley.tictactoe;

public class Main {

  public static void main(String[] args) {

    IO io = new IO(System.out, System.in);
    Game game = new Game();
    BoardState boardState = new BoardState();
    BoardPresenter boardPresenter = new BoardPresenter();
    UserInterface humanUserInterface = new HumanUserInterface(io, boardPresenter);
    GameConfiguration gameConfiguration = new GameConfiguration(System.getProperty("configuration"), humanUserInterface, new PlayerFactoryImplementation(humanUserInterface));

    gameConfiguration.gameMenu();
    GameLoop gameLoop = new GameLoop(humanUserInterface, gameConfiguration.getPlayer1(), gameConfiguration.getPlayer2());
    gameLoop.start(boardState, game);
  }
}

package me.karakelley.tictactoe;

public class Main {

  public static void main(String[] args) {

    IO io = new IO(System.out, System.in);
    Game game = new Game();
    BoardState boardState = new BoardState();
    BoardPresenter boardPresenter = new BoardPresenter();
    UserInterface humanUserInterface = new HumanUserInterface(io, boardPresenter, "Player one wins!\n", "Player two wins!\n");
    GameConfiguration gameConfiguration = new GameConfiguration(System.getProperty("configuration"), humanUserInterface, new PlayerFactoryImplementation(humanUserInterface, game));

    gameConfiguration.gameMenu(new UserInterfaceImplementation(io, boardPresenter));
    GameLoop gameLoop = new GameLoop(gameConfiguration.getGameInterface(), gameConfiguration.getPlayer1(), gameConfiguration.getPlayer2());
    gameLoop.start(boardState, game);
  }
}

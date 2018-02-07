package me.karakelley.tictactoe;

import me.karakelley.tictactoe.UI.HumanUserInterface;
import me.karakelley.tictactoe.UI.IO;
import me.karakelley.tictactoe.UI.UserInterface;
import me.karakelley.tictactoe.UI.validators.PlayAgainValidator;
import me.karakelley.tictactoe.game.*;
import me.karakelley.tictactoe.players.PlayerFactoryImplementation;

public class Main {

  public static void main(String[] args) {
    IO io = new IO(System.out, System.in);
    Game game = new Game();
    BoardState boardState = new BoardState();
    BoardPresenter boardPresenter = new BoardPresenter();
    UserInterface humanUserInterface = new HumanUserInterface(io, boardPresenter);
    GameConfiguration gameConfiguration = new GameConfiguration(System.getProperty("configuration"), humanUserInterface, new PlayerFactoryImplementation(humanUserInterface, game));


    gameConfiguration.gameMenu();
    GameLoop gameLoop = new GameLoop(humanUserInterface, gameConfiguration.getPlayer1(), gameConfiguration.getPlayer2());
    new Application(humanUserInterface, gameLoop, new PlayAgainValidator()).start(new Game(), new BoardState());
  }
}

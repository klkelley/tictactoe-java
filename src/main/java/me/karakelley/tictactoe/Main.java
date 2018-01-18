package me.karakelley.tictactoe;

import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException, ParseException {

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

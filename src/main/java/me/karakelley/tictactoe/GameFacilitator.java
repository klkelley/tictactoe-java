package me.karakelley.tictactoe;

import me.karakelley.tictactoe.UI.UserInterface;
import me.karakelley.tictactoe.UI.validators.Validator;
import me.karakelley.tictactoe.game.BoardState;
import me.karakelley.tictactoe.game.Game;
import me.karakelley.tictactoe.game.GameLoop;

public class GameFacilitator {

  private Validator playAgainValidator;
  private UserInterface userInterface;
  private String PLAY_AGAIN = "Do you want to play again (Y / N)?\n";

  public GameFacilitator(UserInterface userInterface, Validator playAgainValidator) {
    this.userInterface = userInterface;
    this.playAgainValidator = playAgainValidator;
  }

  public void start(Game game, BoardState boardState, GameLoop gameLoop) {
    do gameLoop.start(game, boardState);
    while (playAgain(boardState, gameLoop));
  }

  public boolean playAgain(BoardState boardState, GameLoop gameLoop) {
    String answer = userInterface.userPrompt(PLAY_AGAIN, playAgainValidator);
    return gameLoop.repeatGame(boardState, answer);
  }
}

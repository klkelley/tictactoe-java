package me.karakelley.tictactoe;

public class Application {

  private GameLoop gameLoop;
  private Validator playAgainValidator;
  private UserInterface userInterface;
  private String PLAY_AGAIN = "Do you want to play again (Y / N)?\n";

  public Application(UserInterface userInterface, GameLoop gameLoop, Validator playAgainValidator) {
    this.userInterface = userInterface;
    this.gameLoop = gameLoop;
    this.playAgainValidator = playAgainValidator;
  }

  public void start(Game game, BoardState boardState) {
    do gameLoop.start(game, boardState);
    while (playAgain(boardState));
  }

  public boolean playAgain(BoardState boardState) {
    String answer = userInterface.userPrompt(PLAY_AGAIN, playAgainValidator);
    if (answer.toLowerCase().equals("y")) {
      gameLoop.reset(boardState);
      return true;
    }
    return false;
  }
}

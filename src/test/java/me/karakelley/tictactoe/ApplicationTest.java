package me.karakelley.tictactoe;

import me.karakelley.tictactoe.UI.validators.PlayAgainValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ApplicationTest {
  Application application;
  UserInterface userInterface = mock(HumanUserInterface.class, RETURNS_MOCKS);
  GameLoop gameLoop = mock(GameLoop.class);
  Game game = mock(Game.class);
  Validator playAgain = mock(PlayAgainValidator.class);
  BoardState boardState = mock(BoardState.class, RETURNS_MOCKS);

  @BeforeEach
  public void setUp() {
    application = new Application(userInterface, gameLoop, playAgain);
  }

  @Test
  public void testStart() {
    when(game.gameOver(boardState)).thenReturn(true);
    when(userInterface.userPrompt( "Do you want to play again (Y / N)?\n", playAgain)).thenReturn("n");
    application.start(game, boardState);
    verify(gameLoop, times(1)).start(game, boardState);
  }

  @Test
  public void testAsksToPlayAgain() {
    when(game.gameOver(boardState)).thenReturn(true);
    when(userInterface.userPrompt( "Do you want to play again (Y / N)?\n", playAgain)).thenReturn("n");
    application.start(game, boardState);
    verify(userInterface, times(1)).userPrompt( "Do you want to play again (Y / N)?\n", playAgain);
  }

  @Test
  public void testGameIsReset() {
    when(game.gameOver(boardState)).thenReturn(true);
    when(userInterface.userPrompt( "Do you want to play again (Y / N)?\n", playAgain)).thenReturn("y");
    application.playAgain(boardState);
    verify(gameLoop, times(1)).reset(boardState);
  }
}
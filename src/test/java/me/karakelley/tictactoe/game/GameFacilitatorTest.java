package me.karakelley.tictactoe.game;

import me.karakelley.tictactoe.UI.HumanUserInterface;
import me.karakelley.tictactoe.UI.UserInterface;
import me.karakelley.tictactoe.UI.validators.PlayAgainValidator;
import me.karakelley.tictactoe.UI.validators.Validator;
import me.karakelley.tictactoe.game.BoardState;
import me.karakelley.tictactoe.game.Game;
import me.karakelley.tictactoe.game.GameFacilitator;
import me.karakelley.tictactoe.game.GameLoop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameFacilitatorTest {
  GameFacilitator gameFacilitator;
  UserInterface userInterface = mock(HumanUserInterface.class, RETURNS_MOCKS);
  GameLoop gameLoop = mock(GameLoop.class);
  Game game = mock(Game.class);
  Validator playAgain = mock(PlayAgainValidator.class);
  BoardState boardState = mock(BoardState.class, RETURNS_MOCKS);

  @BeforeEach
  public void setUp() {
    gameFacilitator = new GameFacilitator(userInterface, playAgain);
  }

  @Test
  public void testStart() {
    when(game.gameOver(boardState)).thenReturn(true);
    when(userInterface.userPrompt( "Do you want to play again (Y / N)?\n", playAgain)).thenReturn("n");
    gameFacilitator.start(game, boardState, gameLoop);
    verify(gameLoop, times(1)).start(game, boardState);
  }

  @Test
  public void testAsksToPlayAgain() {
    when(game.gameOver(boardState)).thenReturn(true);
    when(userInterface.userPrompt( "Do you want to play again (Y / N)?\n", playAgain)).thenReturn("n");
    gameFacilitator.start(game, boardState, gameLoop);
    verify(userInterface, times(1)).userPrompt( "Do you want to play again (Y / N)?\n", playAgain);
  }

  @Test
  public void testGameIsReset() {
    when(game.gameOver(boardState)).thenReturn(true);
    when(userInterface.userPrompt( "Do you want to play again (Y / N)?\n", playAgain)).thenReturn("y");
    gameFacilitator.playAgain(boardState, gameLoop);
    verify(gameLoop, times(1)).repeatGame(boardState, "y");
  }
}
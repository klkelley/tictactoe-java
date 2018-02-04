package me.karakelley.tictactoe.game;

import me.karakelley.tictactoe.UI.validators.EnterValidator;
import me.karakelley.tictactoe.UI.HumanUserInterface;
import me.karakelley.tictactoe.players.HumanPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameLoopTest {
  private GameLoop gameLoop;

  HumanUserInterface humanUserInterfaceMock = mock(HumanUserInterface.class, RETURNS_MOCKS);
  HumanPlayer humanPlayerMock = mock(HumanPlayer.class);
  BoardState boardStateMock = mock(BoardState.class);
  EnterValidator enterValidatorMock = mock(EnterValidator.class);
  Validator playAgainMock = mock(PlayAgainValidator.class);
  Game gameMock = mock(Game.class, RETURNS_DEEP_STUBS);

  @BeforeEach
  public void setUp() {
    gameLoop = new GameLoop(humanUserInterfaceMock, humanPlayerMock, humanPlayerMock);
  }

  @Test
  public void testStart() {
    when(humanUserInterfaceMock.userPrompt("Please enter an available cell:\n", enterValidatorMock)).thenReturn("1");
    when(boardStateMock.placeMove("1", "x")).thenReturn(new String[]{"1"});
    when(gameMock.gameOver(boardStateMock)).thenReturn(true);
    when(humanUserInterfaceMock.userPrompt("Do you want to play again (Y / N)?\n", playAgainMock)).thenReturn("n");
    gameLoop.start(gameMock, boardStateMock);
    verify(humanUserInterfaceMock, times(1)).displayBoard(boardStateMock);
  }

}
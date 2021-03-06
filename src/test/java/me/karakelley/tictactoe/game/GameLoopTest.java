package me.karakelley.tictactoe.game;

import me.karakelley.tictactoe.UI.validators.EnterValidator;
import me.karakelley.tictactoe.UI.HumanUserInterface;
import me.karakelley.tictactoe.players.HumanPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameLoopTest {
  private GameLoop gameLoop;

  HumanUserInterface humanUserInterfaceMock = mock(HumanUserInterface.class);
  HumanPlayer humanPlayerMock = mock(HumanPlayer.class);
  BoardState boardStateMock = mock(BoardState.class);
  EnterValidator enterValidatorMock = mock(EnterValidator.class);
  Game gameMock = mock(Game.class);

  @BeforeEach
  public void setUp() {
    gameLoop = new GameLoop(humanUserInterfaceMock, humanPlayerMock, humanPlayerMock);
  }

  @Test
  public void testStart() {
    when(humanUserInterfaceMock.userPrompt("Please enter an available cell:\n", enterValidatorMock)).thenReturn("1");
    when(boardStateMock.placeMove("1", "x")).thenReturn(new String[]{"1"});
    when(gameMock.gameOver(boardStateMock)).thenReturn(true);
    gameLoop.start(boardStateMock, gameMock);
    verify(humanUserInterfaceMock, times(1)).displayBoard(boardStateMock);
  }

}
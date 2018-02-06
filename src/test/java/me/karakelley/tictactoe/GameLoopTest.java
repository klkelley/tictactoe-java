package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameLoopTest {
  private GameLoop gameLoop;

  HumanUserInterface humanUserInterfaceMock = mock(HumanUserInterface.class);
  HumanPlayer humanPlayerMock = mock(HumanPlayer.class);
  BoardState boardStateMock = mock(BoardState.class);
  Validator numberValidatorMock = mock(NumberValidator.class);
  Game gameMock = mock(Game.class);

  @BeforeEach
  public void setUp() {
    gameLoop = new GameLoop(humanUserInterfaceMock, humanPlayerMock, humanPlayerMock);
  }

  @Test
  public void testStart() {
    when(humanUserInterfaceMock.userPrompt("Please enter an available cell:\n", numberValidatorMock)).thenReturn("1");
    when(boardStateMock.placeMove("1", "x")).thenReturn(new String[]{"1"});
    when(gameMock.gameOver(boardStateMock)).thenReturn(true);
    gameLoop.start(boardStateMock, gameMock);
    verify(humanUserInterfaceMock, times(1)).displayBoard(boardStateMock);
  }

  @Test
  public void testTerminalClearing() {
      when(humanUserInterfaceMock.userPrompt("Please enter an available cell:\n", numberValidatorMock)).thenReturn("1");
      when(boardStateMock.placeMove("1", "x")).thenReturn(new String[]{"1"});
      when(gameMock.gameOver(boardStateMock)).thenReturn(true);
      gameLoop.start(boardStateMock, gameMock);
      verify(humanUserInterfaceMock, times(1)).clearScreen();
    }

}
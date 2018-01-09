package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class GameRunnerTest {

  UserInterface userInterfaceMock = mock(UserInterface.class);

  @Test
  public void testStart() {
    GameRunner gameRunner = new GameRunner(userInterfaceMock);
    gameRunner.start();
    verify(userInterfaceMock, times(1)).displayBoard();
  }
}
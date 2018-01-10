package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class HumanPlayerTest {

  IO ioMock = mock(IO.class);

  @Test
  public void nextMove() {
    HumanPlayer humanPlayer = new HumanPlayer(ioMock);
    humanPlayer.nextMove();
    verify(ioMock, times(1)).getInput();
  }

}
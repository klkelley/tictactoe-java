package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameTest {
  private Game game;

  UserInterface userInterfaceMock = mock(UserInterface.class);
  HumanPlayer humanPlayerMock = mock(HumanPlayer.class);
  BoardState boardStateMock = mock(BoardState.class);

  @BeforeEach
  public void setUp() {
    game = new Game(userInterfaceMock, humanPlayerMock, boardStateMock);
  }


  @Test
  public void testStart() {
    when(humanPlayerMock.nextMove()).thenReturn("1");
    game.start();
    verify(userInterfaceMock, times(1)).greetUser();
  }

}
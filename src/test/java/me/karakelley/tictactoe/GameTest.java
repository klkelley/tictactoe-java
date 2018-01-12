package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameTest {
  private Game game;

  UserInterface userInterfaceMock = mock(UserInterface.class);
  HumanPlayer humanPlayerMock = mock(HumanPlayer.class);
  BoardState boardStateMock = mock(BoardState.class);
  Validator validatorMock = mock(NumberValidator.class);

  @BeforeEach
  public void setUp() {
    game = new Game(userInterfaceMock, humanPlayerMock, boardStateMock);
  }

  @Test
  public void testStart() {
    when(userInterfaceMock.userPrompt("Please enter an available cell:\n", validatorMock)).thenReturn("1");
    when(boardStateMock.placeMove("1", "x")).thenReturn(new String[]{"1"});
    game.start();
    verify(userInterfaceMock, times(1)).greetUser();
  }
}
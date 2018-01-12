package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameTest {
  private Game game;

  UserInterface userInterfaceMock = mock(UserInterface.class);
  HumanPlayer humanPlayerMock = mock(HumanPlayer.class);
  BoardState boardStateMock = mock(BoardState.class);
  ValidatorFactory validatorMock = mock(ValidatorFactory.class);
  NumberValidator numberValidatorMock = mock(NumberValidator.class);
  EnterValidator enterValidatorMock = mock(EnterValidator.class);

  @BeforeEach
  public void setUp() {
    game = new Game(userInterfaceMock, humanPlayerMock, humanPlayerMock, boardStateMock, validatorMock);
  }

  @Test
  public void testStart() {
    when(userInterfaceMock.userPrompt("Please enter an available cell:\n", enterValidatorMock)).thenReturn("1");
    when(boardStateMock.placeMove("1", "x")).thenReturn(new String[]{"1"});
    game.start();
    verify(userInterfaceMock, times(1)).greetUser();
  }
}
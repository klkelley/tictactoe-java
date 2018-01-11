package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserInterfaceTest {
  private UserInterface userInterface;

  IO ioMock = mock(IO.class);
  BoardPresenter boardPresenterMock = mock(BoardPresenter.class);
  Validator validatorMock = mock(Validator.class);

  @BeforeEach
  public void setUp() {
    userInterface = new UserInterface(ioMock, boardPresenterMock, validatorMock);
  }

  @Test
  public void testGreetUser() {
    doNothing().when(ioMock).display("test");
    userInterface.greetUser();
    verify(ioMock, times(1)).display("Welcome to Tic Tac Toe!\n");
  }

  @Test
  public void testDisplayBoard() {
    doNothing().when(ioMock).display("test");
    userInterface.displayBoard();
    verify(ioMock, times(1)).display(null);
  }

  @Test
  public void testUserPrompt() {
    when(ioMock.getInput()).thenReturn("1");
    when(validatorMock.isValidInput("1")).thenReturn(true);
    doNothing().when(ioMock).display("test");
    assertEquals("1", userInterface.userPrompt());
  }
}
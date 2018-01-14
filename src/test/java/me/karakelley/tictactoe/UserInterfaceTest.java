package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserInterfaceTest {
  private UserInterface userInterface;

  IO ioMock = mock(IO.class);
  BoardPresenter boardPresenterMock = mock(BoardPresenter.class);
  NumberValidator numberValidatorMock = mock(NumberValidator.class);
  BoardState boardStateMock = mock(BoardState.class);

  @BeforeEach
  public void setUp() {
    userInterface = new UserInterface(ioMock, boardPresenterMock);
  }

  @Test
  public void testDisplayMessage() {
    doNothing().when(ioMock).display("test");
    userInterface.displayMessage("Welcome to Tic Tac Toe!\n");
    verify(ioMock, times(1)).display("Welcome to Tic Tac Toe!\n");
  }

  @Test
  public void testDisplayBoard() {
    doNothing().when(ioMock).display("test");
    userInterface.displayBoard(boardStateMock);
    verify(ioMock, times(1)).display(null);
  }

  @Test
  public void testUserPrompt() {
    when(ioMock.getInput()).thenReturn("1");
    when(numberValidatorMock.isValidInput("1")).thenReturn(true);
    doNothing().when(ioMock).display("test");
    assertEquals("1", userInterface.userPrompt("test", numberValidatorMock));
  }

  @Test
  public void testWaitForKeyPress() throws IOException, InterruptedException {
    when(ioMock.anyKey()).thenReturn(88);
    userInterface.waitForKeyPress();
    verify(ioMock, times(1)).anyKey();
  }
}
package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserInterfaceTest {

  IO ioMock = mock(IO.class);
  BoardPresenter boardPresenterMock = mock(BoardPresenter.class);

  @Test
  public void testGreetUser() {
    UserInterface userInterface = new UserInterface(ioMock, boardPresenterMock);
    doNothing().when(ioMock).display("test");
    userInterface.greetUser();
    verify(ioMock, times(1)).display("Welcome to Tic Tac Toe!\n");
  }

  @Test
  public void testDisplayBoard() {
    UserInterface userInterface = new UserInterface(ioMock, boardPresenterMock);
    doNothing().when(ioMock).display("test");
    userInterface.displayBoard();
    verify(ioMock, times(1)).display(null);
  }
}
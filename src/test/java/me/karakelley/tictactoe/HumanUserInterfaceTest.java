package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HumanUserInterfaceTest {
  private HumanUserInterface humanUserInterface;

  IO ioMock = mock(IO.class);
  BoardPresenter boardPresenterMock = mock(BoardPresenter.class);
  NumberValidator numberValidatorMock = mock(NumberValidator.class);
  BoardState boardStateMock = mock(BoardState.class);

  @BeforeEach
  public void setUp() {
    humanUserInterface = new HumanUserInterface(ioMock, boardPresenterMock, "Player one wins!\n", "Player two wins!\n");
  }

  @Test
  public void testDisplayMessage() {
    doNothing().when(ioMock).display("test");
    humanUserInterface.displayMessage("Welcome to Tic Tac Toe!\n");
    verify(ioMock, times(1)).display("Welcome to Tic Tac Toe!\n");
  }

  @Test
  public void testDisplayBoard() {
    doNothing().when(ioMock).display("test");
    humanUserInterface.displayBoard(boardStateMock);
    verify(ioMock, times(1)).display(null);
  }

  @Test
  public void testUserPrompt() {
    when(ioMock.getInput()).thenReturn("1");
    when(numberValidatorMock.isValidInput("1")).thenReturn(true);
    doNothing().when(ioMock).display("test");
    assertEquals("1", humanUserInterface.userPrompt("test", numberValidatorMock));
  }

  @Test
  public void testDisplayTie() {
    doNothing().when(ioMock).display("It's a tie!\n");
    humanUserInterface.displayTie();
    verify(ioMock, times(1)).display("It's a tie!\n");
  }

  @Test
  public void testGreetUser() {
    doNothing().when(ioMock).display("Welcome to Tic Tac Toe!\n");
    humanUserInterface.greetUser();
    verify(ioMock, times(1)).display("Welcome to Tic Tac Toe!\n");
  }

  @Test
  public void testDisplayWinnerForPlayerOne() {
    doNothing().when(ioMock).display("Player one wins!\n");
    humanUserInterface.displayWinner(true);
    verify(ioMock, times(1)).display("Player one wins!\n");
  }

  @Test
  public void testDisplayWinnerForPlayerTwo() {
    doNothing().when(ioMock).display("Player two wins!\n");
    humanUserInterface.displayWinner(false);
    verify(ioMock, times(1)).display("Player two wins!\n");
  }

}
package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HumanUserInterfaceTest {
  private HumanUserInterface humanUserInterface;

  private ByteArrayOutputStream outContent;
  private PrintStream stdout;
  private InputStream stdin;
  private IO IO;
  IO ioMock = mock(IO.class);
  BoardPresenter boardPresenterMock = mock(BoardPresenter.class);
  NumberValidator numberValidatorMock = mock(NumberValidator.class);
  BoardState boardStateMock = mock(BoardState.class);


  @BeforeEach
  public void setUp() {
    humanUserInterface = new HumanUserInterface(ioMock, boardPresenterMock);
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

  @Test
  public void testSetLoseMessage() {
    humanUserInterface.setLoseMessage("You Lose!\n");
    humanUserInterface.displayWinner(false);
    doNothing().when(ioMock).display("You Lose!\n");
    verify(ioMock, times(1)).display("You Lose!\n");
  }

  @Test
  public void testSetWinMessage() {
    humanUserInterface.setWinMessage("You Win!\n");
    humanUserInterface.displayWinner(true);
    doNothing().when(ioMock).display("You Win!\n");
    verify(ioMock, times(1)).display("You Win!\n");
  }

  @Test
  public void testClearScreen() {
    outContent = new ByteArrayOutputStream();
    stdout = new PrintStream(outContent);
    stdin = System.in;
    IO = new IO(stdout, stdin);
    PrintStream originalOut = System.out;
    System.setOut(stdout);

    UserInterface userInterface = new HumanUserInterface(IO, boardPresenterMock);
    userInterface.clearScreen();

    assertEquals("\033[H\033[2J", outContent.toString());
    System.setOut(originalOut);
  }

}
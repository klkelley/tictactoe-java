package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInterfaceTest {
  private ByteArrayOutputStream outContent;
  private PrintStream stdout;
  private InputStream stdin;
  private UserInterface userInterface;

  @BeforeEach
  public void setUp() {
    outContent = new ByteArrayOutputStream();
    stdout = new PrintStream(outContent);
    stdin = System.in;
    userInterface = new UserInterface(stdout, stdin);
  }

  @Test
  public void testDisplay() {
    String message = "Welcome to Tic Tac Toe!\n";
    userInterface.display(message);

    assertEquals("Welcome to Tic Tac Toe!\n", outContent.toString());
  }

  @Test
  public void testGetInput() {
    ByteArrayInputStream in = new ByteArrayInputStream("\r".getBytes());
    System.setIn(in);

    UserInterface getUserInterface = new UserInterface(stdout, in);
    assertEquals("", getUserInterface.getInput("Please press \"ENTER\" to continue\n"));
  }
}
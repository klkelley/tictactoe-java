package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITest {
  private ByteArrayOutputStream outContent;
  private PrintStream stdout;
  private InputStream stdin;
  private UI userInterface;

  @BeforeEach
  public void setUp() {
    outContent = new ByteArrayOutputStream();
    stdout = new PrintStream(outContent);
    stdin = System.in;
    userInterface = new UI(stdout, stdin);
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

    UI getUserInterface = new UI(stdout, in);
    assertEquals("", getUserInterface.getInput("Please press \"ENTER\" to continue\n"));
  }
}
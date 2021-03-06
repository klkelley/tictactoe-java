package me.karakelley.tictactoe.UI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOTest {
  private ByteArrayOutputStream outContent;
  private PrintStream stdout;
  private InputStream stdin;
  private me.karakelley.tictactoe.UI.IO IO;

  @BeforeEach
  public void setUp() {
    outContent = new ByteArrayOutputStream();
    stdout = new PrintStream(outContent);
    stdin = System.in;
    IO = new IO(stdout, stdin);
  }

  @Test
  public void testGetInput() {
    ByteArrayInputStream in = new ByteArrayInputStream("\r".getBytes());

    IO getIO = new IO(stdout, in);
    assertEquals("", getIO.getInput());
    System.setIn(stdin);
  }

  @Test
  public void testDisplay() {
    PrintStream originalOut = System.out;
    System.setOut(stdout);
    IO.display("Test");

    assertEquals("Test", outContent.toString());
    System.setOut(originalOut);
  }

}
package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOTest {
  private ByteArrayOutputStream outContent;
  private PrintStream stdout;
  private InputStream stdin;
  private IO IO;

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
    System.setIn(in);

    IO getIO = new IO(stdout, in);
    assertEquals("", getIO.getInput("Please press \"ENTER\" to continue\n"));
  }
}
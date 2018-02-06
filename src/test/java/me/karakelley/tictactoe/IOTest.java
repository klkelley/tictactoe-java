package me.karakelley.tictactoe;


import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;


public class IOTest {
  private ByteArrayOutputStream outContent;
  private PrintStream stdout;
  private InputStream stdin;
  private IO IO;

  @Before
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

  @Test
  public void testAnyKey() throws IOException, InterruptedException {
    ByteArrayInputStream input = new ByteArrayInputStream("T".getBytes());
    IO getIO = new IO(stdout, input);

    assertEquals('T',     getIO.anyKey());
  }
}
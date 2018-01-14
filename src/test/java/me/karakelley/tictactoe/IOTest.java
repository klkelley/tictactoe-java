package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

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
    assertEquals("", getIO.getInput());
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
    String data = "T";
    ByteArrayInputStream input = new ByteArrayInputStream("T".getBytes());
    System.setIn(input);
    IO getIO = new IO(stdout, input);

    assertEquals('T',     getIO.anyKey());
    System.setIn(stdin);
  }
}
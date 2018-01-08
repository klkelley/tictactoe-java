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
    public void testWelcomeMessage() {
      userInterface.welcomeMessage();

      assertEquals("Welcome to Tic Tac Toe!\n", outContent.toString());
    }

    @Test
    public void testDisplayBoard() {
      userInterface.displayBoard();
      assertEquals("   |   |   \n" +
                            " 0 | 1 | 2 \n" +
                            "   |   |   \n" +
                            "___________\n" +
                            "   |   |   \n" +
                            " 3 | 4 | 5 \n" +
                            "   |   |   \n" +
                            "___________\n" +
                            "   |   |   \n" +
                            " 6 | 7 | 8 \n" +
                            "   |   |   \n" +
                            "\n ", outContent.toString());
  }

  @Test
  public void testPromptEnterKey() {
    String keyboardInput = "";
    try {
      System.setIn(new ByteArrayInputStream(keyboardInput.getBytes()));
    }
    finally {
      System.setIn(stdin);
    }

    assertEquals("", outContent.toString());
  }
}
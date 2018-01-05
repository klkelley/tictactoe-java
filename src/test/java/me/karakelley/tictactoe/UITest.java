package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITest {

    @Test
    public void welcomeMessage() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream stdout = new PrintStream(outContent);
        UI game = new UI(stdout);
        game.welcomeMessage();

        assertEquals("Welcome to Tic Tac Toe!\n", outContent.toString());
    }
}
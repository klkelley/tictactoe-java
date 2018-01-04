package me.karakelley.tictactoe;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITest {

    @Test
    public void welcomeMessage() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        UI game = new UI();
        game.welcomeMessage();
        assertEquals("Welcome to Tic Tac Toe!\n", outContent.toString());
    }
}
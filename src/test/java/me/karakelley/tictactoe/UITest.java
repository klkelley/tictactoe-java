package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITest {

    @Test

    public void testMessage() {
        UI userInterface = new UI();
        assertEquals("Welcome to Tic Tac Toe!", userInterface.message("Welcome to Tic Tac Toe!"));
    }
}
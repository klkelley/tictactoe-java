package me.karakelley.tictactoe;

import java.io.PrintStream;

public class UI {
    public PrintStream output;

    public UI(PrintStream out) {
        output = out;
    }

    public void welcomeMessage() {
       output.println("Welcome to Tic Tac Toe!");
    }

}


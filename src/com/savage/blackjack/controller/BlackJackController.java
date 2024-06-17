package com.savage.blackjack.controller;

import com.apps.util.Prompter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static com.apps.util.Console.clear;
import static com.apps.util.Console.pause;

public class BlackJackController {
    private final Prompter prompter = new Prompter(new Scanner(System.in));


    public void playGame() {
        welcome();
        playerQuestions();
        goodBye();
    }

    public void welcome(){
        try {
            clear();
            String welcome = Files.readString(Path.of("resources/welcome"));
            System.out.println("\n" + welcome + "\n");
            pause(2000);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playerQuestions(){

    }

    public void goodBye(){

    }

}

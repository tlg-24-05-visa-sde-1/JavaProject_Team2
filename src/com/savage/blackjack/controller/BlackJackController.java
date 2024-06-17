package com.savage.blackjack.controller;

import com.apps.util.Prompter;
import com.savage.blackjack.Dealer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static com.apps.util.Console.clear;
import static com.apps.util.Console.pause;

public class BlackJackController {
    private final Prompter prompter = new Prompter(new Scanner(System.in));
    private final Dealer dealer = new Dealer();


    public void playGame() {
        welcome();
        playerQuestions();
        beginGame();
        finalResults();
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
        clear();

        boolean finished = false;
        while (!finished){
            String playerInput = prompter.prompt("Please enter your name, then press [Enter] when done: ");
            if(!playerInput.trim().isEmpty()) {
                dealer.addPlayer(playerInput);
            }
            else {
                finished = true;
            }
        }
        goodBye();
    }

    public void beginGame() {

    }

    public void finalResults(){

    }

    public void goodBye(){

    }

}

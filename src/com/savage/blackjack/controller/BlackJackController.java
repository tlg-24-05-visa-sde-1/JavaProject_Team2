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
        gameQuestions();
        initialDeal();
        showHand();
        anyBlackJack();
        finalResults();
        goodBye();
    }

    public void welcome(){
        try {
            clear();
            String welcome = Files.readString(Path.of("resources/welcome"));
            System.out.println("\n" + welcome + "\n");
            pause(1000);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gameQuestions(){
        clear();

        boolean finished = false;
        while (!finished){
            String playerName = prompter.prompt("Please enter your name, then press [Enter] when done: ");
            if(!playerName.trim().isEmpty()) {
                dealer.addPlayer(playerName);
//                dealer.dump();
            }
            else {
                finished = true;
            }
        }
    }

    public void initialDeal(){
        dealer.dealCards();
    }

    public void showHand() {
        dealer.showHands();
    }

    public void anyBlackJack() {

    }




/*    private void hitMeOrStand() {
        clear();

        player.scoreHand();
        boolean yourTurn = false;
        while(!yourTurn){
            String playerInput = prompter.prompt("What's your next move? 'Hit Me' or 'Stand': ");
            if("Hit me".equals(playerInput)){
                dealer.giveCard();
                player.scoreHand();
            } else if("Stand".equals(playerInput)){
                player.scoreHand();
            }
        }
    }*/




    public void finalResults(){

    }

    public void goodBye(){

    }


}
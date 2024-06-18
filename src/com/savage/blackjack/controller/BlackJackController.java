package com.savage.blackjack.controller;

import com.apps.util.Prompter;
import com.savage.blackjack.Dealer;
import com.savage.blackjack.Hand;
import com.savage.blackjack.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static com.apps.util.Console.clear;
import static com.apps.util.Console.pause;


public class BlackJackController {
    //    private String playerName;
    private final Prompter prompter = new Prompter(new Scanner(System.in));
    private final Dealer dealer = new Dealer();
    private final Player player = new Player();
    private final Hand hand = new Hand();


    public void playGame() {
        welcome();
        playerQuestions();
        dealer.dealCards(player);
        hand.scoreHand();
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

    public void playerQuestions(){
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
//        goodBye();
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

/*    public void beginGame() {
        // might need to be in a while loop
        boolean gameIsOn = true;



            //        player.hasBlackJack();  // not sure if we need to call before if statement
            //        dealer.hasBlackJack();

            if (player.hasBlackJack() || dealer.hasBlackJack()) {
                finalResults();
                goodBye();
                break;
            }

            gameIsOn = false;

            hitMeOrStand();

     }*/



    public void finalResults(){

    }

    public void goodBye(){

    }


}
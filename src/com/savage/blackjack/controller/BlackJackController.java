package com.savage.blackjack.controller;

import com.apps.util.Prompter;
import com.savage.blackjack.Dealer;
import com.savage.blackjack.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static com.apps.util.Console.clear;
import static com.apps.util.Console.pause;


public class BlackJackController {
    private final Prompter prompter = new Prompter(new Scanner(System.in));
    private final Dealer dealer = new Dealer();
    private boolean gameInProgress = true;


    public void playGame() {
        welcome();
        gameQuestions();
        while (gameInProgress) {
            initialDeal();
            if (dealer.getPlayerHands().size() == 1 && checkForInitialBlackJack()) {
                showHand();
                finalResults();
                playAgain();
                continue;
            }
            if (checkDealerBlackJack()){
                showHand();
                finalResults();
                playAgain();
                continue;
            }
            showHand();
            playerGo();
            dealerGo();
            finalResults();
            playAgain();
            goodBye();
        }
    }

    public void welcome() {
        try {
            clear();
            String welcome = Files.readString(Path.of("resources/welcome"));
            System.out.println("\n" + welcome + "\n");
            pause(1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gameQuestions() {

        boolean finished = false;
        while (!finished) {
            String playerName = prompter.prompt("Please enter your name, then press [Enter] when done: ");
            if (!playerName.trim().isEmpty()) {
                dealer.addPlayer(playerName);
                clear();
            } else {
                finished = true;
            }
        }
    }

    public void initialDeal() {
        dealer.dealCards();
    }

    public void showHand() {
        dealer.showHands();
    }

    public void playerGo() {
        for (String playerName : dealer.getPlayerNames()) {
            boolean gameOn = true;
            while (gameOn && dealer.playerContinueGame(playerName)) {
//                clear();

                String answer = prompter.prompt(playerName + ", Would you like to 'Hit' or 'Stand': "
                ).trim().toLowerCase();
                switch (answer) {
                    case "hit" -> {
                        dealer.giveNextPlayerCard(playerName);
                        dealer.showHands();
                    }
                    case "stand" -> gameOn = false;
                    default -> System.out.printf("Invalid choice. Please type 'Hit' or 'Stand'");
                }
            }
        }
    }

    public void dealerGo() {
        while (dealer.dealerContinueGame()) {
            dealer.giveNextDealerCard();
            dealer.showHands();
        }
    }

    public boolean checkForInitialBlackJack() {
        boolean dealerHasBlackJack = dealer.getDealerHand().hasBlackjack();
        boolean playerHasBlackJack = false;
        Player playerWithBlackJack = null;

        for (var entry : dealer.getPlayerHands().entrySet()) {
            var player = entry.getKey();
            var hand = entry.getValue();
            if (hand.hasBlackjack()) {
                playerHasBlackJack = true;
                playerWithBlackJack = player;
            }
        }

        if (dealerHasBlackJack || playerHasBlackJack) {
            System.out.println();
            if (playerHasBlackJack && !dealerHasBlackJack) {
                System.out.println(playerWithBlackJack.getName() + " has BlackJack and wins!");
            } else if (!playerHasBlackJack && dealerHasBlackJack) {
                System.out.println("Dealer has Blackjack and wins!");
            } else if (playerHasBlackJack && dealerHasBlackJack) {
                System.out.println(playerWithBlackJack.getName() + " ties with the dealer with Blackjack!");
            }
            return true;
        }
        return false;
    }

    public boolean checkDealerBlackJack() {
        boolean dealerHasBlackJack = dealer.getDealerHand().hasBlackjack();
        boolean anyPlayerHasBlackJack = false;

        if (dealerHasBlackJack) {
            for (var entry : dealer.getPlayerHands().entrySet()) {
                var player = entry.getKey();
                var hand = entry.getValue();
                if (hand.hasBlackjack()) {
                    System.out.printf("%s and the Dealer both have BlackJack! They have a tie!", player.getName());
                    anyPlayerHasBlackJack = true;
                }
            }
            if (!anyPlayerHasBlackJack) {
                System.out.println();
            }
            return true; // Game ends
        }
        return false; // Game continues
    }

    public void playAgain() {
        String answer = prompter.prompt("Do you want to play again? 'Yes' or 'No': "
        ).trim().toLowerCase();
        if ("no".equals(answer)) {
            gameInProgress = false;
            clear();
            goodBye();
        } else if ("yes".equals(answer)) {
            clear();
            dealer.resetHands();
            gameQuestions();
        } else {
            System.out.printf("Please enter 'Yes' or 'No': ");
        }
    }

/*    public void anyBlackJack() {
        for (var entry : dealer.getPlayerHands().entrySet()) {
            var player = entry.getKey();
            var hand = entry.getValue();
        }
    }*/

    public void finalResults() {
        dealer.showResults();
    }

    public void goodBye() {
        clear();
        System.out.println("Thanks for playing Savage BlackJack");
    }
}
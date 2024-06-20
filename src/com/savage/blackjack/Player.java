package com.savage.blackjack;

import java.util.List;
import java.util.Scanner;

public class Player {

    private String name;
    private Integer cardScore;
    private Hand hand;
    private Scanner scanner;

//    public List<Card> myCards = new ArrayList<>();

    public Player(){
        hand = new Hand();
        scanner = new Scanner(System.in);
    }

    public Player(String name){
        this.name = name;
        hand = new Hand();
    }

    public PlayerResponse responseToDealer(){
        return PlayerResponse.HIT_ME;
    }


    public String getName() {
        return name;
    }


    public List<Card> checkCards(){
        return hand.getCards();
    }

    public void addCard(Card card){ // *Dai* - I added this method
        hand.addCard(card);
    }

    public boolean hasBlackJack(){
        return hand.hasBlackjack();
    }


    public boolean isBust(){
        return hand.isBusted();
    }

    public void scoreHand() { // *Dai* - I added this method
        hand.scoreHand();
    }

    /*public void playerTurn(Dealer dealer) { // *Dai* - I added this method
        boolean playing = true;
        while (playing) {
            System.out.printf("%s's hand %s/n", getName(), hand.handValue());
            System.out.println("Would you like to 'Hit' or 'Stand'?");
            String decision = scanner.nextLine().trim().toLowerCase();
            if (decision.equals("hit")) {
                addCard(dealer.giveNextCard());
                if (hand.handValue() > 21) {
                    System.out.printf("You Bust! %s Your Cards Exceed 21.", getName());
                    playing = false;
                }
            } else {
                System.out.println("Invalid Choice. Please enter 'Hit' or 'Stand'.");
            }
        }
    }*/


//    public void scoreHand(){
//        System.out.println(hand);
//        // iterate through myCards and show current player hand
//    }

    public String toString() {
        return "name= " + name + "cards= ";
    }

    public void dump(){
            System.out.println(hand);
    }

}
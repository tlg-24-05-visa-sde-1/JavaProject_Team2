package com.savage.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards;


    public Hand(){
        cards = new ArrayList<>();
    }


    public Hand(Dealer dealer){
        this.dealer = dealer;
    }


    public void addCard(Card card) {
      hand.add(card);


    public void addCard(Card card) {
        // Get 2 shuffled cards from CardEnum and add them to myCards
        // List in Player and dealerCards
        cards.add(card);

    }

    public int handValue(){
        int value = 0; // add up the value of cards in hand
        int aces = 0;
        for (Card card : cards) {
            value += card.getValue();
            // this logic helps us create the value for aces. If the cards value is 11, it's automatically an ace since only ace can have a value of 11.
            if (card.getValue() == 11){
                aces++;// increments count of aces
            }
            // we need logic to subtract 10 from the hand if there is an ace if the value of our hand is over 21
            while ( value > 21 && aces > 0 ) {
                value -= 10;
                aces--; // decreases count of aces
            }
        }
        return value;
    }

    // after you create a method for the hand value, you can write more conditional statements to determine blackjack or bust
    boolean handIsBust(){
        return handValue() > 21;
    }


    public boolean isBusted() {
        return true;
    }

    public void scoreHand(){
        for (Card card : hand){
            System.out.print(card.getValue());
            System.out.print(card.getImageContent());
        }
        // iterate through myCards and show current player hand

    public boolean hasBlackjack() {
        return cards.size() == 2 && handValue() == 21;
    }

    public int scoreHand(){ // *Dai* - I added this scoreHand information to work with the hit or stand method in player
        return handValue();
    }

    public List<Card> getCards() {
        return cards;

    }

    public String toString(){
        String output = "";
        for(Card card : cards){
            System.out.println(card.getValue());
        }
        return output;
    }
}
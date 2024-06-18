package com.savage.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public static final Integer BLACK_JACK_NUM = 21;

    private List<Card> cards;

    public Hand(){
        cards = new ArrayList<>();
    }


    public void addCards() {
        // Get 2 shuffled cards from CardEnum and add them to myCards
        // List in Player and dealerCards
        cards.add(Card.ACE_HEARTS);
        cards.add(Card.TEN_DIAMONDS);
    }

    public int handValue(){
        int value = 0; // add up the value of cards in hand
        int aces = 0;
        for (Card card : cards) {
            value += card.getValue();
            if (card.getValue() == 11){
                aces++;// increments count of aces
            }
            while ( value > 21 && aces > 0 ) {
                value -= 10;
                aces--; // decreases count of aces
            }
        }
        return value;
    }

    boolean handIsBust(){
        return handValue() > 21;
    }

    public boolean hasBlackjack() {
        return cards.size() == 2 && handValue() == 21;
    }

 //   public int scoreHand(){ // *Dai* - I added this scoreHand information to work with the hit or stand method in player
//        int score = 0;
//        int aceCount = 0;
//        for (Card card : cards){
//            if(card.getValue() == 11) {
//                aceCount++;
//            }
//        }
//        while (score > BLACK_JACK_NUM && aceCount > 0){
//            score -= 10;
//            aceCount--;
//        }
//        // iterate through myCards and show current player hand
//        return score;
//        return scoreHand();
//    }
 public void scoreHand(){
     for (Card card : cards){
         System.out.println(card.getValue());
     }
     // iterate through myCards and show current player hand
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
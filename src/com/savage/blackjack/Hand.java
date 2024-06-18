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
        cards.add(Card.FOUR_SPADES);
    }

    public void addCard(Card card) { // *Dai* - I added this method
        cards.add(card);
    }

    public boolean isBlackJack() {
        boolean result = false;
        int sum = 0;
        for(Card card : cards){
            sum += card.getValue();
        }

        if(sum == BLACK_JACK_NUM){
            result = true;
        }
        return result;
    }

    public boolean isBusted() {
        return true;
    }

    public int scoreHand(){ // *Dai* - I added this scoreHand information to work with the hit or stand method in player
        int score = 0;
        int aceCount = 0;
        for (Card card : cards){
            if(card.getValue() == 11) {
                aceCount++;
            }
        }
        while (score > BLACK_JACK_NUM && aceCount > 0){
            score -= 10;
            aceCount--;
        }
        // iterate through myCards and show current player hand
        return score;
    }

    public String toString(){
        String output = "";
        for(Card card : cards){
            System.out.println(card.getValue());
        }
        return output;
    }
}
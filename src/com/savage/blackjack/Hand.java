package com.savage.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public static final Integer BLACK_JACK_NUM = 21;

    private List<Card> hand;

    public Hand(){
        hand = new ArrayList<>();
    }


    public void addCards() {
        // Get 2 shuffled cards from CardEnum and add them to myCards
        // List in Player and dealerCards
        hand.add(Card.ACE_HEARTS);
        hand.add(Card.FOUR_SPADES);
    }

    public boolean isBlackJack() {
        boolean result = false;
        int sum = 0;
        for(Card card : hand){
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

    public void scoreHand(){
        for (Card card : hand){
            System.out.println(card.getValue());
        }
        // iterate through myCards and show current player hand
    }

    public String toString(){
        String output = "";
        for(Card card : hand){
            System.out.println(card.getValue());
        }
        return output;
    }
}



package com.savage.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public static final Integer BLACK_JACK_NUM = 21;

    private List<Card> cards = new ArrayList<>();

    public Hand(){
    }


    public void addCards() {
        // Get 2 shuffled cards from CardEnum and add them to myCards
        // List in Player and dealerCards
        cards.add(Card.ACE_HEARTS);
        cards.add(Card.FOUR_SPADES);
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

    public void scoreHand(){
        for (Card card : cards){
            System.out.println(card.getValue());
        }
        // iterate through myCards and show current player hand
    }

//    public int getCardValue(){
//        return 0;
//    }
}

package com.savage.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public static final Integer BLACK_JACK_NUM = 21;
    public static final Integer INITIAL_CARDS = 2;

    private Dealer dealer;
    private List<Card> hand;

    public Hand(){
        hand = new ArrayList<>();
    }

    public Hand(Dealer dealer){
        this.dealer = dealer;
    }


    public void addCard(Card card) {
      hand.add(card);


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

//    public int handValue(){
//        int value = 0; // add up the value of cards in hand
//        int aces = 0;
//        for (Card card : cards) {
//            value += card.getValue();
//            if (card.getValue() == 11){
//                aces++;// increments count of aces
//            }
//            while ( value > 21 && aces > 0 ) {
//                value -= 10;
//                aces--; // decreases count of aces
//            }
//        }
//        return value;
//    }

    public boolean isBusted() {
        return true;
    }

    public void scoreHand(){
        for (Card card : hand){
            System.out.print(card.getValue());
            System.out.print(card.getImageContent());
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



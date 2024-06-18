package com.savage.blackjack;
import java.util.ArrayList;
import java.util.List;

/*
 * Hand class needs a collection/list of cards
 * the ability to add cards
 * a method to add and calculate the total value of the cards in hand
 * keep track of the aces (Iterate or map)
 * a bust method
 * has black jack?
 */

//Class definition
public class Hand {
    //List to store the cards in a hand
    private final List<Card> cards = new ArrayList<>();

    // constructor
    public Hand() {;
    }

    //the ability to add and create cards
    public void addCard(Card card){
        cards.add(card);
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

    // conditional statement for 21
    public boolean hasBlackjack() {
        return cards.size() == 2 && handValue() == 21;
    }
    // if hand is over 21, it's bust
    boolean handIsBust(){
        return handValue() > 21;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Hand{" + "cards=" + handValue() + '}';
    }
}


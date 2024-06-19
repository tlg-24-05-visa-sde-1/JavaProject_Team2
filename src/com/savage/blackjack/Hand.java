package com.savage.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> hand = new ArrayList<>();
    private Dealer dealer ;

    public Hand(){
    }

    public Hand(Dealer dealer){
        this.dealer = dealer;
    }

    public void addCard(Card card) {
        hand.add(card);
//        hand.add(Card.ACE_HEARTS);
//        hand.add(Card.JACK_CLUBS);
    }

    public int handValue() {
        int value = 0;
        int aces = 0;

        for (Card card : hand) {
            value += card.getValue();
            if (card.getValue() == 11) {
                aces++;
            }
        }

        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }

        return value;
    }

    public boolean isBusted() {
        return handValue() > 21;
    }

    public void scoreHand() {
        for (Card card : hand) {
//            List<String> imagelines = card.getImageLines();
            System.out.print(card.getImageContent());
        }
    }


    public boolean hasBlackjack() {
        boolean result = false;
        if (hand.size() == 2 && handValue() == 21){
            result = true;
        }
        else if (hand.size() > 2 && handValue() == 21){
            result = false;
        }
        return result;
    }

    public List<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Card card : hand) {
            output.append(card.getValue()).append(" ");
        }
        return output.toString();
    }
}
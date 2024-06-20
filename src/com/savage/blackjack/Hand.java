package com.savage.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> Cards = new ArrayList<>();
    private Dealer dealer ;

    public Hand(){
    }

    public Hand(Dealer dealer){
        this.dealer = dealer;
    }

    public void addCard(Card card) {
        Cards.add(card);
//        hand.add(Card.ACE_HEARTS);
//        hand.add(Card.JACK_CLUBS);
    }


    public int handValue() {
        int value = 0;
        int aces = 0;

        for (Card card : Cards) {
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
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            StringBuilder line = new StringBuilder();
            for (Card card : Cards) {
                line.append(card.getImageLines().get(i)).append(" ");
            }
            line.append("\n");
            output.append(line);
        }
        System.out.println(output);
    }


    public boolean hasBlackjack() {
        boolean result = false;
        if (Cards.size() == 2 && handValue() == 21){
            result = true;
        }
        else if (Cards.size() > 2 && handValue() == 21){
            result = false;
        }
        return result;
    }

    public List<Card> getCards() {
        return Cards;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Card card : Cards) {
            output.append(card.getValue()).append(" ");
        }
        return output.toString();
    }
}
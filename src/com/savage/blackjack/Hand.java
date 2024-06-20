package com.savage.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private Dealer dealer;

    public Hand() {
    }

    public Hand(Dealer dealer) {
        this.dealer = dealer;
    }

    public void addCard(Card card) {
        cards.add(card);

    }


    public int handValue() {
        int value = 0;
        int aces = 0;

        for (Card card : cards) {
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
            for (Card card : cards) {
                line.append(card.getImageLines().get(i)).append(" ");
            }
            line.append("\n");
            output.append(line);
        }
        System.out.println(output);
    }


    public boolean hasBlackjack() {
        boolean result = false;
        if (cards.size() == 2 && handValue() == 21){
            result = true;
        }
        else if (cards.size() > 2 && handValue() == 21){
            result = false;
        }
        return result;
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Card card : cards) {
            output.append(card.getValue()).append(" ");
        }
        return output.toString();
    }
}
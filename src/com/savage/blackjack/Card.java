package com.savage.blackjack;

public class Card {
    private final Suit suit;
    private final Value value;

    /*
     * Below the Suit of the card is created
     * Below the Value of the card is created
     */
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Card(Card card) {
        this.suit = card.getSuit();
        this.value = card.getValue();
    }

    // ctors
    public int getCardValue(){
        return value.cardValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }



}
package com.savage.blackjack;

public enum Suit {
    SPADE("Spades"),
    DIAMOND("Hearts"),
    HEART("Hearts"),
    CLUB("Clubs");

    final String suitName;

    Suit(String suitName) {
        this.suitName = suitName;
    }

    public String toString(){
        return suitName;
    }
}
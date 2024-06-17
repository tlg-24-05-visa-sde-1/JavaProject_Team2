package com.savage.blackjack;

public enum Card {
    ACE_SPADES(11),
    TWO_SPADES(2),
    THREE_SPADES(3),
    FOUR_SPADES(4);

    private int value;

    Card(int value) {
        this.value = value;
    }
}
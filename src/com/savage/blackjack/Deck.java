package com.savage.blackjack;


import java.util.ArrayList;

class Deck {

    // List to hold the deck of cards
    private final ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
    }

    public Deck(boolean createDeck){
        deck = new ArrayList<>();
        if(createDeck){
            for(Suit suit : Suit.values()){
                for(Value value : Value.values()){
                    deck.add(new Card(suit, value));
                }
            }
        }
    }

    public void addCard(Card card) {
        deck.add(card);
    }


}

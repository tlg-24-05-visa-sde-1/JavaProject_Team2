package com.savage.blackjack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    // List to hold the deck of cards
    private final ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
    }

    // Add card to deck
    public void addCard(Card card) {
        deck.add(card);
    }

    // An ArrayList of cards to be added to the deck
    public void addCards(ArrayList<Card> cards) {
        deck.addAll(cards);
    }

    // Shuffle cards in the deck
    public void shuffle() {
        Collections.shuffle(deck);
    }

    // Take card from Deck
    public Card takeCardFromDeck(){
        Card takeCard = new Card(deck.get(0));
        deck.remove(0);
        return takeCard;
    }

    // Cards left in the Deck
    public int cardsRemaining(){
        return deck.size();
    }

    // Goes through all the suits, and values to add each to the deck
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
}

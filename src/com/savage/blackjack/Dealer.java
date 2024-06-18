package com.savage.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Dealer extends Player{

    private String name;
    private Hand dealerHand = new Hand();
    private List<Player> players = new ArrayList<>();
    private Map<Player, Hand> playerHands = new HashMap<>();
    private List<Card> deck;

    public Dealer() {
    }

    public void shuffleCards(){
    }

    public void addPlayer(String name){
        Player player = new Player(name);
        players.add(player);
        playerHands.put(player, new Hand());
    }

    public void dealCards(){
        for(Player player : players){
            Hand hand = playerHands.get(player);
            hand.addCards();
        }
        dealerHand.addCards();
    }

    public List<Integer> giveCard(){
        List<Integer > cards = null;
        // Get a single card from CardEnum, perhaps next card and add to
        // myCards list in Player

        return cards;
    }

    public Card giveNextCard() { // *Dai* - I added this method for the hit or stand
        if (deck.isEmpty()) {
            throw new IllegalStateException("Deck is empty, cannot deal anymore cards");
        }
        return deck.remove(0);
    }

    public void showHands() {
        for (Player player : players) {
            System.out.println(player.getName() + "'s hand:");
            playerHands.get(player).scoreHand();
        }
        System.out.println("Dealer's hand:");
        dealerHand.scoreHand();
    }


    public String toString() {
        return "name= " + name;
    }

    public void dump(){
        for(Player item : players){
            System.out.println(item.toString());
        }
    }
}
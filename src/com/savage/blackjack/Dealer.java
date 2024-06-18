package com.savage.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Dealer extends Player{
//    private List<Card> deck;
    private String name;
    private Hand dealerHand = new Hand();
    private List<Player> players = new ArrayList<>();
    private Map<Player, Hand> playerHands = new HashMap<>();
//    private Hand hand = new Hand();

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
//
//    public Card giveNextCard() { // *Dai* - I added this method for the hit or stand
//        if (deck.isEmpty()) {
//            throw new IllegalStateException("Deck is empty, cannot deal anymore cards");
//        }
//        return deck.remove(0);
//    }

    // Show hands
    public void showHands() {
        for (Player player : players) {
            System.out.println(player.getName() + "'s hand:");
            playerHands.get(player).scoreHand();
            if (playerHands.get(player).hasBlackjack()) {
                System.out.println(player.getName()+ " Has Blackjack");
            } else if (playerHands.get(player).handIsBust()) {
                System.out.println(player.getName() + "is Bust");
            }
        }
        System.out.println("Dealer's hand:");
        dealerHand.scoreHand();
        if (dealerHand.hasBlackjack()){
            System.out.println("Dealer has Blackjack");
        } else if (dealerHand.handIsBust()) {
            System.out.println(" Dealer is Bust");}
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
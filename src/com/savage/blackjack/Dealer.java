package com.savage.blackjack;

import java.util.*;


public class Dealer extends Player{
//    public static final Integer BLACK_JACK_NUM = 21;

    private String name;
    private List <Card> deck = new ArrayList<>();
    private Hand dealerHand = new Hand();
    private List<Player> players = new ArrayList<>();
    private Map<Player, Hand> playerHands = new HashMap<>();

    public Dealer() {
    }

    public void shuffleCards(){
        if(deck.isEmpty()){
            Collections.addAll(deck, Card.values());
        }

        Collections.shuffle(deck);
    }

    public void addPlayer(String name){
        Player player = new Player(name);
        players.add(player);
        playerHands.put(player, new Hand());
    }

    public void dealCards(){
        shuffleCards();
        for(Player player : players){
            Hand hand = playerHands.get(player);
            hand.addCard(drawCard());
            hand.addCard(drawCard());
        }
        dealerHand.addCard(drawCard());
        dealerHand.addCard(drawCard());

    }

    public Card drawCard() {
        if (deck.isEmpty()) {
            // throw exception
            System.out.println("The deck is empty");
        }
        return deck.remove(deck.size() - 1);
    }

    public List<Integer> giveCard(){
        List<Integer > cards = null;
        // Get a single card from CardEnum, perhaps next card and add to
        // myCards list in Player

        return cards;
    }


    public void showHands() {
        for (Player player : players) {
            System.out.println(player.getName() + "'s hand:");
            playerHands.get(player).scoreHand();
//            System.out.println();
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
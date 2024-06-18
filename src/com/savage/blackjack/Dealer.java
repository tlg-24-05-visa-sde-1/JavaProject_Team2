package com.savage.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dealer extends Player{
    private String name;
    private List<Card> dealerCards = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private Player player = new Player();

    public Dealer() {
    }

    public void shuffleCards(){

    }

    public void dealCards(){

        // Get 2 shuffled cards from CardEnum and add them to myCards
        // List in Player and dealerCards
        dealerCards.add(Card.ACE_SPADES);
        dealerCards.add(Card.FOUR_SPADES);

        player.myCards.add(Card.TWO_SPADES);

    }

    public List<Integer> giveCard(){
        List<Integer > cards = null;
        // Get a single card from CardEnum, perhaps next card and add to
        // myCards list in Player

        return cards;
    }


    public void addPlayer(String name){
        players.add(new Player(name));
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

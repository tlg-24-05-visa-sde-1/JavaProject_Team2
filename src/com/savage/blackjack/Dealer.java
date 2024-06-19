package com.savage.blackjack;

import java.util.*;


public class Dealer extends Player{

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
        playerHands.put(player, new Hand(this));
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

/*    public List<Integer> giveCard(){
        List<Integer > cards = null;
        // Get a single card from CardEnum, perhaps next card and add to
        // myCards list in Player

        return cards;
    }*/

    public void giveNextPlayerCard(String playerName) { // *Dai* - I added this method for the hit or stand
        Player player = players.stream().filter(p -> p.getName().equals(playerName)).findFirst().orElse(null);
        if(player != null){
            Hand hand = playerHands.get(player);
            hand.addCard(drawCard());

        }
    }

    public void giveNextDealerCard() {
        dealerHand.addCard(drawCard());
    }


    public void showHands() {
        for (Player player : players) {
            System.out.println(player.getName() + "'s hand:");
            playerHands.get(player).scoreHand();

            if (playerHands.get(player).hasBlackjack()) {
                System.out.println(player.getName()+ " has Blackjack");
            }
//            else if (playerHands.get(player).isBusted()) {
//                System.out.println(player.getName() + "is Bust");
//            }
        }

        System.out.println("Dealer's hand:");
        dealerHand.scoreHand();
        if (dealerHand.hasBlackjack()){
            System.out.println("Dealer has Blackjack");
        }

//        if(playerHands.get(player).hasBlackjack())


//        else if (dealerHand.isBusted()) {
//            System.out.println(" Dealer is Bust");}
    }

    public Map<Player, Hand> getPlayerHands() {
        return playerHands;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public List<String> getPlayerNames(){
        List<String> nameList = new ArrayList<>();
        for(Player player : players){
            nameList.add(player.getName());
        }
        return nameList;
    }

    public boolean playerContinueGame(String playerName) {
        Player player = players.stream().filter(p -> p.getName().equals(playerName))
                .findFirst().orElse(null);
        if (player != null) {
            Hand playerHand = playerHands.get(player);
            return playerHand.handValue() < 21;
        }
        return false;
    }

    public boolean dealerContinueGame(){
        return dealerHand.handValue() < 17 && !dealerHand.isBusted();
    }

    public void resetHands() {
        dealerHand = new Hand();
        playerHands.clear();
        players.clear();
        deck.clear();
        shuffleCards();

    }

    public void showResults() {
        for(Player player : players){
            Hand playerHand = playerHands.get(player);
            if (playerHand.isBusted()) {
                System.out.println(player.getName() + " busted with a total score " + playerHand.handValue());
            } else if (dealerHand.isBusted()){
                // do i have to iterate and check player with highest value
                System.out.println(player.getName() + " wins with " + playerHand.handValue() + " points. Dealer busted with"
                + dealerHand.handValue() + "points");
            } else if (playerHand.handValue() > dealerHand.handValue()) {
                System.out.println(player.getName() + " wins with " + playerHand.handValue() + " points.");
            } else if (playerHand.handValue() < dealerHand.handValue()) {
                System.out.println(player.getName() + " losses with " + playerHand.handValue() + " points.");
            } else {
                System.out.println(player.getName() + " ties with the dealer with " + playerHand.handValue());
            }
        }
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
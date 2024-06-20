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
        Hand hand = new Hand(this);
        playerHands.put(player, hand);

        checkEasterEgg(player, hand);
    }

    private void checkEasterEgg(Player player, Hand hand) {
        String name = player.getName();
        if (name.equalsIgnoreCase("tomi") || name.equalsIgnoreCase("dai") || name.equalsIgnoreCase("gabe")) {
            // Assign Blackjack cards (ACE and 10-value card)
            hand.addCard(Card.ACE_SPADES);  // You can change to any ACE
            hand.addCard(Card.KING_SPADES); // You can change to any 10-value card
        }
    }

    public void dealCards(){
        shuffleCards();
        for(Player player : players){
            Hand hand = playerHands.get(player);
            if (hand.getCards().isEmpty()) {
                hand.addCard(drawCard());
                hand.addCard(drawCard());
            }
        }
        dealerHand.addCard(drawCard());
        dealerHand.addCard(drawCard());

    }

    public Card drawCard() {
        if (deck.isEmpty()) {
            System.out.println("The deck is empty");
        }
        return deck.remove(deck.size() - 1);
    }

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
            System.out.println(player.getName() + "'s hand: "
            + playerHands.get(player).handValue());
            playerHands.get(player).scoreHand();

            if (playerHands.get(player).hasBlackjack()) {
                System.out.println(player.getName()+ " has Blackjack");
            }
        }

        System.out.println("Dealer's hand: "
        + dealerHand.handValue());
        dealerHand.scoreHand();

        if (dealerHand.hasBlackjack()){
            System.out.println("Dealer wins with BlackJack!");
        }
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
        for(Player player : players) {
            if(!playerHands.get(player).hasBlackjack())
                return dealerHand.handValue() < 17 && !dealerHand.isBusted();
        }
        return false;
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
            if (playerHand.isBusted() && !dealerHand.isBusted()) {
                System.out.printf("%s has BUSTED with a %s card score and LOST their hand to the Dealer.\n", player.getName(), playerHand.handValue());
                System.out.printf("The Dealer has BEAT %s and WON this hand with a %s card score.\n", player.getName(), dealerHand.handValue());
                System.out.println();
            } else if (dealerHand.isBusted() && !playerHand.isBusted()) {
                // do i have to iterate and check player with highest value
                System.out.printf("%s has BEAT the Dealer and WON their hand with a %s card score.\n", player.getName(), playerHand.handValue());
                System.out.printf("The Dealer BUSTED with a %s card score.\n", dealerHand.handValue());
                System.out.println();
            } else if (playerHand.isBusted() && dealerHand.isBusted()) {
                System.out.printf("%s and Dealer has BUSTED, this hand is a DRAW!.\n", player.getName());
                System.out.println();
            } else if (playerHand.handValue() > dealerHand.handValue()) {
                System.out.printf("%s has BEAT the Dealer and WON their hand with a %s card score.\n", player.getName(), playerHand.handValue());
                System.out.printf("Dealer has LOST to %s with a %s card score.\n", player.getName(), dealerHand.handValue());
                System.out.println();
            } else if (playerHand.handValue() < dealerHand.handValue()) {
                System.out.printf("%s has LOST their hand to the Dealer with a %s card score.\n", player.getName(), playerHand.handValue());
                System.out.printf("The Dealer has BEAT %s and WON this hand with a %s card score.\n", player.getName(), dealerHand.handValue());
                System.out.println();
            } else {
                System.out.printf("%s has a card score of %s.\nThe Dealer also has a card score of %s.\n%s and Dealer has a DRAW!.\n ",
                        player.getName(), playerHand.handValue(), dealerHand.handValue(), player.getName());
                System.out.println();
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
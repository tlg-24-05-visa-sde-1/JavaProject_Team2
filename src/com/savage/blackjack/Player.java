package com.savage.blackjack;

import java.util.*;

public class Player {

    private String name;
    private Integer cardScore;
    private Scanner scanner = new Scanner(System.in);
    private Hand hand;
//    private Hand hand = new Hand();
//    public List<Card> myCards = new ArrayList<>();

    public Player(){
    }

    public Player(String name){
        this.name = name;
    }

//    public PlayerResponse responseToDealer(){
//        return PlayerResponse.HIT_ME;
//
//
//    }

    public void addCard(Card card){ // *Dai* - I added this method
        hand.addCard(card);
    }

    public void scoreHand() { // *Dai* - I added this method
        hand.scoreHand();
    }

    public void playerTurn(Dealer dealer) { // *Dai* - I added this method
        boolean playing = true;
        while (playing) {
            System.out.printf("%s's hand %s/n", getName(), getCardScore());
            System.out.println("Would you like to 'Hit' or 'Stand'?");
            String decision = scanner.nextLine().trim().toLowerCase();
            switch (decision) {
                case "hit":
                    addCard(dealer.giveNextCard());
                    if (hand.scoreHand() > 21) {
                        System.out.printf("You Bust! %s Your Cards Exceed 21.", getName());
                        playing = false;
                    }
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter 'Hit' or 'Stand'.");
                    break;
            }
        }
    }

//    public void dealCards(Player player){
//        hand.addCards();
//    }

    public String getName() {
        return name;
    }

    public int getCardScore() { // *Dai* - I added this method
        return cardScore;
    }
//    public List<Card> checkCards(){
//        return myCards;
//    }

/*    public boolean hasBlackJack(){
        boolean result = false;
        int sum = 0;
        for(Card card : myCards){
            sum += card.getValue();
        }

        if(sum == BLACK_JACK_NUM){
            result = true;
        }
        return result;
    }*/

//    public void scoreHand(){
//        for (Card card : myCards){
//            System.out.println(card.getValue());
//        }
//
//        // iterate through myCards and show current player hand
//    }

    public String toString() {
        return "name= " + name + "cards= ";
    }

//    public void dump(){
//        for(Card item : myCards){
//            System.out.println(item.toString());
//        }
//    }

}
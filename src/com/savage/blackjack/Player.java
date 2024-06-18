package com.savage.blackjack;

import java.util.List;

public class Player {

    private String name;
    private Integer cardScore;
    private Hand hand;
//    public List<Card> myCards = new ArrayList<>();

    public Player(){
        hand = new Hand();
    }

    public Player(String name){
        this.name = name;
        hand = new Hand();
    }

    public PlayerResponse responseToDealer(){
        return PlayerResponse.HIT_ME;
    }


    public String getName() {
        return name;
    }

    public List<Card> checkCards(){
        return hand.getCards();
    }

    public boolean hasBlackJack(){
        return hand.hasBlackjack();
    }

//    public void scoreHand(){
//       System.out.println(hand);
//        // iterate through myCards and show current player hand
//    }

    public void dealtCard(){
        hand.addCards();
    }

    public boolean isBust(){
        return hand.handIsBust();
    }

//    public void addCard(Card card){ // *Dai* - I added this method
//        hand.addCard(card);
//    }
//
//    public void scoreHand() { // *Dai* - I added this method
//        hand.scoreHand();
//    }
//
//    public void playerTurn(Dealer dealer) { // *Dai* - I added this method
//        boolean playing = true;
//        while (playing) {
//            System.out.printf("%s's hand %s/n", getName(), getCardScore());
//            System.out.println("Would you like to 'Hit' or 'Stand'?");
//            String decision = scanner.nextLine().trim().toLowerCase();
//            switch (decision) {
//                case "hit":
//                    addCard(dealer.giveNextCard());
//                    if (hand.scoreHand() > 21) {
//                        System.out.printf("You Bust! %s Your Cards Exceed 21.", getName());
//                        playing = false;
//                    }
//                    break;
//                default:
//                    System.out.println("Invalid Choice. Please enter 'Hit' or 'Stand'.");
//                    break;
//            }
//        }
//    }

//    public void scoreHand(){
//        System.out.println(hand);
//        // iterate through myCards and show current player hand
//    }

    public String toString() {
        return "name= " + name + "cards= ";
    }

    public void dump(){
            System.out.println(hand);
    }

}
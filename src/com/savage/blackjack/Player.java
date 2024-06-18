package com.savage.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    private String name;
    private Integer cardScore;
//    private Hand hand = new Hand();
//    public List<Card> myCards = new ArrayList<>();

    public Player(){
    }

    public Player(String name){
        this.name = name;
    }

    public PlayerResponse responseToDealer(){
        return PlayerResponse.HIT_ME;


    }

//    public void dealCards(Player player){
//        hand.addCards();
//    }

    public String getName() {
        return name;
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
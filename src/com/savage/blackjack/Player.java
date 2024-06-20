package com.savage.blackjack;

import java.util.List;
import java.util.Scanner;

public class Player {

    private String name;
    private Integer cardScore;
    private Hand hand;
    private Scanner scanner;


    public Player() {
        hand = new Hand();
        scanner = new Scanner(System.in);
    }

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public String getName() {
        return name;
    }


    public List<Card> checkCards(){

        return hand.getCards();
    }

    public void addCard(Card card) { // *Dai* - I added this method
        hand.addCard(card);
    }

    public boolean hasBlackJack() {
        return hand.hasBlackjack();
    }


    public boolean isBust() {
        return hand.isBusted();
    }

    public void scoreHand() { // *Dai* - I added this method
        hand.scoreHand();
    }

    public String toString() {
        return "name= " + name + "cards= ";
    }

    public void dump() {
        System.out.println(hand);
    }

}
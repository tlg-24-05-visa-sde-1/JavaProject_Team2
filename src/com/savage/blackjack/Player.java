package com.savage.blackjack;

import java.util.List;
import java.util.Scanner;

public class Player {

    private String name;
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

    public String toString() {
        return "name= " + name + "cards= ";
    }


}
package com.savage.blackjack.client;

import com.savage.blackjack.controller.BlackJackController;

class Main {
    public static void main(String[] args) {
        BlackJackController control = new BlackJackController();
        control.playGame();
    }
}

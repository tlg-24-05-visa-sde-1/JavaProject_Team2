package com.savage.blackjack;

import java.util.HashMap;
import java.util.Map;

class Player {
    private String name;
    private Integer cardScore;
    private Map<String, Integer> myCards = new HashMap();

    public Player(){
    }

    public PlayerResponse responseToDealer(){
        return PlayerResponse.HIT_ME;
    }

    public Map<String, Integer> checkCards(){
        return myCards;
    }

    public boolean hasBlackJack(){
        return false;
    }
}

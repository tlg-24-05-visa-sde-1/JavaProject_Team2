package com.savage.blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class DealerTest {

    private Dealer dealer;

    @Before
    public void setUp(){
        dealer = new Dealer();
    }

    @Test
    public void testDealCards(){
        dealer.addPlayer("Tomiwa");
        dealer.addPlayer("Daiyron");
        dealer.addPlayer("Gabriel");
        dealer.shuffleCards();
        dealer.dealCards();

        Map<Player, Hand> playerHands = dealer.getPlayerHands();
        Hand dealerHand = dealer.getDealerHand();
        assertEquals(2, dealerHand.getCards());



    }
}

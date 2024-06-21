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
    public void testAddPlayer() {
        dealer.addPlayer("Kobe");
        assertEquals(1, dealer.getPlayers().size());
        assertEquals("Kobe", dealer.getPlayers().get(0).getName());
        System.out.println(dealer.getPlayers().size() + " is ready to play.");
    }

    @Test
    public void testDealCards(){
        // players
        dealer.addPlayer("Tomiwa");
        dealer.addPlayer("Daiyron");
        dealer.addPlayer("Gabriel");

        //shuffle cards
        dealer.shuffleCards();
        //Deal cards
        dealer.dealCards();

        // get size of dealer's hand, should be 2
        Hand dealerHand = dealer.getDealerHand();
        assertEquals( 2, dealerHand.getCards().size());
        System.out.println("Dealer hand has: " + dealerHand.getCards().size() + " cards.");

        // get size of each player's hand, should be 2
        Map<Player, Hand> playerHands = dealer.getPlayerHands();
        for (Player player : playerHands.keySet()) {
            Hand hand = playerHands.get(player);
            assertEquals(2, hand.getCards().size());
            System.out.println(player.getName() + "'s hand has: " + hand.getCards().size() + " cards.");
        }
    }

    @Test
    public void testResetHands() {
        dealer.addPlayer("Tomiwa");
        dealer.addPlayer("Daiyron");
        dealer.addPlayer("Gabriel");
        dealer.shuffleCards();
        dealer.dealCards();
        dealer.resetHands();
        assertEquals(0, dealer.getDealerHand().getCards().size());
        assertEquals(0, dealer.getPlayerHands().size());
        assertEquals(52, dealer.getDeck().size());
    }
}

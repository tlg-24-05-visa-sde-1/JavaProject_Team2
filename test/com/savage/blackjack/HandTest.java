package com.savage.blackjack;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HandTest {
    private Hand hand;

    @Before
    public void setUp() {
        hand = new Hand();
    }

    @Test
    public void testHandValue() {
        hand.addCard(Card.ACE_HEARTS);
        hand.addCard(Card.TEN_CLUBS);
        assertEquals(21, hand.handValue());
        System.out.println("The hand value is: " + hand.handValue());


        hand = new Hand();
        hand.addCard(Card.ACE_HEARTS);
        hand.addCard(Card.TEN_CLUBS);
        hand.addCard(Card.FIVE_CLUBS);
        hand.addCard(Card.TEN_CLUBS);
        assertEquals(26, hand.handValue());
        System.out.println("The hand value is: " + hand.handValue());
    }

    @Test
    public void testHandIsBlackJack() {
        hand.addCard(Card.ACE_HEARTS);
        hand.addCard(Card.TEN_CLUBS);
        assertTrue(hand.hasBlackjack());
        
    }

    @Test
    public void testHandIsNotBlackJack() {
        hand.addCard(Card.TEN_HEARTS);
        hand.addCard(Card.SEVEN_CLUBS);
        assertFalse(hand.hasBlackjack());

        hand = new Hand();
        hand.addCard(Card.TEN_HEARTS);
        hand.addCard(Card.SEVEN_CLUBS);
        hand.addCard(Card.KING_HEARTS);
        assertFalse(hand.hasBlackjack());
    }

    @Test
    public void testHandIsBust() {
        hand.addCard(Card.TEN_HEARTS);
        hand.addCard(Card.TEN_CLUBS);
        hand.addCard(Card.EIGHT_CLUBS);
        assertTrue(hand.isBusted());
    }

    @Test
    public void testHandIsNotBust() {
        hand.addCard(Card.TEN_HEARTS);
        hand.addCard(Card.TEN_CLUBS);
        assertFalse(hand.isBusted());
    }
}

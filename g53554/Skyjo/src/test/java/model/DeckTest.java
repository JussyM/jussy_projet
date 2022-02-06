/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jj
 */
public class DeckTest {

    /**
     * Test of getPitched method, of class Deck.
     */
    @org.junit.Test
    public void testGetPitched() {
        System.out.println("getPitched");
        Deck instance = new Deck();
        List<Card> result = instance.getPitched();
        assertEquals(150, result.size());

    }

    /**
     * Test of isEmpty method, of class Deck.
     */
    @org.junit.Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Deck instance = new Deck();
        boolean result = instance.isEmpty();
        assertFalse(result);

    }

    /**
     * Test of hit method, of class Deck.
     */
    @org.junit.Test
    public void testHit() {
        System.out.println("hit");
        Deck instance = new Deck();
        Card expResult = new Card(Value.NEG_2);
        Card result = instance.hit();
        assertEquals(expResult.getValues(), result.getValues());
    }

    /**
     * Test of size method, of class Deck.
     */
    @org.junit.Test
    public void testSize() {
        System.out.println("size");
        Deck instance = new Deck();
        instance.shuffle();
        int expResult = 150;
        int result = instance.size();
        assertEquals(expResult, result);

    }


    /**
     * Test of return12Card method, of class Deck.
     */
    @org.junit.Test
    public void testReturn12Card() {
        System.out.println("return12Card");
        Deck instance = new Deck();
        Card[] result = instance.return12Card();
        assertEquals(12, result.length);
    }

    /**
     * Test of switchTwoCard method, of class Deck.
     */
    @org.junit.Test
    public void testSwitchTwoCard() {
        System.out.println("switchTwoCard");
        Card card_1 = new Card(Value.ACE);
        Card card_2 = new Card(Value.EIGHT);
        card_2.setHide(true);
        Deck instance = new Deck();
        instance.switchTwoCard(card_1, card_2);
        assertTrue(card_1.isHide());
        assertEquals(Value.EIGHT, card_1.getValues());
        assertTrue(card_2.isHide());
        assertEquals(Value.ACE, card_2.getValues());

    }

}

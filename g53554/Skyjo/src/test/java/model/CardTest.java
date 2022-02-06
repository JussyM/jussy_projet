/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static org.junit.Assert.*;

/**
 * @author jj
 */
public class CardTest {
    @org.junit.Test
    public void testGetValues() {
        System.out.println("getValues");
        Card instance = new Card(Value.ACE);
        var result = instance.getValues();
        assertEquals(Value.ACE, result);

    }

    /**
     * Test of isHide method, of class Card.
     */
    @org.junit.Test
    public void testIsHide() {
        System.out.println("isHide");
        Card instance = new Card(Value.ACE);
        boolean result = instance.isHide();
        assertTrue(result);
    }

    /**
     * Test of isHide method, of class Card.
     */
    @org.junit.Test
    public void testIsNotHide() {
        System.out.println("isHide");
        Card instance = new Card(Value.ACE);
        instance.setHide(false);
        boolean result = instance.isHide();
        assertFalse(result);
    }

    /**
     * Test of setCartState method, of class Card.
     */
    @org.junit.Test
    public void testSetCartState() {
        System.out.println("setCartState");
        var values = Value.FIVE;
        Card instance = new Card(Value.ACE);
        instance.setCartState(values, false);
        assertFalse(instance.isHide());
        assertEquals(values, instance.getValues());

    }

}

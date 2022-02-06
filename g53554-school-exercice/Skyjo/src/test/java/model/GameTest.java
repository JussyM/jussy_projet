/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jj
 */
public class GameTest {
    @org.junit.Test
    public void testInitializedGame() {
        System.out.println("initializedGame");
        Game instance = new Game("P1", "P2");
        assertEquals(12, instance.getCurrentPlayer().getHand().size());
        assertEquals(12, instance.getOpponentPlayer().getHand().size());
        assertEquals(1, instance.getDeck().getDiscard().size());
    }


    /**
     * Test of switchPlayer method, of class Game.
     */
    @org.junit.Test
    public void testSwitchPlayer() {
        System.out.println("switchPlayer");
        Game instance = new Game("P1", "P2");
        instance.switchPlayer();
        assertEquals("P2", instance.getCurrentPlayer().getId());
        assertEquals("P1", instance.getOpponentPlayer().getId());
    }

    /**
     * Test of updateGame method, of class Game.
     * updateGame When the discard card is chosen
     */
    @org.junit.Test
    public void testUpdateGame() {
        System.out.println("updateGame When the discard card is chosen");
        boolean[] signals = {true, false, false};
        Game instance = new Game("P1", "P2");
        instance.getOpponentPlayer().addAll(instance.getDeck().return12Card());
        instance.getCurrentPlayer().addAll(instance.getDeck().return12Card());
        instance.getDeck().addToDiscard(instance.getDeck().hit());
        Card cardHit = instance.getDeck().hitFromDiscard();
        var selected = instance.getCurrentPlayer().getCardAt(5);
        instance.getCurrentPlayer().setSelected(selected);
        instance.updateGame(signals, cardHit);
        assertEquals(cardHit.getValues(), instance.getDeck().getFistIn().getValues());
        assertEquals(selected.getValues(), instance.getCurrentPlayer().getCardAt(5).getValues());


    }

    /**
     * Test of updateGame method, of class Game.
     * updateGame_2 test when the pitched card is show and the player decide to keep the card
     */
    @org.junit.Test
    public void testUpdateGame_2() {
        System.out.println("updateGame_2 test when the pitched card is show and the player decide to keep the card ");
        boolean[] signals = {false, true, true};
        Game instance = new Game("P1", "P2");
        instance.getOpponentPlayer().addAll(instance.getDeck().return12Card());
        instance.getCurrentPlayer().addAll(instance.getDeck().return12Card());
        instance.getDeck().addToDiscard(instance.getDeck().hit());
        Card cardHit = instance.getDeck().hit();
        var selected = instance.getCurrentPlayer().getCardAt(5);
        instance.getCurrentPlayer().setSelected(selected);
        instance.updateGame(signals, cardHit);
        assertEquals(cardHit.getValues(), instance.getDeck().getFistIn().getValues());
        assertEquals(selected.getValues(), instance.getCurrentPlayer().getCardAt(5).getValues());


    }

    /**
     * Test of updateGame method, of class Game.
     * updateGame_3 test when the pitched card is show and the player decide to drop de card
     */
    @org.junit.Test
    public void testUpdateGame_3() {
        System.out.println("updateGame_3 test when the pitched card is show and the player decide to drop de card");
        boolean[] signals = {false, true, false};
        Game instance = new Game("P1", "P2");
        instance.getOpponentPlayer().addAll(instance.getDeck().return12Card());
        instance.getCurrentPlayer().addAll(instance.getDeck().return12Card());
        instance.getDeck().addToDiscard(instance.getDeck().hit());
        Card cardHit = instance.getDeck().hit();
        var selected = instance.getCurrentPlayer().getCardAt(5);
        instance.getCurrentPlayer().setSelected(selected);
        instance.updateGame(signals, cardHit);
        assertEquals(cardHit.getValues(), instance.getDeck().getFistIn().getValues());
        assertFalse(selected.isHide());


    }

    /**
     * Test of updateGame method, of class Game.
     */
    @org.junit.Test
    public void testUpdateGame_4() {
        System.out.println("updateGame_4 it will received an exception an illegalStateException");
        boolean[] signals = {true, true, true};
        Game instance = new Game("P1", "P2");
        instance.getOpponentPlayer().addAll(instance.getDeck().return12Card());
        instance.getCurrentPlayer().addAll(instance.getDeck().return12Card());
        instance.getDeck().addToDiscard(instance.getDeck().hit());
        Card cardHit = instance.getDeck().hit();
        var selected = instance.getCurrentPlayer().getCardAt(5);
        instance.getCurrentPlayer().setSelected(selected);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            instance.updateGame(signals, cardHit);

        });


    }

    /**
     * Test of updateGame method, of class Game.
     */
    @org.junit.Test
    public void testUpdateGame_5() {
        System.out.println("updateGame_4 it will received an exception an illegalStateException");
        boolean[] signals = {false, false, false};
        Game instance = new Game("P1", "P2");
        instance.getOpponentPlayer().addAll(instance.getDeck().return12Card());
        instance.getCurrentPlayer().addAll(instance.getDeck().return12Card());
        instance.getDeck().addToDiscard(instance.getDeck().hit());
        Card cardHit = instance.getDeck().hit();
        var selected = instance.getCurrentPlayer().getCardAt(5);
        instance.getCurrentPlayer().setSelected(selected);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            instance.updateGame(signals, cardHit);

        });


    }

    /**
     * Test the game when it's over
     */
    @org.junit.Test
    public void test_When_Game_Over() {
        System.out.println("Test when the game is over");
        var game = new Game("P1", "P2");
        game.getCurrentPlayer().getHand().forEach(x -> x.setHide(false));
        game.getCurrentPlayer().updateScore();
        game.getOpponentPlayer().updateScore();
        assertTrue(game.isOver());
        assertEquals(State.WIN, game.getOpponentPlayer().getState());
        assertEquals(State.FAIL, game.getCurrentPlayer().getState());

    }

    @org.junit.Test
    public void test_reveals_two_card() {
        System.out.println("Test When two card are reveals");
        var game = new Game("P1", "P2");
        game.revealCard();
        int nbReveal = (int) game.getCurrentPlayer().getHand().stream().filter(i -> !i.isHide()).count();
        assertEquals(2, nbReveal);
    }

}

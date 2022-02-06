package BJPackage.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    @Test
    public void testSize() {
        Deck deck = new Deck();
        assertEquals(52, deck.size());
    }

    @Test
    public void testAfterShuffle() {
        Deck deck = new Deck();
        deck.shuffle();
        assertEquals(52, deck.size());

    }

}
package BJPackage.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void giveCard() {
        Game g = new Game();
        g.giveCard();
        g.shuffleDeckCard();
        var playerNbCard = g.getPlayer().getHand().size();
        var bankNbCard = g.getBank().getHand().size();
        assertEquals(2, playerNbCard);
        assertEquals(1, bankNbCard);

    }
}
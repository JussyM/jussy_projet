package BJPackage.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void calculScore() {
        Game g = new Game();
        g.shuffleDeckCard();
        g.giveBankCard();
        g.giveBankCard();
        g.getBank().calculScore();
        var expResult= g.getBank().getHand().stream().mapToInt(x->x.getValue().getValue()).sum();
        assertEquals(expResult,g.getBank().getScore());
    }
}
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

    @Test
    public void testWhenPlayerWin() {
        Game game = new Game();
        var cardUno = new Card(Color.DIAMOND, Value.EIGHT);
        var cardDos = new Card(Color.DIAMOND, Value.JACK);
        var cardTrois = new Card(Color.DIAMOND, Value.ACE);
        game.getPlayer().addCart(cardUno);
        game.getPlayer().addCart(cardDos);
        game.getBank().addCart(cardTrois);
        game.calculateScore();
        game.finalScoreAndSetState();
        assertEquals(State.WIN, game.getPlayer().getState());
    }

    @Test
    public void testWhenPlayerFail() {
        Game game = new Game();
        var cardUno = new Card(Color.DIAMOND, Value.EIGHT);
        var cardDos = new Card(Color.DIAMOND, Value.JACK);
        var cardTrois = new Card(Color.DIAMOND, Value.ACE);
        game.getBank().addCart(cardUno);
        game.getBank().addCart(cardDos);
        game.getBank().addCart(cardTrois);
        game.calculateScore();
        game.finalScoreAndSetState();
        assertEquals(State.WIN, game.getBank().getState());

    }

    @Test
    public void testWhenBankAndPlayerAreEqual() {

    }


}
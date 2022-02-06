package model;

import designPattern.Observable;

/**
 * The type Facade.
 */
public abstract class Facade extends Observable {
    /**
     * Gets deck.
     *
     * @return the deck
     */
    public abstract Deck getDeck();

    /**
     * Gets current player.
     *
     * @return the current player
     */
    public abstract Player getCurrentPlayer();

    /**
     * Gets opponent player.
     *
     * @return the opponent player
     */
    public abstract Player getOpponentPlayer();

    /**
     * Switch player.
     */
    public abstract void switchPlayer();

    /**
     * Update game.
     *
     * @param signals the signals
     * @param cardHit the card hit
     */
    public abstract void updateGame(boolean[] signals, Card cardHit);

    /**
     * Update score.
     */
    public abstract void updateScore();

    /**
     * Hit card.
     *
     * @return the card
     */
    public abstract Card hit();

    /**
     * Gets peek.
     *
     * @return the peek
     */
    public abstract Card getPeek();

    /**
     * Decide who start.
     */
    public abstract void decideWhoStart();

    /**
     * Reveal card.
     */
    public abstract void revealCard();

    /**
     * Is over boolean.
     *
     * @return the boolean
     */
    public abstract boolean isOver();

    /**
     * Gets winner.
     *
     * @return the winner
     */
    public abstract Player getWinner();

    public abstract  void updateDiscardOnly();
}

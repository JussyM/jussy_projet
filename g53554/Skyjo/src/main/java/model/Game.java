package model;

/**
 * The type Game.
 */
public class Game extends Facade {
    private final Deck deck;
    private Player currentPlayer;
    private Player opponentPlayer;

    /**
     * Instantiates a new Game.
     *
     * @param idP1 the id of Player 1
     * @param idP2 the id of player 2
     */
    public Game(String idP1, String idP2) {
        deck = new Deck();
        currentPlayer = new Player(idP1);
        opponentPlayer = new Player(idP2);
        initializedGame();
    }

    /**
     * Initialized game.
     */
    private void initializedGame() {
        deck.shuffle();
        opponentPlayer.addAll(deck.return12Card());
        currentPlayer.addAll(deck.return12Card());
        deck.addToDiscard(deck.hit());

    }

    /**
     * Gets deck.
     *
     * @return the deck
     */
    @Override
    public Deck getDeck() {
        return deck;
    }

    /**
     * Gets current player.
     *
     * @return the current player
     */
    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Gets opponent player.
     *
     * @return the opponent player
     */
    @Override
    public Player getOpponentPlayer() {
        return opponentPlayer;
    }


    /**
     * Switch player.
     */
    @Override
    public void switchPlayer() {
        var player = currentPlayer;
        currentPlayer = opponentPlayer;
        opponentPlayer = player;
        notifyObservers(this);
    }

    /**
     * it switch the two card values and add the hit value to the discards
     *
     * @param card_hit      cart element
     * @param card_selected cart element
     */
    private void switchAndReplaceCards(Card card_hit, Card card_selected) {
        card_selected.setHide(false);
        card_hit.setHide(false);
        this.deck.switchTwoCard(card_hit, card_selected);
        this.deck.addToDiscard(card_hit);
    }

    /**
     * drop a card and show set the player card selected to true
     *
     * @param card_hit      cart element card hit
     * @param card_selected cart seelcted
     */
    private void dropAndShow(Card card_hit, Card card_selected) {
        card_hit.setHide(false);
        this.deck.addToDiscard(card_hit);
        this.deck.removeCardFromPitched(card_hit);
        card_selected.setHide(false);
    }

    /**
     * Update game. according to the signals boolean received
     * if it's [true,false,false] means the player decided to
     * discard so the discard rule will be apply else if the
     * signals is [false,true,true] means the player decide
     * to pitched a card and keep so the accurate rules
     * will also be apply and finally if the signals is
     * [false,true,false] means the player pitched a card
     * but decide to drop it so the rules for that will
     * also be apply
     *
     * @param signals the signals
     * @param cardHit the card hit
     */
    @Override
    public void updateGame(boolean[] signals, Card cardHit) {
        if (!allAreTrue(signals) && !allAreFalse(signals)) {
            if (signals[0]) {
                switchAndReplaceCards(cardHit, currentPlayer.getSelected());
            } else if (signals[1]) {
                if (signals[2]) {
                    switchAndReplaceCards(cardHit, currentPlayer.getSelected());
                } else {
                    dropAndShow(cardHit, currentPlayer.getSelected());
                }
            }
            notifyObservers(this);
        } else {
            throw new IllegalStateException("GAME CAN NOT BE UPDATE");
        }


    }

    private void addToPitched() {
        System.out.println("je suis dans le piteched");
        var discard = deck.popFromDiscard();
        deck.addToPitched(discard);
        deck.shuffle();
    }

    /**
     * Update score of the current player
     */
    @Override
    public void updateScore() {
        currentPlayer.updateScore();
    }

    /**
     * Is over boolean. return true if the game is over means if so a player win
     *
     * @return the boolean
     */
    @Override
    public boolean isOver() {
        if (currentPlayer.allCardReveal() || opponentPlayer.allCardReveal()) {

            if (currentPlayer.getScore() < opponentPlayer.getScore()) {
                currentPlayer.setState(State.WIN);
                opponentPlayer.setState(State.FAIL);
                return true;
            } else
                opponentPlayer.setState(State.WIN);
            currentPlayer.setState(State.FAIL);
            return opponentPlayer.getScore() < currentPlayer.getScore();
        }
        return false;
    }

    @Override
    public Player getWinner() {
        return currentPlayer.getState() == State.WIN ? currentPlayer : opponentPlayer;
    }

    @Override
    public void updateDiscardOnly() {
        addToPitched();
        notifyObservers(this);
    }

    /**
     * Hit card.
     *
     * @return the card
     */
    @Override
    public Card hit() {
        return deck.hit();
    }

    /**
     * Sets hide current player.
     *
     * @param indexCard the index card
     */
    private void setHideCurrentPlayer(int indexCard) {
        currentPlayer.getCardAt(indexCard).setHide(false);
    }

    /**
     * Sets hide opponent player.
     *
     * @param indexCard the index card
     */
    private void setHideOpponentPlayer(int indexCard) {
        opponentPlayer.getCardAt(indexCard).setHide(false);
    }

    /**
     * Update two player score.
     */
    private void updateTwoPlayerScore() {
        currentPlayer.updateScore();
        opponentPlayer.updateScore();
    }

    /**
     * Gets peek.
     *
     * @return the peek
     */
    @Override
    public Card getPeek() {
        return deck.getFistIn();
    }

    /**
     * Decide who start.
     */
    @Override
    public void decideWhoStart() {
        if (opponentPlayer.getScore() < currentPlayer.getScore()) {
            switchPlayer();
        }
    }

    /**
     * reveal two card card for each player
     */
    @Override
    public void revealCard() {
        int random_1 = randomValues();
        int random_2 = randomValues();
        setHideCurrentPlayer(random_1);
        setHideOpponentPlayer(random_2);
        random_1 = randomValues();
        random_2 = randomValues();
        setHideCurrentPlayer(random_1);
        setHideOpponentPlayer(random_2);
        updateTwoPlayerScore();
        decideWhoStart();
        notifyObservers(this);
    }

    /**
     * return a valid random value
     *
     * @return int random
     */
    private int randomValues() {
        int random = (int) (Math.random() * (11));
        while (notValid(random)) {
            random = (int) (Math.random() * (11));
        }
        return random;
    }

    /**
     * return true if the value given as argument is not valid
     *
     * @param value argument
     * @return boolean
     */
    private boolean notValid(int value) {
        return value < 0 || value > 12;
    }

    /**
     * return true if the array of boolean are true
     *
     * @param signals array of boolean
     * @return boolean
     */
    private boolean allAreTrue(boolean[] signals) {
        int compteur = 0;
        for (boolean signal : signals) {
            if (signal) {
                compteur++;
            }
        }
        return compteur == signals.length;
    }

    /**
     * return true if the array of boolean are false
     *
     * @param signals array of boolean
     * @return boolean
     */
    private boolean allAreFalse(boolean[] signals) {
        int compteur = 0;
        for (int i = 0; i < signals.length; i++) {
            if (!signals[i]) {
                compteur++;
            }
        }
        return compteur == signals.length;
    }


}
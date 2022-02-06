package BJPackage.Model;

public class Game {
    private final Deck deck;
    private final Player player;
    private final Bank bank;

    /**
     * getter for deck
     *
     * @return deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * getter for player
     *
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Constructor for game
     */
    public Game() {
        deck = new Deck();
        player = new Player();
        bank = new Bank();

    }

    /**
     * getter for bank
     *
     * @return bank
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * shuffle the card of the deck
     */
    public void shuffleDeckCard() {
        deck.shuffle();
    }


    /**
     * give a mise to the player
     */
    public void miseBank() {
        if (player.getMise() <= 500) {
            getBank().insertMise(player.getMise() / 2);
        } else {
            getBank().insertMise(player.getMise() * 2);
        }

    }

    /**
     * calculate the gain of the winner
     *
     * @return gain
     */
    public int calculDeGain() {
        Player instance;
        if (getPlayer().getState() == State.WIN) {
            instance = getPlayer();
            instance.insertMise(bank.getMise() + instance.getMise());
        } else {
            instance = getBank();
            instance.insertMise(player.getMise() + instance.getMise());
        }
        return instance.getMise();
    }

    /**
     * apply an action according to the answer of the player
     *
     * @param answer given by the player
     */
    public void decision(char answer) {
        switch (answer) {
            case 'p' -> {
                insertCardPlayer(deck.hit());
                calculateScore();
            }
            case 's' -> calculateScore();
        }
    }

    /**
     * return an arrays of the player score
     *
     * @return array of Integer
     */
    public int[] playersScore() {
        return new int[]{player.playerScore(), bank.getScore()};
    }

    /**
     * Calculate the score and of the players and update the state of each players
     */
    private void calculateScore() {
        player.calculScore();
        bank.calculScore();
        updateScoreAndState();
    }

    /**
     * give card to each player
     */
    private void addCardPlayers() {
        giveCardPlayer();
        giveBankCard();

    }

    /**
     * call addCardPlayers()
     */
    public void giveCard() {
        addCardPlayers();
    }

    /**
     * return the winner of the game
     *
     * @return boolean
     */
    public boolean win() {
        return player.getState() == State.WIN || bank.getState() == State.WIN;

    }

    /**
     * update the state of the player
     */
    private void updateScoreAndState() {
        if (player.getScore() >= 21) {
            player.setState(State.FAIL);
            bank.setState(State.WIN);
        }
    }

    /**
     * return a card given by the deck
     */
    public Card askCard() {
        return getDeck().hit();


    }

    /**
     * insert a card tho the players
     *
     * @param card
     */
    public void insertCardPlayer(Card card) {
        getPlayer().addCart(card);
        getDeck().remove(card);
    }

    /**
     * give card to player at the beginning
     */
    public void giveCardPlayer() {
        var instance = deck.hit();
        var i = 0;
        while (i <= 1) {
            player.addCart(instance);
            deck.remove(instance);
            instance = deck.hit();
            i++;
        }


    }

    /**
     * give the appropriate card to the bank
     */
    public void giveBankCard() {
        var instance = deck.hit();
        bank.addCart(instance);
        deck.remove(instance);
    }
}

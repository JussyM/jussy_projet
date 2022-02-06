package BJPackage.Model;

public class Game implements Facade{
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
        return new Bank(bank);
    }

    /**
     * shuffle the card of the deck
     */
    @Override
    public void shuffleDeckCard() {
        deck.shuffle();
    }


    /**
     * give a mise to the player
     */
    @Override
    public void bankBet() {
        if (player.getMise() <= Bank.BANK_BET) {
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
    @Override
    public int gainCalculation() {
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
    @Override
    public void decision(char answer) {
        switch (answer) {
            case 'p' -> {
                insertCardPlayer(deck.hit());
                calculateScore();
            }
            case 's' -> {
                bank.pic(deck);
                calculateScore();
                finalScoreAndSetState();
            }
        }
    }

    /**
     * return an arrays of the player score
     *
     * @return array of Integer
     */
    @Override
    public int[] playersScore() {
        return new int[]{player.playerScore(), bank.getScore()};
    }

    /**
     * Calculate the score and of the players and update the state of each players
     */
    @Override
    public void calculateScore() {
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
     * Calculate the final score and decide who win or who fail
     */
    public void finalScoreAndSetState() {
        if (player.beat(bank)) {
            player.setState(State.WIN);
            bank.setState(State.FAIL);
        } else {
            bank.setState(State.WIN);
            player.setState(State.FAIL);
        }
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
        if (player.isOutOfBound()) {
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
    private void insertCardPlayer(Card card) {
        getPlayer().addCart(card);
    }


    /**
     * give card to player at the beginning
     */
    public void giveCardPlayer() {
        player.addCart(deck.hit());


    }

    /**
     * give the appropriate card to the bank
     */
    public void giveBankCard() {
        var instance = deck.hit();
        bank.addCart(instance);
    }

    public int getMise() {
        return bank.getMise();
    }

    public void insertBet(int bet) {
        getPlayer().insertMise(bet);

    }
}

package BJPackage.Model;

public interface Facade {
    /**
     * @return
     */
    int[] playersScore();

    /**
     *
     */
    void calculateScore();

    /**
     *
     */
    void giveCard();

    /**
     * @return
     */
    boolean win();

    /**
     * @return
     */
    Card askCard();

    /**
     *
     */
    void giveCardPlayer();

    /**
     * @param bet
     */
    void insertBet(int bet);

    /**
     * @param answer
     */
    void decision(char answer);

    /**
     * @return
     */
    int gainCalculation();

    /**
     *
     */
    void bankBet();

    /**
     *
     */
    void shuffleDeckCard();

    /**
     * @return
     */
    int getMise();
}

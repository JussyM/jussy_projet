package BJPackage.View;

import BJPackage.Model.Card;
import BJPackage.Model.Facade;
import BJPackage.Model.Game;

import java.util.List;

public interface ViewInterface {
    /**
     * return the input request of the player
     *
     * @return char which represent the player answer
     */
    char askInfo();

    /**
     * return the card if the player ask a card
     *
     * @param game the instance game
     * @return card of the player
     */
    Card playerCard(Game game);

    /**
     * displays the card of the players (player,bank)
     *
     * @param game the game instance
     */
    void displayCard(Game game);

    /**
     * print out the message given as argument
     *
     * @param message string type represent the message
     */
    void printMsg(String message);

    /**
     * return the bet given by the player into an int type
     *
     * @return int type that represent the amount bet by the player
     */
    int askBet();

    /**
     * print a message to the winner of the game
     *
     * @param game instance of the game
     */
    void printWinner(Game game);

    /**
     * print the amount of bet the winner got
     *
     * @param bet
     */
    void printWinnerBet(int bet);

    /**
     * display the game name which is blackJack
     */
    void gameName();

    /**
     * print the score of the players (bank and main player)
     *
     * @param scores array of the player score
     */
    void printScore(int[] scores);

}

package g53554.humbug.model;

import g53554.humbug.designPattern.Obervable;

/**
 * Game interface where all the game methode will be implement
 *
 * @author jj
 */
public abstract class Model extends Obervable {

    /**
     * Return the board of the game also call getter of the board
     *
     * @return board
     */
   public abstract Board getBoard();

    /**
     * return the arrays of animal also call getter of animals
     *
     * @return animal[]
     */
   public abstract Animal[] getAnimals();

    /**
     * Start the game in the level as argument
     *
     * @param level of the game
     */
   public abstract void startLevel(int level);

    /**
     * Apply a move for an animal according to the direction
     *
     * @param position given by the player
     * @param direction where the animal is moving to also given by the player
     */
     public abstract void move(Position position, Direction direction);

    /**
     * getter of level status
     *
     * @return levelStatus of the game
     */
   public abstract LevelStatus getLevelStatus();

    /**
     * getter for the current level
     *
     * @return level value
     */
   public abstract int getCurrentLevel();

    /**
     * return the remaining moves of the games also a getter
     *
     * @return remainingMoves
     */
     public abstract int getRemainingMoves();

    /**
     * return true if the player win the level
     *
     * @return boolean true/false
     */
   public abstract boolean hasWon();
}

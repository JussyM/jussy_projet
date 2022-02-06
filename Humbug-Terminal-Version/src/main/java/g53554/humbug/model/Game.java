package g53554.humbug.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Game class that start the game and apply the moves and the changes
 *
 * @author 53554
 */
public class Game extends Model {

    private Board board;

    private Animal[] animals;
    private int remainingMove, currentLevel;

    /**
     * return the board of the game
     *
     * @return board of the game attribut
     */
    @Override
    public Board getBoard() {

        return this.board;
    }

    /**
     * return the getAnimals of the games
     *
     * @return getAnimals arrays of the getAnimals
     */
    @Override
    public Animal[] getAnimals() {
        Animal[] animalStillActive = animalStillOnBoard(List.of(animals));
        if (animalStillActive.length != 0) {
            this.animals = animalStillOnBoard(List.of(animals));
        }

        return this.animals;
    }

    /**
     * Start the game according to the level
     *
     * @param nlevel the level number
     */
    @Override
    public void startLevel(int nlevel) {
        var level = Level.getLevel(nlevel);
        remainingMove = level.getnMoves();
        board = level.getBoard();
        animals = level.getAnimals();
        currentLevel = nlevel;
    }

    /**
     * Remove the animal of which the isOnStar field is true cause they ain't on
     * board anymore
     *
     * @param animals List of all the getAnimals of the game
     * @return new Arrays of getAnimals
     */
    private Animal[] animalStillOnBoard(List<Animal> animals) {
        List<Animal> listNoNull = animals.stream().filter(x -> !x.isOnStar())
                .collect(Collectors.toList());
        return listNoNull.toArray(Animal[]::new);
    }

    /**
     * Move the animal from one position to another according to the direction
     * and according to each animal specificity
     *
     * @param position of the getAnimals
     * @param direction of where the getAnimals is going
     */
    @Override
    public void move(Position position, Direction direction) {
        if (position == null || direction == null) {
            throw new IllegalArgumentException("Position ou direction null");
        }
        if (getLevelStatus() == LevelStatus.FAIL
                || getLevelStatus() == LevelStatus.NOT_STARTED) {
            throw new IllegalStateException("Jeu pas en cours");
        }
        var index = 0;
        var move = false;
        while (index < getAnimals().length && !move) {
            if (position.equals(getAnimals()[index].getPositionOnBoard())) {

                var movePos = getAnimals()[index].move(board,
                        direction, getAnimals());
                if (movePos == null) {
                    throw new NullPointerException("L'animal est sortie "
                            + "du plateau");
                }
                if (!movePos.equals(position)) {
                    remainingMove--;
                }

                if (getLevelStatus() == LevelStatus.FAIL) {
                    throw new IllegalStateException("Déplacement épuisé");
                }

                move = true;
            }
            index++;
        }
        notifyObservers(this);

    }

    /**
     * return true or false if all the animal isOnStar field turn to true
     *
     * @return true/false
     */
    private boolean levelIsOver() {
        var i = 0;
        while (i < getAnimals().length && getAnimals()[i].isOnStar()) {
            i++;
        }
        return getAnimals().length == i;
    }

    /**
     * return the level status of the game according to it state
     *
     * @return levelStatus(enum)
     */
    @Override
    public LevelStatus getLevelStatus() {
        return updateLevelStatus();
    }

    /**
     * Update the level status of the game and return the correct status
     *
     * @return levelStatus
     */
    private LevelStatus updateLevelStatus() {
        if (!levelIsOver() && getRemainingMoves() == 0) {
            return LevelStatus.FAIL;
        }
        if (!levelIsOver()) {
            return LevelStatus.IN_PROGRESS;
        }
        if (getRemainingMoves() == 0 && levelIsOver()) {
            return LevelStatus.WIN;
        }

        return LevelStatus.NOT_STARTED;
    }

    /**
     * return the remaining move of the game getter for remainingMove
     *
     * @return int remainingMove attribut
     */
    @Override
    public int getRemainingMoves() {

        return remainingMove;
    }

    /**
     * getter for currentLevel of the game
     *
     * @return currentLevel attribut
     */
    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * return true if getLevelStatus equal to win
     *
     * @return boolean true/false
     */
    @Override
    public boolean hasWon() {
        return getLevelStatus() == LevelStatus.WIN;
    }

}

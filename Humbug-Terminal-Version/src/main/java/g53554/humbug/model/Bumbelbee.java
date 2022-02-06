package g53554.humbug.model;

/**
 * Bumbelbee class Bumbelbee is a an animals who can move from two square
 *
 * @author jj
 */
public class Bumbelbee extends Animal {

    /**
     * Simple constructor of bumblebee
     *
     * @param positionOnBoard bumblebee position on the board
     */
    public Bumbelbee(Position positionOnBoard) {
        super(positionOnBoard);

    }

    /**
     * Default bumbelbee constructor to initialized Bumbelbee animal
     */
    public Bumbelbee() {
        super();
    }

    /**
     * Apply the move of the bumblebee who fly above two square and drop on the
     * third square if free on the fourth if not or return null if the position
     * is out of the board
     *
     * @param board of the game
     * @param direction of the animal
     * @param animals arrays that contain all the animal of the game
     * @return next Position or null
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        var nextPosition = bumbelbeeNextPosition(board, direction, animals);

        return applyMove(board, nextPosition, animals);
    }

    /**
     * Return the next Position of bumbelbee 
     * @param board of the game 
     * @param direction of where the animals is going
     * @param animals arrays of the all the animal of the board 
     * @return bumbelbee nextPosition 
     */
    private Position bumbelbeeNextPosition(Board board,
            Direction direction, Animal... animals) {
        var instance = moveAnimalVolant(0, direction);
        return canJump(instance, board, direction, animals);
    }

}

package g53554.humbug.model;

/**
 * This class represent the snail that move on the board and move only once
 * according to direction given an really move if the new position he is moving
 * to is free
 *
 * @author jj
 */
public class Snail extends Animal {

    /**
     * Snail simple constructor
     *
     * @param positionOnBoard
     */
    public Snail(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Default constructor of snail
     */
    public Snail() {
        super();
    }

    /**
     * this method apply the move according to snail capacity return a new
     * postion if he can move return a null if he falls out and also return his
     * old position if an animal is on his new position
     *
     * @param board of the game
     * @param direction of the animal
     * @param animals arrays of animals
     * @return new position or null
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        var nextPosition = snailNextPosition(board, direction, animals);
        return applyMove(board, nextPosition, animals);
    }

    /**
     * return the next position of the snail 
     * @param board of the game
     * @param direction where the snail is moving to
     * @param animals arrays that contain all the animals of the game
     * @return snail next position 
     */

    private Position snailNextPosition(Board board, Direction direction,
            Animal... animals) {
        var instance = super.getPositionOnBoard().next(direction);
        if (isInside(board, instance)) {
            var hasWall = hasWall(instance, direction, board);
            if (hasWall == 1 || hasWall == 2 || !isFree(instance, animals)) {
                return super.getPositionOnBoard();
            }
            return instance;
        }
        return null;
    }
}

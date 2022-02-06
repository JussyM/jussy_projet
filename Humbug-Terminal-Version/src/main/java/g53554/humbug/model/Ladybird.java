package g53554.humbug.model;

/**
 * The ladybird class represent the ladybird in the game
 *
 * @author jj
 *
 */
public class Ladybird extends Animal {

    /**
     * LadyBird Constructor
     *
     * @param positionOnBoard position of the ladayBird
     */
    public Ladybird(Position positionOnBoard) {
        super(positionOnBoard);

    }

    /**
     * Default constructor of ladybird
     */
    public Ladybird() {
        super();
    }

    /**
     * return a new postion of the LadyBird according to the direction if a
     * animal can stop him if any animal can't stop him the method return null
     *
     * @param board of the game
     * @param direction of the animal
     * @param animals arrays of animals
     * @return new position or null
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        var nextPosition = ladybirdNextPosition(board, direction, animals);
        return applyMove(board, nextPosition, animals);
    }

    /**
     * return the next position of the lady bird
     *
     * @param board of the game
     * @param direction where the animal is going to
     * @param animals arrays that contain all the animal of the game
     * @return next Position of ladybird
     */
    private Position ladybirdNextPosition(Board board,
            Direction direction, Animal... animals) {
        Position finalMove;
        var instance = super.getPositionOnBoard().next(direction);
        if (nextSquareNull(board, instance, direction)) {
            return null;
        }
        if (ladybirdOneSquareMove(board, direction, animals) != null) {
            finalMove = ladybirdOneSquareMove(board, direction, animals);
        } else {
            finalMove = ladybirdTwoSquareMove(board, direction, animals);
        }
        return finalMove;

    }

    /**
     * return the nextPosition of ladyBird ifone jump is possible
     *
     * @param board of the game
     * @param direction where the animal is going
     *
     * @return next Position or null
     */
    private Position ladybirdOneSquareMove(Board board, Direction direction,
            Animal... animals) {
        var instance = super.getPositionOnBoard().next(direction);
        var hasWall = hasWall(instance, direction, board);
        var hasWallMove = hasWallButMove(instance, direction, board);
        if (hasWall == 1 || hasWall == 2) {
            return super.getPositionOnBoard();
        }
        if (hasWallMove == 1) {
            return instance;
        }
        if (!isFree(instance, animals)) {
            return super.getPositionOnBoard();
        }
        return null;
    }

    /**
     * verify if the next square of the board is out of the board
     *
     * @param board of the game
     * @param instance next square of the game
     * @param direction where the ladybird is moving to
     * @return true/false
     */

    private boolean nextSquareNull(Board board, Position instance,
            Direction direction) {
        return !board.isInside(instance)
                && board.isInside(instance.next(direction));
    }

    /**
     * return the double next Position of ladyBird if two jump is possible
     *
     * @param board of the game
     * @param direction where the animal is going
     *
     * @return next Position or null
     */
    private Position ladybirdTwoSquareMove(Board board, Direction direction,
            Animal... animals) {
        var instance = super.getPositionOnBoard().next(direction).next(direction);
        var hasWallMove = hasWallButMove(instance, direction, board);
        Position finalMove = null;
        if (isInside(board, instance)) {
            if (isFree(instance, animals)) {
                finalMove = instance;
            } else {
                finalMove = super.getPositionOnBoard().next(direction);
            }
            if (hasWallMove == 1) {
                finalMove = instance;
            }
            if (hasWallMove == 2) {
                finalMove = super.getPositionOnBoard().next(direction);
            }

        }
        return finalMove;
    }

}

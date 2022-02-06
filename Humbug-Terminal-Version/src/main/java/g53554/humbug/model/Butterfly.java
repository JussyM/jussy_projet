package g53554.humbug.model;

/**
 * Butterfly is an animal who can move from three square on the board
 *
 * @author jj
 */
public class Butterfly extends Animal {

    /**
     * Butterfly constructor
     *
     * @param positionOnBoard is the butterfly position on the board
     */
    public Butterfly(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Butterfly default constructor for initialization
     */
    public Butterfly() {
        super();
    }

    /**
     * Apply the move for the butterfly
     *
     * @param board of the game
     * @param direction of the butterfly
     * @param animals arrays that contain all the animals of the game
     * @return next Position
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        var nextPosition = butterflyNextPosition(board, direction, animals);
        return applyMove(board, nextPosition, animals);
    }

    /**
     *
     * @param board
     * @param direction
     * @param animals
     * @return
     */
    private Position butterflyNextPosition(Board board,
            Direction direction, Animal... animals) {
        var instance = super.getPositionOnBoard()
                .next(direction).next(direction).next(direction);
        return canJump(instance, board, direction, animals);
    }

}

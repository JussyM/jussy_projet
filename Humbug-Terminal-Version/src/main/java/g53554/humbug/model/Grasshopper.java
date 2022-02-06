package g53554.humbug.model;

/**
 * GrassHopper class Grasshopper an animal that can move from two square also
 *
 * @author jj
 */
public class Grasshopper extends Animal {

    /**
     * GrassHopper Constructor
     *
     * @param positionOnBoard of the animal on the board
     */
    public Grasshopper(Position positionOnBoard) {
        super(positionOnBoard);

    }

    /**
     * Default constructor of grasshopper
     */
    public Grasshopper() {
        super();
    }

    /**
     * return a new postion of the grassHopper according to the direction if a
     * animal can stop him if any animal can't stop him the method return null
     *
     * @param board of the game
     * @param direction of the animal
     * @param animals arrays of animals
     * @return new position or null
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        var nextPosition = GrassHopperNextPosition(board, direction, animals);
        return applyMove(board, nextPosition, animals);
    }

    /**
     *
     * @param board
     * @param direction
     * @param animals
     * @return
     */

    private Position GrassHopperNextPosition(Board board,
            Direction direction, Animal... animals) {
        var instance = super.getPositionOnBoard().next(direction);
        return canJump(instance, board, direction, animals);
    }
}

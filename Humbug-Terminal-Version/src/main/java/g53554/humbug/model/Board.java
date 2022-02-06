package g53554.humbug.model;

import static g53554.humbug.model.SquareType.GRASS;

/**
 * The board contains squares that may have animal or not It represented by an
 * arrays of two dimensions
 *
 * @author jj
 */
public class Board {

    private Square[][] squares;

    /**
     * default constructor to initialized the board
     */
    public Board() {
    }

    /**
     * Board constructor with argument
     *
     * @param squares represent each square of the board
     */
    public Board(Square[][] squares) {
        this.squares = squares;
    }

    /**
     * Set the square from star to grass according to the position given as an
     * argument
     *
     * @param position that will be set to grass
     */
    public void setOnGrass(Position position) {
        this.squares[position.getRow()][position.getColumn()].setType(GRASS);
    }

    /**
     * return a boolean true if the squareType is a star but false if not throw
     * some exception if the square is null
     *
     * @param position if the position is inside the board
     * @return boolean true or false
     */
    public boolean isInside(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("La postion est null  On ne peut"
                    + " pas savoir si le squareType est une Star ou pas");
        }
        if (position.getRow() < 0 || position.getRow() >= squares.length) {
            return false;

        }
        if (position.getColumn() < 0
                || position.getColumn() >= squares[position.getRow()].length) {
            return false;

        }
        if (squares[position.getRow()][position.getColumn()] == null) {
            return false;
        }
        return squares[position.getRow()][position.getColumn()] != null;

    }

    /**
     * Getter for Squares
     *
     * @return squares of the board
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     * return the squareType at the position given as args throw some exception
     * if the square is null
     *
     * @param position position that need verification
     * @return SquareType
     */
    public SquareType getSquareType(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("La position est null donc on ne"
                    + " peut pas préciser le SquareType");
        }
        return squares[position.getRow()][position.getColumn()].getType();
    }

    /**
     * return the number of row on the board
     *
     * @return nbRow of the board
     */
    public int getNbRow() {
        return squares.length;

    }

    /**
     * return the number of column on the board
     *
     * @return nbColumn of the board
     */
    public int getNbColumn() {
        return squares[0].length;

    }
}

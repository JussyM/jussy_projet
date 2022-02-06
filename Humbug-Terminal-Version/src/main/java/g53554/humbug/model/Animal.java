package g53554.humbug.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * these are the animal that will be on the board an animal know where he is on
 * the board but do not know were is the star
 *
 * @author 53554
 */
@JsonTypeInfo(use = Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
    @Type(value = Bumbelbee.class),
    @Type(value = Grasshopper.class),
    @Type(value = Ladybird.class),
    @Type(value = Snail.class),
    @Type(value = Spider.class),
    @Type(value = Butterfly.class),
    @Type(value = Beetle.class)})
public abstract class Animal {

    private Position positionOnBoard;
    private boolean onStar;

    /**
     * Simple constructor of Animal
     *
     * @param positionOnBoard is the position of the animals on the board
     */
    public Animal(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
        this.onStar = false;
    }

    /**
     * default constructor to initialized the animals
     */
    public Animal() {
    }

    /**
     * Getter for Position
     *
     * @return positionOnBoard position of the animal on the board
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * getter for onStar
     *
     * @return onStar boolean of animal that verify if he's out or not
     */
    public boolean isOnStar() {
        return onStar;
    }

    /**
     * Setter for onStar
     *
     * @param onStar boolean that change the attribute
     */
    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }

    /**
     * Setter for Position on board
     *
     * @param positionOnBoard is the position of the animals on the board
     */
    public void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * This method will help the animal to move on the board this method return
     * the new position of the animal if he move but if he is block the will
     * return his old position but if he move and fall out of the board the
     * position will return null
     *
     * @param board of the game
     * @param direction of the animals
     * @param animals arrays of the animals of the game
     * @return new position
     */
    public abstract Position move(Board board,
            Direction direction, Animal... animals);

    /**
     * return a boolean true if an animal is on the next square is on the board
     * and false if not
     *
     * @param position is the nextPosition of the animal
     * @param animals arrays of animals
     * @return found boolean true if it's free and false if not
     */
    protected boolean isFree(Position position, Animal... animals) {
        int i = 0;
        var found = true;
        while (i < animals.length && found) {
            found = !animals[i].isOn(position);

            i++;

        }
        return found;
    }

    protected Position moveAnimalVolant(int jump, Direction direction) {
        var position = getPositionOnBoard();
        for (int i = 0; i < jump; i++) {
            position = position.next(direction);
        }
        return position;
    }

    /**
     * return true if the position given as argument equal to the animal
     * position
     *
     * @param position that need to be test
     * @return true or false
     */
    protected boolean isOn(Position position) {
        return getPositionOnBoard().equals(position);
    }

    /**
     * verify if the position is inside the board
     *
     * @param board of the game
     * @param position of the animal
     * @return true if is inside and false if not
     */
    protected boolean isInside(Board board, Position position) {
        return board.isInside(position);
    }

    /**
     * verify if the position board is inside and free
     *
     * @param board of the game
     * @param animalNextPosition next Position of the animal
     * @param animals arrays of all the animals
     * @return true / false
     */
    private boolean insideAndFreeGrass(Board board,
            Position animalNextPosition,
            Animal... animals) {
        return isInside(board, animalNextPosition)
                && board.getSquareType(animalNextPosition) == SquareType.GRASS
                && isFree(animalNextPosition, animals);

    }

    /**
     * verify if the position board is inside and star
     *
     * @param board of the game
     * @param position next Position of the animal
     * @return true / false
     */
    private boolean insideAndStar(Board board, Position position) {
        return isInside(board, position)
                && board.getSquareType(position) == SquareType.STAR;

    }

    /**
     * set animal state if it drop on Star square
     *
     * @param position next Position of the animal
     * @param board of the game
     */
    private void setAnimalState(Position position, Board board) {
        this.setOnStar(true);
        this.setPositionOnBoard(position);
        board.setOnGrass(position);
    }

    /**
     * verify if the square has wall according to the right and the opposite
     * direction 1==> if their's a wall on the position on board 2==> if the
     * position given as argument has an opposite wall according to the
     * direction
     *
     * @param position next Position of the board
     * @param direction of animal
     * @param board of the game
     * @return a number (int)
     */
    protected int hasWall(Position position, Direction direction,
            Board board) {
        if (board.isInside(position) && board.getSquares()[positionOnBoard.
                getRow()][positionOnBoard.getColumn()].hasWall(direction)) {
            return 1;
        }
        if (board.isInside(position) && board.getSquares()[position.
                getRow()][position.getColumn()].hasWall(direction.
                opposite())) {
            return 2;

        }
        return 0;

    }

    /**
     * verifie if the square has wall according to the right and the opposite
     * direction 1==> if their's a wall on the position given as argument
     * according to the right direction 2==> if the position given as argument
     * has an opposite wall according to the direction
     *
     * @param position next Position of the board
     * @param direction of animal
     * @param board of the game
     * @return true\false
     */
    protected int hasWallButMove(Position position, Direction direction,
            Board board) {
        if (board.isInside(position) && board.getSquares()[position.
                getRow()][position.
                        getColumn()].hasWall(direction.opposite())) {
            return 2;
        }
        if (board.isInside(position) && board.getSquares()[position.
                getRow()][position.
                        getColumn()].hasWall(direction)) {
            return 1;

        }
        return 0;

    }

    /**
     * Return next Position for animal all that can fly above walls or jump on
     * top of another animal
     *
     * @param instance normal movement of the animal
     * @param board of the game
     * @param direction where the nanimals is going to
     * @param animals arrays that contain all the animals of the board
     * @return the next Position if it's inside and free
     */
    protected Position canJump(Position instance, Board board,
            Direction direction, Animal... animals) {

        if (isInside(board, instance)) {
            while (!isFree(instance, animals)
                    && isInside(board, instance)) {
                instance = instance.next(direction);
            }
            return instance;

        }
        return null;

    }

    /**
     * Verify if the next Position is Equal to the position on the board
     *
     * @param position nextPosition of the animal
     * @return true/false
     */
    private boolean positionAreEquals(Position position) {
        return position.equals(positionOnBoard);
    }

    /**
     * Return or apply the nextPosition of each animals according to the animal
     * that call him
     *
     * @param board of the game
     * @param animalsNextPosition
     * @param animals arrays that contain all the animal of he game
     * @return next Position or null
     */
    protected Position applyMove(Board board,
            Position animalsNextPosition,
            Animal... animals) {
        if (animalsNextPosition == null) {
            this.setPositionOnBoard(null);
            return null;
        }
        if (positionAreEquals(animalsNextPosition)) {
            return this.getPositionOnBoard();
        } else {
            if (!isInside(board, animalsNextPosition)) {
                this.setPositionOnBoard(null);
                return this.getPositionOnBoard();
            }
            if (insideAndFreeGrass(board, animalsNextPosition,
                    animals)) {
                this.setPositionOnBoard(animalsNextPosition);
                return this.getPositionOnBoard();

            }

            if (insideAndStar(board, animalsNextPosition)) {
                setAnimalState(animalsNextPosition, board);
                return this.getPositionOnBoard();
            }

            if (!insideAndFreeGrass(board, animalsNextPosition,
                    animals)) {
                return this.getPositionOnBoard();

            }

        }

        return null;
    }

}

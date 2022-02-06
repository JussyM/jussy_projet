/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53554.humbug.model;

import static g53554.humbug.model.SquareType.GRASS;
import static g53554.humbug.model.SquareType.STAR;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jj
 */
public class BeetleTest {

    private Animal[] animals;
    private Board board;

    /**
     * Test of move method, of class Beetle.
     */
    @Test
    public void testMove() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS),
                new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(STAR), new Square(STAR)}
        });
        animals = new Animal[]{
            new Beetle(new Position(0, 0)),};
        System.out.println("move");
        Position expResult = new Position(0, 2);
        Beetle bee = (Beetle) animals[0];
        Position result = bee.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_2() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS),
                new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(STAR), new Square(STAR)}
        });
        animals = new Animal[]{
            new Beetle(new Position(0, 0)), new Snail(new Position(0, 2))};
        System.out.println("move");
        Position expResult = new Position(0, 2);
        Beetle bee = (Beetle) animals[0];
        Position result = bee.move(board, Direction.EAST, animals);
        System.out.println(animals[1].getPositionOnBoard().getRow());
        System.out.println(animals[1].getPositionOnBoard().getColumn());
        assertEquals(expResult, result);
    }

}

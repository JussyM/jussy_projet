package g53554.humbug.model;

public class Beetle extends Animal {

    public Beetle(Position position) {
        super(position);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        var finalMove = moveAnimalVolant(2, direction);
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(finalMove)) {
                applyMove(board, animal.move(board, direction, animals), animals);
            }
        }

        return applyMove(board, finalMove, animals);
    }

}

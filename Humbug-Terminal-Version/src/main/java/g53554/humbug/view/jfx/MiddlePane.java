package g53554.humbug.view.jfx;

import g53554.humbug.model.*;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Arrays;
import java.util.Objects;

public class MiddlePane extends GridPane {


    public void initBoard(Board board, Animal... animals) {
        for (int i = 0; i < board.getNbRow(); i++) {
            for (int j = 0; j < board.getNbColumn(); j++) {
                var position = new Position(i, j);
                var andIndex = new AnimalAndIndex();
                state(position, board, andIndex, animals);
            }
        }
        super.setAlignment(Pos.CENTER_LEFT);

    }


    private void state(Position position, Board board, AnimalAndIndex andIndex, Animal... animals) {
        if (board.isInside(position)) {
            if (board.getSquareType(position) == SquareType.STAR) {
                andIndex.setsType(true);
            }
            if (board.getSquareType(position) == SquareType.GRASS) {
                if (animalIsPresent(position, animals)) {
                    Animal animal1;
                    for (int i = 0; i < animals.length; i++) {
                        animal1 = animals[i].getPositionOnBoard().equals(position) ? animals[i] : null;
                        if (animal1 != null) {
                            andIndex.setIndex(i);
                            andIndex.setAnimal(animal1);
                            andIndex.setPresent(true);
                        }

                    }
                }

            }
            initButton(position, andIndex);
        }

    }


    /**
     * Return a boolean if an animal is present
     *
     * @param position that need to be check
     * @param animals  of the game
     * @return boolean true if animal is present false if not
     */
    private boolean animalIsPresent(Position position, Animal... animals) {
        return Arrays.stream(animals).anyMatch(item -> item.getPositionOnBoard().equals(position));
    }

    private void initButton(Position p, AnimalAndIndex andIndex) {
        JSquare square;
        ImageView image;
        if (andIndex.issType()) {
            square = new JSquare();
            image = imageView("/animalpng/star.png", 77, 118);
            square.setGraphic(image);

        } else {
            if (andIndex.isPresent()) {
                square = new JSquare(andIndex.getAnimal());
                switch (animalIndice(square.getAnimal())) {
                    case 1:
                        image = imageView("/animalpng/snail.png", 77, 118);
                        square.setGraphic(image);
                        break;
                    case 2:
                        image = imageView("/animalpng/spider.png", 77, 118);
                        square.setGraphic(image);
                        break;
                    case 3:
                        image = imageView("/animalpng/ladybird.png", 77, 118);
                        square.setGraphic(image);
                        break;
                    case 4:
                        image = imageView("/animalpng/grasshopper.png", 77, 118);
                        square.setGraphic(image);
                        break;
                    case 5:
                        image = imageView("/animalpng/butterfly.png", 77, 118);
                        square.setGraphic(image);
                        break;
                    case 6:
                        image = imageView("/animalpng/bumblebee.png", 77, 118);
                        square.setGraphic(image);
                        break;
                }


            } else {
                square = new JSquare();
                image = imageView("/animalpng/grass.png", 77, 118);
                square.setGraphic(image);
            }
        }
        square.setMaxSize(77,118);
        super.add(square, p.getColumn(), p.getRow());

    }

    private int animalIndice(Animal animal) {
        if (animal instanceof Snail) {
            return 1;
        }
        if (animal instanceof Spider) {
            return 2;
        }
        if (animal instanceof Ladybird) {
            System.out.println("Anamal LadyBird");
            return 3;
        }
        if (animal instanceof Grasshopper) {
            return 4;
        }
        if (animal instanceof Butterfly) {
            return 5;
        }
        if (animal instanceof Bumbelbee) {
            return 6;
        }
        return 0;
    }

    private ImageView imageView(String path, int width, int height) {
        return new ImageView(new Image(Objects.requireNonNull(MiddlePane.class.getResourceAsStream(path)),
                width, height, true, true));
    }

}


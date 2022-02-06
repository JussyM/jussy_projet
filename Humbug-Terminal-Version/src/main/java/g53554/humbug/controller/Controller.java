package g53554.humbug.controller;

import g53554.humbug.designPattern.Observer;
import g53554.humbug.model.*;
import g53554.humbug.view.console.InterfaceView;
import g53554.humbug.view.console.View;

/**
 * Controller method interact with the player
 *
 * @author 53554
 */
public class Controller {

    private final Model game;
    private final InterfaceView view;

    /**
     * Controller constructor
     */

    public Controller() {
        this.game = new Game();
        this.view = new View();
    }

    /**
     * Start game method he initialized all the getAnimals on the board
     * initialized the board and display it
     *
     * @param nLevel number the represent the level of the game
     */
    public void startGame(int nLevel) {
        view.displayGameName();
        var totalLevel = 100;
        var level = nLevel;
        game.registerObservers((Observer) view);
        while (level <= totalLevel) {
            try {
                view.displayAnimalSigle();
                game.startLevel(level);
                view.displayMessage("NIVEAU: " + game.getCurrentLevel() + "\n");

                do {
                    ((Observer) view).update(game);
                    var position = view.askPosition();
                    while (!validPosition(position, game.getAnimals())) {
                        view.displayError("Pas d'animal à cette case " + "\n"
                                + "\n");
                        position = view.askPosition();

                    }
                    Direction direction = view.askDirection();
                    game.move(position, direction);

                } while (!game.hasWon());
                level++;
                view.displayBoard(game.getBoard());
                view.displayWinnerMsg();

            } catch (NullPointerException | ArrayIndexOutOfBoundsException
                    | IllegalStateException e) {

                view.displayError(e.getMessage() + "\n" + "\n");

            }

        }
        view.displayMessage("Félicitation vous avez finit le jeu");

    }

    /**
     * Verify if the position given as argument is correct and if their's an
     * animal at that position
     *
     * @param position given by the usr
     * @param animals  arrays of all the getAnimals of the game
     * @return boolean true if correct false if not
     */
    private boolean validPosition(Position position, Animal... animals) {
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(position)) {
                return true;
            }
        }
        return false;

    }

    /**
     * return the value given by player
     *
     * @return level (int)
     */
    public int initialiazedLevel() {
        return view.askLevel();
    }

}

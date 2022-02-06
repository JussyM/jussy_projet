package g53554.humbug.view.jfx;

import g53554.humbug.designPattern.Observer;
import g53554.humbug.model.*;
import g53554.humbug.view.console.InterfaceView;
import javafx.scene.layout.GridPane;

public class View extends Observer implements InterfaceView {
    private MiddlePane middlePane;

    @Override
    public void update(Object args) {

    }

    @Override
    public void displayBoard(Board board, Animal... animals) {
        this.middlePane = new MiddlePane();
        this.middlePane.initBoard(board, animals);

    }

    @Override
    public Position askPosition() {
        return null;
    }

    @Override
    public Direction askDirection() {
        return null;
    }

    @Override
    public void displayError(String message) {

    }

    @Override
    public void displayGameName() {

    }

    @Override
    public void displayWinnerMsg() {

    }

    @Override
    public void displayRemainingMove(int getMoves) {

    }

    @Override
    public void displayAnimalSigle() {

    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public int askLevel() {
        return 0;
    }

    public GridPane midllePane() {
        return middlePane;
    }

}

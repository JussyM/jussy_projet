package g53554.humbug.view.jfx;

import g53554.humbug.model.Animal;
import javafx.scene.control.Button;

public class JSquare extends Button {
    private Animal animal;
    private boolean isPresent;
    private boolean sType;


    public JSquare() {
        this.isPresent = false;
        this.animal = null;
    }

    public JSquare(Animal animal) {
        this.animal = animal;
        this.isPresent = true;
    }

    public Animal getAnimal() {
        return animal;
    }

    public boolean isPresent() {
        return isPresent;
    }
}

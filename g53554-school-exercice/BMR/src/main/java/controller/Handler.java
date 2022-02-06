package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.BMR;
import model.Man;
import model.Person;
import model.Woman;
import view.View;

/**
 * The type Handler.
 */
public class Handler implements EventHandler<MouseEvent> {
    private final View view;

    /**
     * the handler event
     */
    @Override
    public void handle(MouseEvent mouseEvent) {
        BMR bmr;
        Person person;
        if (view.isValid()) {
            switch (view.getSex()) {
                case "Homme":
                    person = new Man(view.getWeight(), view.getSize(), view.getAge(), view.getLevel());
                    break;
                case "Femme":
                    person = new Woman(view.getWeight(), view.getSize(), view.getAge(), view.getLevel());
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + view.getSex());
            }
            bmr = new BMR(person);
            bmr.registerObserver(view);
            bmr.notifyObservers(bmr);
        } else {
            view.setIncorrectState();
        }

    }

    /**
     * Instantiates a new Handler.
     *
     * @param view the view
     */
    public Handler(View view) {
        this.view = view;
    }

    /**
     * Add an even handler to the button
     *
     */
    public void addEvenHandler() {
        view.getButton().addEventHandler(MouseEvent.MOUSE_CLICKED, this);
    }
}

package view.buttonHandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Facade;
import model.Game;
import view.viewJfx.SkyjoView;

/**
 * The type Handler discard b.
 */
public class HandlerDiscardB implements EventHandler<MouseEvent> {

    private final SkyjoView view;
    private final Facade game;

    /**
     * Instantiates a new Handler discard b.
     *
     * @param view the view
     */
    public HandlerDiscardB(SkyjoView view, Facade game) {
        this.view = view;
        this.game = game;
    }


    /**
     * Handle method
     *
     * @param event mouse even when we got click
     */
    @Override
    public void handle(MouseEvent event) {
        if (event.getClickCount() == 2) {
            game.updateDiscardOnly();

        }// else if (event.getClickCount() == 1) {
        // view.setLabelAdviceMessage(1);
        // view.setClickDiscard(true);
        // }


    }

    /**
     * Defined action handler.
     */
    public void definedActionHandler() {
        view.discardButton().addEventHandler(MouseEvent.MOUSE_CLICKED, this);

    }
}

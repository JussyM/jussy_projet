package view.buttonHandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Facade;
import view.viewJfx.SkyjoView;

/**
 * The type Handler pick b.
 */
public class HandlerPickB implements EventHandler<MouseEvent> {
    private final SkyjoView view;
    private final Facade game;

    /**
     * Instantiates a new Handler pick b.
     *
     * @param view the view
     * @param game the game
     */
    public HandlerPickB(SkyjoView view, Facade game) {
        this.view = view;
        this.game = game;
    }

    /**
     * Handle methode for pick button
     *
     * @param event mouse click even
     */
    @Override
    public void handle(MouseEvent event) {
        view.setLabelAdviceMessage(2);
        view.setClickPick(true);
        var cardPick = game.hit();
        view.addACard(cardPick);
        view.setCardPick(cardPick);

    }

    /**
     * Defined action handler.
     */
    public void definedActionHandler() {
        view.pickHandButton().addEventHandler(MouseEvent.MOUSE_CLICKED, this);
    }
}

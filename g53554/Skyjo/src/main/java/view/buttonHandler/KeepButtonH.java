package view.buttonHandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.viewJfx.SkyjoView;

/**
 * The type Keep button h.
 */
public class KeepButtonH implements EventHandler<MouseEvent> {
    private final SkyjoView view;

    /**
     * Handler for keep button
     * @param event mouse click event
     */
    @Override
    public void handle(MouseEvent event) {
        view.setLabelAdviceMessage(3);
        view.setPickOption(1);


    }

    /**
     * Instantiates a new Keep button h.
     *
     * @param view of the game
     */
    public KeepButtonH(SkyjoView view) {
        this.view=view;
    }

    /**
     * Add event.
     */
    public void addEvent() {
        var button = view.getKeepB();
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
    }
}


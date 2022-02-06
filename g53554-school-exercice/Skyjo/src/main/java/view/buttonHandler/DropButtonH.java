package view.buttonHandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.viewJfx.SkyjoView;

/**
 * The type Drop button h.
 */
public class DropButtonH implements EventHandler<MouseEvent> {
    private final SkyjoView view;

    /**
     * Instantiates a new Drop button h.
     *
     * @param view the Skyjo View
     */
    public DropButtonH(SkyjoView view) {
        this.view=view;
    }

    /**
     * Handler
     * @param event to defined the action
     */
    @Override
    public void handle(MouseEvent event) {
        view.setLabelAdviceMessage(4);
        view.setPickOption(-1);

    }

    /**
     * Add event.
     */
    public void addEvent() {
        var button = view.getNoKeepB();
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
    }
}

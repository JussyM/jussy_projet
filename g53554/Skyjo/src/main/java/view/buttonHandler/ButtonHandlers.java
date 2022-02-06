package view.buttonHandler;

import controller.Controller;

public class ButtonHandlers {
    private final HandlerDiscardB discardB;
    private final HandlerCardB handlerCardB;
    private final HandlerPickB handlerPickB;
    private final DropButtonH dropButtonH;
    private final KeepButtonH keepButtonH;

    /**
     * Button Handler constructor
     *
     * @param controller use to create the handlers
     */
    public ButtonHandlers(Controller controller) {
        discardB = new HandlerDiscardB(controller.getView(),controller.getGame());
        handlerCardB = new HandlerCardB(controller.getGame(), controller.getView());
        handlerPickB = new HandlerPickB(controller.getView(), controller.getGame());
        dropButtonH = new DropButtonH(controller.getView());
        keepButtonH = new KeepButtonH(controller.getView());
    }

    /**
     * defined the handler of all the button use in the game
     */
    public void definedHandlers() {
        discardB.definedActionHandler();
        handlerCardB.addEventToCard();
        handlerPickB.definedActionHandler();
        dropButtonH.addEvent();
        keepButtonH.addEvent();
    }


}

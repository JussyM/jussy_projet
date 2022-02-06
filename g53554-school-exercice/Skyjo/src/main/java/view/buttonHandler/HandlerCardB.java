package view.buttonHandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Facade;
import view.viewJfx.SkyjoView;

/**
 * The type Handler card b.
 */
public class HandlerCardB implements EventHandler<MouseEvent> {
    private final Facade game;
    private final SkyjoView view;

    @Override
    public void handle(MouseEvent event) {
        if (view.isClickDiscard()) {
            discardAction(game, view);
        } else if (view.isClickPick()) {
            pitchedAction(game, view);
        } else {
            view.setLabelAdviceMessage(-1);
        }

    }


    /**
     * Instantiates a new Handler card b.
     *
     * @param game the game
     * @param view the view
     */
    public HandlerCardB(Facade game,SkyjoView view) {
        this.game=game;
        this.view = view;
    }

    /**
     * Add event to card.
     */
    public void addEventToCard() {
        var cards =view.getListCard();
        cards.forEach(x -> x.addEventHandler(MouseEvent.MOUSE_CLICKED, this));
    }

    /**
     * defined the discard action
     *
     * @param game element for skyjo
     * @param view element for skyjo view
     */
    private void discardAction(Facade game, SkyjoView view) {
        try {
            game.getCurrentPlayer().setSelected(view.getCardClick());

            var signals = new boolean[]{true, false, false};
            game.updateGame(signals, game.getPeek());
            game.updateScore();
            if (game.isOver()) {
                view.setLabelAdviceMessage(5);
                view.lockHbox();
            } else {
                view.setClickDiscard(false);
                game.switchPlayer();

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            view.setLabelAdviceMessage(-2);
        }
    }

    /**
     * defined the pitched action
     *
     * @param game element for skyjo
     * @param view element for skyjo view
     */
    private void pitchedAction(Facade game, SkyjoView view) {
        try {
            var signals = new boolean[3];
            //noinspection EnhancedSwitchMigration
            switch (view.getPickOption()) {
                case 1:
                    signals = new boolean[]{false, true, true};
                    break;
                case -1:
                    signals = new boolean[]{false, true, false};
                    break;
            }
            game.getCurrentPlayer().setSelected(view.getCardClick());
            game.updateGame(signals, view.getCardPick());
            game.updateScore();
            if (game.isOver()) {
                view.setLabelAdviceMessage(5);
                view.lockHbox();
            } else {
                view.hidePopUp();
                view.setClickPick(false);
                game.switchPlayer();

            }

        } catch (Exception e) {
            view.setLabelAdviceMessage(-2);
        }
    }
}

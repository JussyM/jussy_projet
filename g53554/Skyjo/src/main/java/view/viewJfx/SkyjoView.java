package view.viewJfx;

import designPattern.Observer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.Card;
import model.Facade;
import model.Game;

import java.util.List;
import java.util.Objects;

/**
 * The type Skyjo view.
 */
public class SkyjoView implements Observer {
    private final SkyjoVBox vBox;
    private final SkyjoHBox hBox;
    private boolean isClickDiscard;
    private boolean isClickPick;
    private Card cardPick;
    private boolean doubleClick;

    public boolean isDoubleClick() {
        return doubleClick;
    }

    public void setDoubleClick(boolean doubleClick) {
        this.doubleClick = doubleClick;
    }

    /**
     * Gets card pick.
     *
     * @return the card pick
     */
    public Card getCardPick() {
        return cardPick;
    }

    /**
     * Sets card pick.
     *
     * @param cardPick the card pick
     */
    public void setCardPick(Card cardPick) {
        this.cardPick = cardPick;
    }

    /**
     * Is click discard boolean.
     *
     * @return the boolean
     */
    public boolean isClickDiscard() {
        return isClickDiscard;
    }

    /**
     * Sets click discard.
     *
     * @param clickDiscard the click discard
     */
    public void setClickDiscard(boolean clickDiscard) {
        isClickDiscard = clickDiscard;
    }

    /**
     * Is click pick boolean.
     *
     * @return the boolean
     */
    public boolean isClickPick() {
        return isClickPick;
    }

    /**
     * Sets click pick.
     *
     * @param clickPick the click pick
     */
    public void setClickPick(boolean clickPick) {
        isClickPick = clickPick;
    }

    /**
     * Instantiates a new Skyjo view.
     *
     * @param game the game
     */
    public SkyjoView(Facade game) {
        Objects.requireNonNull(game, "Game Must not be given null");
        vBox = new SkyjoVBox(game);
        hBox = new SkyjoHBox(game);
        this.isClickDiscard = false;
        this.isClickPick = false;
    }

    /**
     * Init view.
     *
     * @param game the game
     */
    public void initView(Facade game) {
        hBox.createHbox(game.getCurrentPlayer(), game.getOpponentPlayer());
        vBox.getChildren().add(hBox);
        vBox.createVbox();

    }

    /**
     * Gets box.
     *
     * @return box box
     */
    public SkyjoVBox getvBox() {
        return vBox;
    }

    @Override
    public void update(Object args) {
        System.out.println("Thread qui fait la MAJ "+ Thread.currentThread().getName());
        hBox.updateElements((Game) args);
        vBox.setLabelAdviceMessage(0);
    }

    /**
     * Pick hand button button.
     *
     * @return the button
     */
    public Button pickHandButton() {
        return hBox.getPickButton();

    }

    /**
     * Discard button button.
     *
     * @return the button
     */
    public Button discardButton() {
        return hBox.getDiscardButton();

    }

    /**
     * Sets label advice message.
     *
     * @param signal the signal
     */
    public void setLabelAdviceMessage(int signal) {
        vBox.setLabelAdviceMessage(signal);
    }

    /**
     * Gets list card.
     *
     * @return the list card
     */
    public List<CardButton> getListCard() {
        return hBox.getListButton();
    }

    /**
     * Add a card.
     *
     * @param card the card
     */
    public void addACard(Card card) {
        hBox.addACard(card);
    }

    /**
     * Gets pick option.
     *
     * @return the pick option
     */
    public int getPickOption() {
        return hBox.getPickOption();
    }

    /**
     * Gets keep b.
     *
     * @return the keep b
     */
    public Button getKeepB() {
        return hBox.getKeepB();
    }

    /**
     * Gets no keep b.
     *
     * @return the no keep b
     */
    public Button getNoKeepB() {
        return hBox.getNoKeepB();
    }

    /**
     * Sets pick option.
     *
     * @param option the option
     */
    public void setPickOption(int option) {
        hBox.setPickOption(option);
    }

    /**
     * Hide pop up.
     */
    public void hidePopUp() {
        hBox.hidePopUp();
    }

    /**
     * Gets card click.
     *
     * @return the card click
     */
    public Card getCardClick() {
        return hBox.getClick().getCard();
    }

    /**
     * An event filter will be add when the game will be over to lock all the click of mouse
     */
    public void lockHbox() {
        hBox.addEventFilter(MouseEvent.ANY, (EventHandler<Event>) Event::consume);
    }
}

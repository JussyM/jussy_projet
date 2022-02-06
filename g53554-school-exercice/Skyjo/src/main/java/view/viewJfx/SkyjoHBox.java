package view.viewJfx;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import model.Card;
import model.Facade;
import model.Game;
import model.Player;

import java.util.List;
import java.util.Objects;

/**
 * The type Skyjo h box.
 */
public class SkyjoHBox extends HBox {
    private final PlayerVBox leftPlayer;
    private final RightPane rightPlayer;
    private final MiddleVBox middle_Pane;

    /**
     * Instantiates a new Skyjo h box.
     *
     * @param game the game
     */
    public SkyjoHBox(Facade game) {
        Objects.requireNonNull(game, "Game in skyjoHBox must not be null");
        leftPlayer = new PlayerVBox(game.getCurrentPlayer());
        rightPlayer = new RightPane(game.getOpponentPlayer());
        middle_Pane = new MiddleVBox(game.getDeck());
    }

    /**
     * Create hbox.
     *
     * @param player1 the player 1
     * @param player2 the player 2
     */
    public void createHbox(Player player1, Player player2) {
        super.setMaxSize(500, 600);
        super.setMinSize(500, 600);
        super.setSpacing(20);
        super.setPadding(new Insets(10));
        leftPlayer.createPane(player1);
        middle_Pane.createPane();
        rightPlayer.createPane(player2);
        super.getChildren().add(leftPlayer);
        super.getChildren().add(middle_Pane);
        super.getChildren().add(rightPlayer);

    }

    /**
     * Gets pick button.
     *
     * @return the pick button
     */
    public Button getPickButton() {
        return middle_Pane.getPickButton();
    }

    /**
     * Gets discard button.
     *
     * @return the discard button
     */
    public Button getDiscardButton() {
        return middle_Pane.getDiscardButton();
    }

    /**
     * Update element.
     *
     * @param game the game
     */
    public void updateElements(Game game) {
        revealCard(game.getCurrentPlayer(), game.getOpponentPlayer());
        leftPlayer.setScore(game.getCurrentPlayer());

        rightPlayer.setScore(game.getOpponentPlayer());
        middle_Pane.setDiscardLabel();
        middle_Pane.updateDeckLabel();

    }

    /**
     * Gets click.
     *
     * @return the click
     */
    public CardButton getClick() {
        return leftPlayer.getClick();
    }

    /**
     * Gets list button.
     *
     * @return the list button
     */
    public List<CardButton> getListButton() {
        return leftPlayer.getListButton();
    }

    /**
     * Reveal card.
     *
     * @param player_1 the player 1
     * @param player_2 the player 2
     */
    public void revealCard(Player player_1, Player player_2) {
        leftPlayer.revealCards(player_1);
        rightPlayer.revealCards(player_2);
    }

    /**
     * Add a card.
     *
     * @param card the card
     */
    public void addACard(Card card) {
        middle_Pane.addShowCardLabel(card);
    }

    /**
     * Gets pick option.
     *
     * @return the pick option
     */
    public int getPickOption() {
        return middle_Pane.getPickOption();
    }

    /**
     * Gets keep b.
     *
     * @return the keep b
     */
    public Button getKeepB() {
        return middle_Pane.getKeepB();
    }

    /**
     * Gets no keep button.
     *
     * @return the no keep button
     */
    public Button getNoKeepB() {
        return middle_Pane.getNoKeepB();
    }

    /**
     * Sets pick option.
     *
     * @param option the option
     */
    public void setPickOption(int option) {
        middle_Pane.setPickOption(option);
    }

    /**
     * Hide pop up.
     */
    public void hidePopUp() {
        middle_Pane.hidePopUp();
    }
}

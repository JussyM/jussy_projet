package view.viewJfx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Facade;

import java.util.Objects;


/**
 * The type Skyjo v box.
 */
@SuppressWarnings("EnhancedSwitchMigration")
public class SkyjoVBox extends VBox {
    private final Facade game;
    private final Label labelAdvice;

    /**
     * Instantiates a new Skyjo v box.
     *
     * @param game the game
     */
    public SkyjoVBox(Facade game) {
        this.game = Objects.requireNonNull(game, "Game must not be null");
        labelAdvice = new Label();

    }

    /**
     * Create vbox.
     */
    public void createVbox() {
        super.setMaxSize(500, 500);
        super.setMinSize(500, 500);
        super.setSpacing(10);
        super.setPadding(new Insets(10));
        super.setStyle("-fx-background-color: #87CEEB;");
        labelAdvice.setAlignment(Pos.CENTER);
        labelAdvice.setMaxSize(1200, 20);
        labelAdvice.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        super.getChildren().add(labelAdvice);

    }

    /**
     * Sets label advice message.
     *
     * @param signal the signal
     */
    public void setLabelAdviceMessage(int signal) {
        labelAdvice.setStyle("-fx-background-color: lightgreen;-fx-text-fill: " +
                "black;-fx-padding:10;fx-spaccing:10;-fx-background-radius:5.0;");
        switch (signal) {
            case 0:
                labelAdvice.setText("Player " + game.getCurrentPlayer().getId()
                        + ":" + " Time for you to play a round".toUpperCase());
                break;
            case 1:
                labelAdvice.setText("You choose to pick a card from the discard " +
                        "select a card from your grid for exchange".toUpperCase());
                break;
            case 2:
                labelAdvice.setText("You choose to pick from the deck choose your action below...".toUpperCase());
                break;
            case -1:
                labelAdvice.setText("You did not select an action for chosen a card please select an action ".toUpperCase());
                break;
            case -2:
                labelAdvice.setText("Something went wrong retry...".toUpperCase());
                break;
            case -3:
                labelAdvice.setText("You have not choose a card from your grid".toUpperCase());
                break;
            case 3:
                labelAdvice.setText("You choose to keep the card from the pitched select a card from your grid".toUpperCase());
                break;
            case 4:
                labelAdvice.setText("You choose not to keep the card choose a card from your grip for exchange".toUpperCase());
                break;
            case 5:
                labelAdvice.setText("THE WINNER IS PLAYER:" + game.getWinner().getId());
                break;
            case 6:
                labelAdvice.setText("you double click on the discard the card will be put into the pitched".toUpperCase());
                break;

        }

    }

}

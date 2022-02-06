package view.viewJfx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Player;

/**
 * The type Right pane.
 */
public class RightPane extends VBox {
    private final LocalLabel gridPane;
    private final Label upperLabel;

    /**
     * Instantiates a new Right pane.
     *
     * @param player the player
     */
    public RightPane(Player player) {
        this.gridPane = new LocalLabel(player);
        this.upperLabel = new Label();
    }

    /**
     * Create Gridpane.
     *
     * @param player the player
     */
    public void createPane(Player player) {
        super.setMaxSize(450, 450);
        super.setMinSize(450, 450);
        super.setPadding(new Insets(10));
        super.setSpacing(20);
        upperLabel.setMaxSize(350, 30);
        upperLabel.setText("Player: " + player.getId() + "  " + "Score: " + player.getScore());
        upperLabel.setAlignment(Pos.CENTER);
        upperLabel.setStyle("-fx-background-color: burlywood;-fx-padding:10;fx-spaccing:20;-fx-background-radius:10.0;");
        super.getChildren().add(upperLabel);
        super.getChildren().add(gridPane);


    }

    /**
     * Reveal cards.
     *
     * @param player the player
     */
    public void revealCards(Player player) {
        gridPane.revealCards(player);

    }

    /**
     * Sets score.
     *
     * @param player the player
     */
    public void setScore(Player player) {
        upperLabel.setText("Player: " + player.getId() + "  " + "Score: " + player.getScore());
    }

}

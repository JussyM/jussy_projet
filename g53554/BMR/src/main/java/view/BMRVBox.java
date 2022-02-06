package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * The type Bmrv box.
 */
public class BMRVBox extends VBox {
    private Button button;

    /**
     * Defined the vBox button
     */
    public void definedButton() {
        button = new Button("Calcule BMR");
        button.setFont(Font.font("System", 20));
        button.setPrefSize(700,30);
        super.getChildren().add(button);
        super.setSpacing(20);
        var buttonCancel = new Button("Cancel");
        buttonCancel.setPrefSize(700, 30);
        buttonCancel.setFont(Font.font("System", 20));
        buttonCancel.setOnAction(actionEvent -> {
            System.exit(0);
        });

        super.getChildren().add(buttonCancel);
        super.setAlignment(Pos.BOTTOM_CENTER);
    }

    /**
     * Gets button.
     *
     * @return the button
     */
    public Button getButton() {
        return button;
    }

}

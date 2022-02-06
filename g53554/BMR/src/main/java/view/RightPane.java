package view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.BMR;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Right pane.
 */
public class RightPane extends GridPane {
    private List<Node> nodeList;

    /**
     * Instantiates a new Right pane.
     */
    public RightPane() {
        super();
        this.nodeList = new ArrayList<>();
    }

    /**
     * defined rightPane title
     */
    public void definedRightTitle() {
        var title2 = new Label("RESULT:");
        title2.setFont(Font.font("System", FontWeight.BOLD, 10));
        title2.setTextFill(Color.RED);
        title2.setUnderline(true);
        super.setAlignment(Pos.TOP_RIGHT);
        super.setPadding(new Insets(20));
        super.setHgap(10);
        super.setVgap(15);
        super.add(title2, 0, 0, 2, 1);

    }

    /**
     * Defined right label.
     */
    public void definedRightLabel() {
        var labelBMR = new Label("BMR");
        GridPane.setHalignment(labelBMR, HPos.RIGHT);
        super.add(labelBMR, 2, 1);
        var textFieldBMR = new TextField();
        textFieldBMR.setPrefColumnCount(10);
        textFieldBMR.setPromptText("Resultat BMR");
        nodeList.add(textFieldBMR);

        super.add(textFieldBMR, 3, 1);
        var labelCalories = new Label("Calories");
        GridPane.setHalignment(labelCalories, HPos.RIGHT);
        super.add(labelCalories, 2, 2);
        var textFieldCalories = new TextField();
        textFieldCalories.setPrefColumnCount(10);
        textFieldCalories.setPromptText("Resultat Calorie");
        nodeList.add(textFieldCalories);
        super.add(textFieldCalories, 3, 2);
    }

    /**
     * Sets label state.
     *
     * @param bmr the bmr
     */
    public void setLabelState(BMR bmr) {
        var bmrLabel = (TextField) nodeList.get(0);
        var calorieLabel = (TextField) nodeList.get(1);
        bmrLabel.setText("" + bmr.getBMR());
        calorieLabel.setText("" + bmr.getCalories());
    }

    /**
     * Sets label state incorrect.
     */
    public void setLabelStateIncorrect() {
        var bmrLabel = (TextField) nodeList.get(0);
        var calorieLabel = (TextField) nodeList.get(1);
        bmrLabel.setText("ERROR");
        calorieLabel.setText("ERROR");
    }
}

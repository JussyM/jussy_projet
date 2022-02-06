package view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.ActivityLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Left pane.
 */
public class LeftPane extends GridPane  {
    private List<Node> nodeList;

    /**
     * Instantiates a new Left pane.
     */
    public LeftPane() {
        this.nodeList = new ArrayList<>();
    }

    /**
     * defined leftPane title
     */
    public void definedLeftTitle() {
        var title1 = new Label("DATA:");
        title1.setFont(Font.font("System", FontWeight.BOLD, 10));
        title1.setTextFill(Color.RED);
        title1.setUnderline(true);
        super.setAlignment(Pos.TOP_RIGHT);
        super.setPadding(new Insets(20));
        super.setHgap(10);
        super.setVgap(15);
        super.add(title1, 0, 0, 1, 1);
    }

    /**
     * defined leftPane label and composite
     */
    public void definedLeftLabel() {
        var labelSize = new Label("Taille (cm)");
        GridPane.setHalignment(labelSize, HPos.RIGHT);
        super.add(labelSize, 0, 1);
        var textFieldSize = new TextField();
        textFieldSize.setPrefColumnCount(10);
        textFieldSize.setPromptText("Taille en cm");
        super.add(textFieldSize, 1, 1);
        this.nodeList.add(textFieldSize);

        var labelWeight = new Label("Poids (cm)");
        GridPane.setHalignment(labelWeight, HPos.RIGHT);
        super.add(labelWeight, 0, 2);
        var textFieldWeight = new TextField();
        textFieldWeight.setPrefColumnCount(10);
        textFieldWeight.setPromptText("Poids (cm)");
        super.add(textFieldWeight, 1, 2);
        this.nodeList.add(textFieldWeight);

        var labelAge = new Label("Age (année)");
        GridPane.setHalignment(labelAge, HPos.RIGHT);
        super.add(labelAge, 0, 3);
        var textFieldAge = new TextField();
        textFieldAge.setPrefColumnCount(10);
        textFieldAge.setPromptText("Age (année)");
        super.add(textFieldAge, 1, 3);
        this.nodeList.add(textFieldAge);

        var sexLabel = new Label("Sexe");
        super.add(sexLabel, 0, 4);
        var tempHbox = new ToggleGroup();
        var radioButtonMen = new RadioButton("Homme");
        var radioButtonWoman = new RadioButton("Femme");
        tempHbox.getToggles().addAll(radioButtonMen, radioButtonWoman);
        super.add(radioButtonMen, 1, 4);
        super.add(radioButtonWoman, 2, 4);

        this.nodeList.add(radioButtonMen);
        this.nodeList.add(radioButtonWoman);

        var choiceBoxLabelMsg = new Label("Style de vie");
        GridPane.setHalignment(choiceBoxLabelMsg, HPos.RIGHT);
        super.add(choiceBoxLabelMsg, 0, 5);
        var choiceBox = new ChoiceBox<ActivityLevel>();
        choiceBox.getItems().addAll(ActivityLevel.values());
        choiceBox.setValue(ActivityLevel.ACTIVE);
        this.nodeList.add(choiceBox);
        super.add(choiceBox, 1, 5);
    }


    /**
     * Gets weight.
     *
     * @return the weight
     */
    public int getWeight() {
        return Integer.parseInt(textFieldElem()[1]);
    }


    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return Integer.parseInt(textFieldElem()[2]);
    }


    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() { return Integer.parseInt(textFieldElem()[0]); }


    /**
     * Gets sex.
     *
     * @return the sex
     */
    public String getSex() {
        RadioButton button = (RadioButton) this.getNodeList().get(3);
        if (!button.isSelected()) {
            button = (RadioButton) this.getNodeList().get(4);
        }
        return button.getText();
    }


    /**
     * Gets level.
     *
     * @return the level
     */
    public ActivityLevel getLevel() {
        var choiceBox = (ChoiceBox) getNodeList().get(5);
        return (ActivityLevel) choiceBox.getValue();
    }

    /**
     * return all the first three element
     * @return array of string
     */
    private String[] textFieldElem() {
        var nbTextFieldElm = 3;
        String[] input = new String[nbTextFieldElm];
        TextField instance;
        for (int index = 0; index < nbTextFieldElm; index++) {
            instance = (TextField) getNodeList().get(index);
            input[index] = instance.getText();

        }
        return input;

    }

    /**
     * Is valid boolean.
     *
     * @return boolean
     */
    public boolean isValid() {
        var strings = textFieldElem();
        try {
            for (String string : strings) {
                if (string.isEmpty() || Integer.parseInt(string) < 0) {
                    return false;
                }
            }

        } catch (NumberFormatException e) {
            return false;
        }
        return true;

    }

    /**
     * Gets node list.
     *
     * @return the node list
     */
    public List<Node> getNodeList() {
        return nodeList;
    }
}

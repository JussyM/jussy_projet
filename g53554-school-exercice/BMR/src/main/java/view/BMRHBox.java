package view;

import javafx.scene.layout.HBox;
import model.ActivityLevel;
import model.BMR;

/**
 * The type Bmrh box.
 */
public class BMRHBox extends HBox {
    private final LeftPane leftPane;
    private final RightPane rightPane;


    /**
     * hbox constructor
     */
    public BMRHBox() {
        leftPane = new LeftPane();
        rightPane = new RightPane();

    }

    /**
     * Init h box.
     */
    public void initHBox() {
        definedGridPane();
        super.getChildren().addAll(leftPane, rightPane);
    }

    /**
     * defined each gridPane instance
     */
    private void definedGridPane() {
        definedLeftPane();
        definedRightPane();
    }

    /**
     * defined rightPane title and labels
     */
    private void definedRightPane() {
        rightPane.definedRightTitle();
        rightPane.definedRightLabel();

    }

    /**
     * defined leftPane title and labels
     */
    private void definedLeftPane() {
        leftPane.definedLeftTitle();
        leftPane.definedLeftLabel();
    }

    /**
     * Sets label state.
     *
     * @param bmr the bmr
     */
    public void setLabelState(BMR bmr) {
        rightPane.setLabelState(bmr);

    }

    /**
     * Is valid boolean.
     *
     * @return the boolean
     */
    public boolean isValid() {
        return leftPane.isValid();
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public ActivityLevel getLevel() {
        return leftPane.getLevel();
    }

    /**
     * Gets sex.
     *
     * @return the sex
     */
    public String getSex() {
        return leftPane.getSex();
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return leftPane.getSize();
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return leftPane.getAge();
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public int getWeight() {
        return leftPane.getWeight();
    }

    /**
     * Set incorrect state.
     */
    public void setIncorrectState(){
        rightPane.setLabelStateIncorrect();
    }


}

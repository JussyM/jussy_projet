package view;

import classPatern.Observer;
import javafx.scene.control.Button;
import model.ActivityLevel;
import model.BMR;

/**
 * The type View.
 */
public class View implements Observer {
    private final BMRVBox myVBox;
    private final BMRHBox bmrhBox;

    /**
     * View Constructor
     */
    public View() {
        myVBox = new BMRVBox();
        bmrhBox = new BMRHBox();
    }

    /**
     * wrap the Hbox into the VBox
     */
    public void initView() {
        bmrhBox.initHBox();
        myVBox.getChildren().add(bmrhBox);
        myVBox.definedButton();

    }

    @Override
    public void update(Object arg) {
        bmrhBox.setLabelState((BMR) arg);
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public ActivityLevel getLevel() {
        return bmrhBox.getLevel();
    }

    /**
     * Gets sex.
     *
     * @return the sex
     */
    public String getSex() {
        return bmrhBox.getSex();
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return bmrhBox.getSize();
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return bmrhBox.getAge();
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public int getWeight() {
        return bmrhBox.getWeight();
    }

    /**
     * Is valid boolean.
     *
     * @return the boolean
     */
    public boolean isValid() {
        return bmrhBox.isValid();
    }

    /**
     * Gets button.
     *
     * @return the button
     */
    public Button getButton() {
        return myVBox.getButton();
    }

    /**
     * Sets incorrect state.
     */
    public void setIncorrectState() {
        bmrhBox.setIncorrectState();
    }

    /**
     * Gets my v box.
     *
     * @return the my v box
     */
    public BMRVBox getMyVBox() {
        return myVBox;
    }
}

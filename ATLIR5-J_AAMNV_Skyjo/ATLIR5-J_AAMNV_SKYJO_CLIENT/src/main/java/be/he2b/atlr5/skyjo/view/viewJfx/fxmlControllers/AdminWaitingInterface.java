package be.he2b.atlr5.skyjo.view.viewJfx.fxmlControllers;

import be.he2b.atlr5.skyjo.controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for welcomeScreen mainly made for the admin (the first
 * client that log in)
 *
 * @author
 */
public class AdminWaitingInterface implements Initializable {

    @FXML
    Label playerName;
    Controller controller;
    @FXML
    Button buttonEnter;
    @FXML
    Label playerMsg;

    /**
     * Constructor
     *
     * @param controller for the player
     */
    public AdminWaitingInterface(Controller controller) {
        this.controller = controller;
    }

    /**
     * function override from the Initializable interface
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setLabelName();
        definedAction();
        buttonEnter.setDisable(true);

    }

    /**
     * set the player name on the GUI
     */
    private void setLabelName() {
        playerName.setText(controller.getUserName());
    }

    /**
     * Sets disable button for the button enter make it enable for the user to
     * click on it.
     */
    public void setDisable() {
        this.buttonEnter.setDisable(false);
    }

    /**
     * Defined the button enter handler
     */
    private void definedAction() {
        buttonEnter.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            controller.createTheGame();

        });
    }
}

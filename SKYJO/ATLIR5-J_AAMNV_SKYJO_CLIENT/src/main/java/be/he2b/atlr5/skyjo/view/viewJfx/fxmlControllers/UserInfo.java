package be.he2b.atlr5.skyjo.view.viewJfx.fxmlControllers;

import be.he2b.atlr5.skyjo.skyjoPlayer.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UserInfo implements Initializable {

    @FXML
    private Label userName;
    @FXML
    private Label id;
    @FXML
    private Label type;
    private final User user;

    /**
     * Default constructor 
     * @param user the current user
     */
    public UserInfo(User user) {
        this.user = user;
    }

    /**
     * Override function from Initializable
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userName.setText(user.getName());
        id.setText(String.valueOf(user.getID()));
        type.setText(String.valueOf(user.getType()));

    }

}

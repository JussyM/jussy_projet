package javaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloWorldTextField extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("My FX APP");
        BorderPane root = new BorderPane();
        var username = new Label("User Name");
        var test = new Label("User Name saved you can't change it");
        var textField = new TextField();
        textField.setPrefColumnCount(12);
        textField.setAlignment(Pos.CENTER_LEFT);
        textField.setOnAction(actionEvent -> {
            root.setBottom(test);
            BorderPane.setAlignment(test, Pos.CENTER);
            textField.setEditable(false);
            textField.setAlignment(Pos.CENTER);
        });
        root.setTop(username);
        BorderPane.setAlignment(username, Pos.CENTER);
        root.setCenter(textField);
        var scene = new Scene(root, 250, 200);
        stage.setScene(scene);
        stage.show();

    }
}

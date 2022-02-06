package javaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class HelloWorldLabel extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("My Fist FX App");
        var root = new BorderPane();
        var helloText = new Label("Hello JLC");
        helloText.setUnderline(true);
        helloText.setTextFill(Color.RED);
        helloText.setFont(Font.font("Verdana", 20));
        root.setCenter(helloText);
        var scene = new Scene(root, 500, 300);
        stage.setScene(scene);
        stage.show();

    }
}

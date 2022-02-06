package javaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloWorldTextArea extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello blablabla");
        var root = new BorderPane();
        var textArea = new TextArea();
        textArea.setPrefColumnCount(12);
        textArea.setPrefRowCount(5);
        textArea.setWrapText(true);
        var printButton = new Button("Print");
        printButton.setOnAction(actionEvent -> System.out.println(textArea.getText()));
        root.setTop(textArea);
        BorderPane.setAlignment(textArea, Pos.CENTER);
        root.setCenter(printButton);
        var scene = new Scene(root,250,300);
        stage.setScene(scene);
        stage.show();

    }
}

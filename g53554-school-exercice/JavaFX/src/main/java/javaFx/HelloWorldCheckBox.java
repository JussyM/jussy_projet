package javaFx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloWorldCheckBox extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JUSSY FX APP");
        var root = new BorderPane();
        var checkBox1 = new CheckBox();
        checkBox1.setText("First");
        checkBox1.setSelected(true);
        var checkBox2 = new CheckBox("snd");
        checkBox2.setIndeterminate(true);
        var checkBox3= new CheckBox("third");
        checkBox3.setAllowIndeterminate(true);
        root.setLeft(checkBox1);
        BorderPane.setAlignment(checkBox1, Pos.CENTER);
        root.setCenter(checkBox2);
        root.setRight(checkBox3);
        BorderPane.setAlignment(checkBox3,Pos.CENTER);
        var scene = new Scene(root,500,300);
        stage.setScene(scene);
        stage.show();

    }
}

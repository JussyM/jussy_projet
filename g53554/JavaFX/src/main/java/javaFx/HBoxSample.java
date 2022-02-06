package javaFx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HBoxSample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("FX APP");
        var root = new VBox(10);
        root.setAlignment(Pos.TOP_LEFT);
        var checkBox1 = new CheckBox();
        checkBox1.setText("First");
        checkBox1.setSelected(true);
        var checkBox2 = new CheckBox("snd");
        checkBox2.setIndeterminate(true);
        var checkBox3= new CheckBox("third");
        checkBox3.setAllowIndeterminate(true);
        root.getChildren().addAll(checkBox1,checkBox2,checkBox3);
        var scene = new Scene(root,250,100);
        stage.setScene(scene);
        stage.show();
    }
}

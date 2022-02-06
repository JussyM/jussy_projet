package javaFx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GridPlaneSample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Jussy FX");
        stage.setMinHeight(300);
        stage.setMinHeight(200);
        var root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setHgap(10);
        root.setVgap(15);
        var course_login = new Label("JavaFX course Login");
        course_login.setFont(Font.font("System", FontWeight.BOLD, 20));
        course_login.setTextFill(Color.RED);
        root.add(course_login, 0, 0, 2, 1);
        GridPane.setHalignment(course_login, HPos.CENTER);
        GridPane.setMargin(course_login, new Insets(0, 0, 10, 0));
        var labelUserName = new Label("User Name or email");
        GridPane.setHalignment(labelUserName, HPos.RIGHT);
        root.add(labelUserName, 0, 1);
        var tfdUserName = new TextField();
        tfdUserName.setPrefColumnCount(20);
        root.add(tfdUserName, 1, 1);
        var labelPasswd = new Label("Password");
        root.add(labelPasswd, 0, 2);
        var password = new PasswordField();
        password.setPrefColumnCount(12);
        root.add(password, 1, 2);
        GridPane.setHalignment(password, HPos.RIGHT);
        GridPane.setFillWidth(password, false);
        var hBox = new HBox(12);
        var buttonLogin = new Button("Login");
        var buttonCancel = new Button("Cancel");
        buttonCancel.setOnAction(actionEvent -> {System.exit(0);});
        hBox.getChildren().addAll(buttonLogin, buttonCancel);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        root.add(hBox, 1, 3);
        GridPane.setMargin(hBox, new Insets(10, 0, 0, 0));

        var scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}

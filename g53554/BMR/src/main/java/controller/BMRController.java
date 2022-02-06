package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import view.View;

public class BMRController {
    private View view;

    /**
     * Constructor of BMRController
     */
    public BMRController() {
        view = new View();
    }

    /**
     * Launch BMR app method
     *
     * @param primaryStage stage of the app
     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calcul BMR");
        primaryStage.setMinHeight(600);
        primaryStage.setMinHeight(300);
        view.initView();
        var handler = new Handler(view);
        handler.addEvenHandler();
        var scene = new Scene(view.getMyVBox());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

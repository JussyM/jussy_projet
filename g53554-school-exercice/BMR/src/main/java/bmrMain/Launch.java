package bmrMain;

import controller.BMRController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launch extends Application {
    /**
     * start Application
     * @param primaryStage stage
     * @throws Exception can be throws
     *
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        var controller = new BMRController();
        controller.start(primaryStage);
    }

    /**
     * Main application
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}

package skyjo;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launch extends Application {
    /**
     *
     * @param stage
     */
    @Override
    public void start(Stage stage) {
        var controller = new Controller("1", "2");
        controller.start(stage);
    }
}

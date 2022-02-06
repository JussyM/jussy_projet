package g53554.humbug.main;

import g53554.humbug.model.Game;
import g53554.humbug.view.jfx.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main method for humbug to run the game
 *
 * @author jj
 */
public class MainHumbug extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("HUMBUG");
        var view = new View();
        var game = new Game();
        game.startLevel(1);
        view.displayBoard(game.getBoard(), game.getAnimals());
        var root = view.midllePane();
        var scene = new Scene(root, 700, 700);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

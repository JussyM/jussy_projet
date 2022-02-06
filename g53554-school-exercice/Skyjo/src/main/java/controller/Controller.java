/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Facade;
import model.Game;
import view.buttonHandler.ButtonHandlers;
import view.viewJfx.SkyjoView;

/**
 * The type Controller.
 *
 * @author jj
 */
public class Controller {
    private final Facade game;
    private final SkyjoView view;

    /**
     * Controller constructor
     *
     * @param idP1 player one id
     * @param idP2 player two id
     */
    public Controller(String idP1, String idP2) {
        game = new Game(idP1, idP2);
        view = new SkyjoView(game);
    }

    /**
     * launch the game
     *
     * @param primaryStage the primary stage
     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SKYJO");
        game.registerObservers(view);
        view.initView(game);
        revealTwoPlayerCards();
        var buttonHandlers = new ButtonHandlers(this);
        buttonHandlers.definedHandlers();
        var root = view.getvBox();
        var scene = new Scene(root, 1200, 700);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        System.out.println("Thread qui lance la partie "+ Thread.currentThread().getName());
        primaryStage.show();
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public Facade getGame() {
        return game;
    }

    /**
     * Gets view.
     *
     * @return the view
     */
    public SkyjoView getView() {
        return view;
    }

    /**
     * reveal aleatory two cards for each player
     */
    private void revealTwoPlayerCards() {
       game.revealCard();
    }

}

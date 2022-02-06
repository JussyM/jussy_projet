package BJPackage.Controller;

import BJPackage.Model.Facade;
import BJPackage.Model.Game;
import BJPackage.View.View;
import BJPackage.View.ViewInterface;

public class Controller {
    private final Facade game;
    private final ViewInterface view;

    /**
     * Controller constructor
     */
    public Controller() {
        this.game = new Game();
        this.view = new View();
    }

    /**
     * Launch the blackjack game
     */
    public void play() {
        view.gameName();
        var mise = view.askBet();
        game.insertBet(mise);
        game.bankBet();
        view.printMsg("La banque mise: "+game.getMise()+" EURO");
        game.shuffleDeckCard();
        game.giveCard();
        do {
            view.displayCard((Game) game);
            var answer = view.askInfo();
            game.decision(answer);
            view.printScore(game.playersScore());
        }
        while (!game.win());
        view.printWinner((Game) game);
        view.printWinnerBet(game.gainCalculation());


    }
}

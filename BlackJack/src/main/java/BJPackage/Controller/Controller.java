package BJPackage.Controller;

import BJPackage.Model.Game;
import BJPackage.View.View;
import BJPackage.View.ViewInterface;

public class Controller {
    private final Game game;
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
        game.getPlayer().insertMise(mise);
        game.miseBank();
        view.printMsg("La banque mise: "+game.getBank().getMise());
        game.shuffleDeckCard();
        game.giveCard();
        do {
            view.displayCard(game);
            var answer = view.askInfo();
            game.decision(answer);
            view.printScore(game.playersScore());

        }
        while (!game.win());
        view.printWinner(game);
        view.printWinnerMise(game.calculDeGain());


    }
}

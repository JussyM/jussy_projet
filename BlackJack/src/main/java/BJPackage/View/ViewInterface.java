package BJPackage.View;

import BJPackage.Model.Card;
import BJPackage.Model.Game;

import java.util.List;

public interface ViewInterface {
    char askInfo();

    Card playerCard(Game game);

    void displayCard(Game game);

    void printMsg(String message);

    int askBet();

    void printWinner(Game game);

    void printWinnerMise(int mise);

    void gameName();

    void printScore(int[] scores);

}

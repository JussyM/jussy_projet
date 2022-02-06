package BJPackage.View;

import BJPackage.Model.*;

import java.util.List;
import java.util.Scanner;

public class View implements ViewInterface {
    /**
     * return the decision of the player
     *
     * @return char
     */
    @Override
    public char askInfo() {
        printMsg("'p' pour choisir une carte ou 's' pour stop");
        return askInfoStrongVersion();
    }

    /**
     * return a card to the player
     *
     * @param game
     * @return Card
     */
    @Override
    public Card playerCard(Game game) {
        return game.askCard();
    }

    /**
     * display each card of the players
     *
     * @param game
     */
    @Override
    public void displayCard(Game game) {
        displayCards(game.getPlayer().getHand(), game.getBank().getHand());

    }

    /**
     * Print message
     *
     * @param message
     */
    @Override
    public void printMsg(String message) {
        System.out.println(message);
    }

    /**
     * ask bet to the player
     *
     * @return Integer
     */
    @Override
    public int askBet() {
        printMsg("Veuillez entrez votre mise: ");
        return returnInt();
    }

    /**
     * print the winner message
     *
     * @param game
     */
    @Override
    public void printWinner(Game game) {
        Player instance;
        if (game.getPlayer().getState() == State.WIN) {
            instance = game.getPlayer();
        } else {
            instance = game.getBank();
        }
        System.out.println(TerminalColor.toCyan("Felicitation to : " + instance.toString()));
    }

    /**
     * print out the winner mise
     *
     * @param mise
     */
    @Override
    public void printWinnerMise(int mise) {
        System.out.println(TerminalColor.toBlue("Le gagnant shop une mise de: " + mise));
    }

    /**
     * game name
     */
    @Override
    public void gameName() {
        System.out.println();
        printMsg(TerminalColor.BLUE_BACKGROUND + "----------------------------------------" + TerminalColor.toDefault);
        printMsg(TerminalColor.BLUE_BACKGROUND + "          WELCOME TO BLACKJACK          " + TerminalColor.toDefault);
        printMsg(TerminalColor.BLUE_BACKGROUND + "----------------------------------------" + TerminalColor.toDefault);
    }

    /**
     * print the score of the bank and the player
     *
     * @param score array of the score
     */
    @Override
    public void printScore(int[] score) {
        printMsg("[" + "Score du joueur principal: " + score[0] + "," + "Score de la banque: " + score[1] + "]");
    }

    /**
     * solid input of integer
     *
     * @return Integer
     */
    private int returnInt() {
        var scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            printMsg("Error");
            scanner.nextInt();
        }
        return scanner.nextInt();
    }

    /**
     * display card method
     */
    private void displayCards(List<Card> playersCard, List<Card> bankCards) {
        printLine(playersCard);
        printMsg("Player Card: ");
        printMsg(playersCard.toString());
        printCards(playersCard);
        printLine(playersCard);
        printLine(playersCard);
        printMsg("Bank Card: ");
        printMsg(bankCards.toString());
        printCards(bankCards);
        printLine(playersCard);


    }

    /**
     * print line for separating cards
     *
     * @param list
     */
    private void printLine(List<Card> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("----------------");
        }
        System.out.println();
    }

    /**
     * assign card
     *
     * @param cardList
     */
    private void printCards(List<Card> cardList) {
        var indice = 1;
        var string = "";
        while (indice <= 5) {
            for (Card card : cardList) {
                string = printCard(card, indice);
                System.out.print(string);
            }
            System.out.println();
            indice++;
        }
    }

    /**
     * assign the card representation into string
     *
     * @param card   the card given as arguments
     * @param indice for each card the indice
     * @return card string version
     */
    private String printCard(Card card, int indice) {
        var emoji = "";
        var string = "";
        switch (card.getColor()) {
            case CLUB -> emoji = Color.CLUB.getEmoji();
            case HEART -> emoji = Color.HEART.getEmoji();
            case SPADE -> emoji = Color.SPADE.getEmoji();
            case DIAMOND -> emoji = Color.DIAMOND.getEmoji();
        }
        var cardValue = card.getValue().getValue();
        switch (indice) {
            case 1, 5 -> string = TerminalColor.GREEN_BACKGROUND + "------" + "  " + TerminalColor.toDefault;
            case 2, 4 -> string = TerminalColor.GREEN_BACKGROUND + "|" + emoji + "  " + emoji + "|" + "  "
                    + TerminalColor.toDefault;
            case 3 -> {
                if (cardValue >= 10) {
                    string = TerminalColor.GREEN_BACKGROUND + "| " + cardValue + " |" + "  " + TerminalColor.toDefault;
                } else {
                    string = TerminalColor.GREEN_BACKGROUND + "| " + cardValue + "  |" + "  " + TerminalColor.toDefault;
                }
            }

        }
        return string;
    }

    /**
     * ask the strong version of the char
     *
     * @return char
     */
    private char askInfoStrongVersion() {
        var scanner = new Scanner(System.in);
        var in = scanner.nextLine();
        while (in.charAt(0) != 'p' && in.charAt(0) != 's') {
            printMsg("un seul caractère pour les entrée ou invalide");
            in = scanner.nextLine();
        }
        return in.charAt(0);
    }
}

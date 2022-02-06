package BJPackage.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Deck {
    private final List<Card> cardList;

    /**
     * Constructor for deck
     */
    public Deck() {
        cardList = new ArrayList<>();
        Value[] values = Value.values();
        IntStream.range(0, values.length).forEachOrdered(i -> {
            IntStream.range(0,Color.values().length).forEachOrdered(j->{
                cardList.add(new Card(Color.values()[j],values[i]));});
        });
    }

    /**
     * getter for cardList
     *
     * @return List
     */
    public List<Card> getCardList() {
        return cardList;
    }

    /**
     * shuffle the card in the list
     */
    public void shuffle() {
        Collections.shuffle(cardList);
    }

    /**
     * @return  boolean if empty or not
     */
    public boolean isEmpty() {
        return cardList.isEmpty();
    }

    /**
     * return the first card of the list
     * @return Card
     */
    public Card hit() {
        return getCard();
    }

    /**
     * remove a card from the list the first card
     * @param card
     */
    public void remove(Card card) {
        cardList.remove(card);
    }

    /**
     * getter for list card
     * @return fist card
     */
    private Card getCard() {
        return cardList.get(0);
    }

    /**
     * toString for the list
     * @return string
     */
    @Override
    public String toString() {
        return "Liste des cartes du paquet : \n" + cardList.toString();
    }
}

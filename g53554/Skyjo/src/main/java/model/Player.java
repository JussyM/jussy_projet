/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Player.
 *
 * @author jj
 */
public class Player {
    private final List<Card> hand;
    private final String id;
    private int score;
    private Card selected;
    private State state;

    /**
     * Gets hand.
     *
     * @return hand hand
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * Gets score.
     *
     * @return score score
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets id.
     *
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets card at.
     *
     * @param index the index
     * @return card at
     */
    public Card getCardAt(int index) {
        return hand.get(index);
    }

    /**
     * Instantiates a new Player.
     *
     * @param id the id
     */
    public Player(String id) {
        this.id = id;
        hand = new ArrayList<>();
        selected = null;
        state = State.PLAYING;
    }

    /**
     * getter for the player state
     * @return state
     */
    public State getState() {
        return state;
    }

    /**
     * setter for state
     * @param state the state given as argument
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Add all.
     *
     * @param cards the cards
     */
    public void addAll(Card... cards) {
        hand.addAll(List.of(cards));

    }

    /**
     * Add.
     *
     * @param card the card
     */
    public void add(Card card) {
        hand.add(card);
    }

    /**
     * return the score of the player
     */
    public void updateScore() {
        this.score = hand.stream().mapToInt(x -> !x.isHide() ? x.getValues().getValue() : 0).sum();
    }

    /**
     * Gets selected.
     *
     * @return the selected
     */
    public Card getSelected() {
        if (selected == null) throw new NullPointerException("Card selected is null");
        return selected;
    }

    /**
     * Sets selected.
     *
     * @param selected the selected
     */
    public void setSelected(Card selected) {
        this.selected = Objects.requireNonNull(selected, "Card selected should not be null");
    }

    /**
     * Equal from the mother class Object
     *
     * @param o object given as argument
     * @return boolean true if two object are corect
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return getScore() == player.getScore() && Objects.equals(getHand(), player.getHand())
                && Objects.equals(getId(), player.getId()) && Objects.equals(getSelected(), player.getSelected());
    }

    /**
     * class hashCode
     *
     * @return integer
     */
    @Override
    public int hashCode() {
        return Objects.hash(getHand(), getId(), getScore(), getSelected());
    }

    /**
     * All card reveal boolean.
     *
     * @return the boolean
     */
    public boolean allCardReveal() {
        var index = (int) hand.stream().filter(i -> !i.isHide()).count();
        return index == hand.size();
    }
}

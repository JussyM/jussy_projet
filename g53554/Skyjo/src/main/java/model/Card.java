/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 * The type Card.
 *
 * @author jj
 */
public class Card {
    private Value values;
    private boolean hide;


    /**
     * Instantiates a new Card.
     *
     * @param values the values
     */
    public Card(Value values) {
        this.values = values;
        this.hide = true;
    }

    /**
     * getter for values
     *
     * @return int (Valuess)
     */
    public Value getValues() {
        return values;
    }


    /**
     * Is hide boolean.
     *
     * @return the boolean
     */
    public boolean isHide() {
        return hide;
    }


    /**
     * Sets hide.
     *
     * @param hide the hide
     */
    public void setHide(boolean hide) {
        this.hide = hide;
    }

    private void setValues(Value values) {
        this.values = values;
    }

    /**
     * Sets cart state.
     *
     * @param values the values
     * @param hide   the hide
     */
    public void setCartState(Value values, boolean hide) {
        setValues(values);
        setHide(hide);
    }

    /**
     * Equals method inherited from Object class
     *
     * @param o Mother class Object
     * @return boolean true if two card are equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getValues() == card.getValues() && isHide() == card.isHide();
    }

    /**
     * HashCode for Card
     *
     * @return integer
     */
    @Override
    public int hashCode() {
        return Objects.hash(getValues(), isHide());
    }
}


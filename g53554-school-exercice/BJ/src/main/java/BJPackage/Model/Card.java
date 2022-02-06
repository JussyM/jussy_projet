package BJPackage.Model;

import java.util.Objects;

public class Card {
    private Color color;
    private Value value;

    /**
     * getter for color
     *
     * @return color
     */

    public Color getColor() {
        return color;
    }

    /**
     * getter for value
     *
     * @return value
     */
    public Value getValue() {
        return value;
    }

    /**
     * constructor for Card
     *
     * @param color
     * @param value
     */
    public Card(Color color, Value value) {
        this.color = Objects.requireNonNull(color,"Colors non valable");
        this.value = Objects.requireNonNull(value,"Value non initialiser");
    }

    /**
     * return the card into String
     *
     * @return string
     */
    @Override
    public String toString() {
        return value.name() + " de " + color.getName();
    }
}

package Model.Cards;

import Model.Color;
import Model.Position;
import java.util.Arrays;
import java.util.Objects;

public class Card {

    private Color cardColor;
    private Position cardPosition;
    private int[] cardValue;
    private boolean hidden;

    /**
     *
     * @param cardColor
     * @param cardPosition
     */
    public Card(Color cardColor, Position cardPosition) {
        this.cardColor = cardColor;
        this.cardPosition = cardPosition;
        cardValue = cardValueInitialized();
        this.hidden = true;
    }

    /**
     *
     * @return
     */
    private int[] cardValueInitialized() {
        int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        return value;
    }

    /**
     *
     */
    public void reveal() {
        this.hidden = false;
    }

    /**
     *
     * @return
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     *
     * @return
     */
    public Color getCardColor() {
        return cardColor;
    }

    /**
     *
     * @return
     */
    public Position getCardPosition() {
        return cardPosition;
    }

    /**
     *
     * @return
     */
    public int[] getCardValue() {
        return cardValue;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.cardColor);
        hash = 97 * hash + Objects.hashCode(this.cardPosition);
        hash = 97 * hash + Arrays.hashCode(this.cardValue);
        hash = 97 * hash + (this.hidden ? 1 : 0);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.hidden != other.hidden) {
            return false;
        }
        if (this.cardColor != other.cardColor) {
            return false;
        }
        if (!Objects.equals(this.cardPosition, other.cardPosition)) {
            return false;
        }
        return Arrays.equals(this.cardValue, other.cardValue);
    }

}

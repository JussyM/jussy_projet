package Model;

public abstract class ColoredShape implements Shape {
    private char color;

    /**
     * Colored shape constructor
     *
     * @param color of the shape
     */
    public ColoredShape(char color) {
        this.color = color;
    }

    /**
     * return true if a point is inside the shape or not
     *
     * @param point given as argument
     * @return true or false
     */
    public abstract boolean isInside(Point point);

    /**
     * return the color of the shape
     *
     * @return color of shape
     */
    @Override
    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    /**
     * ColoredShape String version
     *
     * @return string version
     */
    public String toString() {
        return "Color: " + color;
    }
}

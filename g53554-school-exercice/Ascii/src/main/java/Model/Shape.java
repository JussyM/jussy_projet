package Model;

public interface Shape {
    /**
     * if a point is inside of not
     *
     * @param point given as argument
     * @return boolean
     */
    boolean isInside(Point point);

    /**
     * move the shape from a point to the other
     *
     * @param dx x argument for moving
     * @param dy y argument for moving
     */
    void move(double dx, double dy);

    /**
     * return the color of the shape
     *
     * @return color
     */
    char getColor();

    void setColor(char color);

}

package Model;

public class Rectangle extends ColoredShape {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Constructor for rectangle
     *
     * @param upperLeft point
     * @param width     for the rectangle
     * @param height    for the rectangle
     * @param color     the color of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        if (width < 0 || height < 0) throw new IllegalArgumentException("Negative values: " + width + " " + height);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;

    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * return true if a point is inside the rectangle
     *
     * @param point as argument for check up
     * @return true if inside false if not
     */
    @Override
    public boolean isInside(Point point) {
        return (point.getX() > upperLeft.getX() && point.getX() <= upperLeft.getX() + height)
                && (point.getY() > upperLeft.getY() && point.getY() <= upperLeft.getY() + width);
    }

    /**
     * move the point inside the rectangle
     *
     * @param dx argument for the move
     * @param dy argument for the move
     */
    @Override
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

    @Override
    public String toString() {
        return "RECTANGLE {" +
                "upperLeft{" + getUpperLeft().getX() + " " + getUpperLeft().getY() + '}' +
                ", width= " + this.width + ", height= " + this.height +
                '}' + ' ' + super.toString();
    }
}

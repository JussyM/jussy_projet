package Model;

public class Square extends ColoredShape {
    private double side;
    private Point upperLeft;

    /**
     * Constructor for the square
     *
     * @param side      of the square
     * @param upperLeft point of the square
     * @param color     color of the square
     */
    public Square(double side, Point upperLeft, char color) {
        super(color);
        if (side < 0) throw new IllegalArgumentException("Negative values: " + side);
        this.side = side;
        this.upperLeft = upperLeft;

    }

    @Override
    public boolean isInside(Point point) {
        return (point.getX() > upperLeft.getX() && point.getX() <= upperLeft.getX() + side)
                && (point.getY() > upperLeft.getY() && point.getY() <= upperLeft.getY() + side);
    }

    @Override
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

    public double getSide() {
        return side;
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    @Override
    public String toString() {
        return "SQUARE{" +
                "upperLeft{" + getUpperLeft().getX() + ',' + getUpperLeft().getY() + '}' +
                ", side=" + this.side +
                '}' + ' ' + super.toString();
    }
}

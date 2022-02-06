package Model;

public class Line extends ColoredShape {
    private Point begin;
    private Point end;

    /**
     * Colored shape constructor
     *
     * @param color of the shape
     */
    public Line(char color, Point begin, Point end) {
        super(color);
        this.begin = begin;
        this.end = end;

    }

    /**
     * return true if a point is inside a line
     *
     * @param point given as argument
     * @return true of false
     */
    @Override
    public boolean isInside(Point point) {
        var x1 = begin.getX();
        var y1 = begin.getY();
        var x2 = end.getX();
        var y2 = end.getY();
        var x = point.getX();
        var y = point.getY();
        if (valid(x1, y1, x2, y2, x, y)) {
            return correct(x1, y1, x2, y2, x, y);
        }
        return false;
    }

    /**
     * @param dx x argument for moving
     * @param dy y argument for moving
     */
    @Override
    public void move(double dx, double dy) {
        begin.move(dx, dy);
        end.move(dx, dy);

    }

    /**
     * return true if the vales are valid
     *
     * @param x1 point begin x value
     * @param y1 point begin y value
     * @param x2 point end x value
     * @param y2 point end y value
     * @param x  other point x value
     * @param y  other point y value
     * @return true if point is valid or not
     */
    private boolean valid(double x1, double y1, double x2, double y2, double x, double y) {
        return ((x1 >= x && x >= x2) || (x2 >= x && x >= x1)) && ((y1 >= y && y >= y2) || (y2 >= y && y >= y1));
    }

    /**
     * return true if the point is inside the line or not
     *
     * @param x1 point begin x value
     * @param y1 point begin y value
     * @param x2 point end x value
     * @param y2 point end y value
     * @param x  other point x value
     * @param y  other point y value
     * @return true if the point is inside
     */
    private boolean correct(double x1, double y1, double x2, double y2, double x, double y) {
        var c1 = ((y1 - y2 * x) + (x2 - x1 * y) + ((x1 * y2) - (x2 * y1)));
        var c2 = Math.sqrt((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
        return (1 > c1 / c2) && (-1 < c1 / c2);


    }

    /**
     * String line version
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Line{" +
                "begin{ " + begin.getX() + ' ' + begin.getX() + ' ' + '}' +
                ", end{ " + end.getX() + ' ' + end.getY() + ' ' + '}' +
                '}' + ' ' + super.toString();
    }
}

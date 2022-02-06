package Model;

public class Point {
    private double x;
    private double y;

    /**
     * constructor for point
     *
     * @param x argument to construct the point
     * @param y argument to construct the point
     */
    public Point(double x, double y) {
        if (x < 0 || y < 0) throw new IllegalArgumentException("Negative value not allow " + x + " " + y);
        this.x = x;
        this.y = y;
    }

    /**
     * move the point from a point to the other
     *
     * @param dx move x argument
     * @param dy move y argument
     */
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * getter for X
     *
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * getter for y
     *
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * return the distance between two point
     *
     * @param other is the second point
     * @return distance between two point
     */
    public double distanceTo(Point other) {
        return Math.sqrt(mathPwResult(other));
    }

    /**
     * calculate the the power between the two point
     *
     * @param point the second point
     * @return math power between two point
     */
    private double mathPwResult(Point point) {
        return Math.pow((this.x - point.getX()), 2) + Math.pow((this.y - point.getY()), 2);
    }
}

package Model;

import java.util.Objects;

public class Circle extends ColoredShape {
    private Point center;
    private double radius;

    /**
     * Circle constructor
     *
     * @param center the center of the circle represented by a type Point
     * @param radius the radius of the circle
     * @param color  the drawing color of the circle
     */
    public Circle(Point center, double radius, char color) {
        super(color);
        if (radius < 0) throw new IllegalArgumentException("Rayon Negatif");
        this.center = Objects.requireNonNull(center, "Centre de circle null");
        this.radius = radius;
    }

    /**
     * return true if point is inside
     *
     * @param point the point for checkup
     * @return true if inside and false if not
     */

    @Override
    public boolean isInside(Point point) {
        return center.distanceTo(point) <= radius;
    }

    /**
     * Move the circle from one point to the other
     *
     * @param dx move x argument
     * @param dy move y argument
     */
    @Override
    public void move(double dx, double dy) {
        center.move(dx, dx);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center{" + center.getX() + " " + center.getY() + '}' +
                ", radius=" + radius +
                '}' + ' ' + super.toString();
    }
}

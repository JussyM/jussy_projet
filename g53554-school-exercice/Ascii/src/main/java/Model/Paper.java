package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paper implements PaperInterface {
    public static final int DEFAULT_WIDTH = 50;
    public static final int DEFAULT_HEIGHT = 50;
    private final List<ColoredShape> shapes;
    private final int width;
    private final int height;

    /**
     * add a shape to shapeList
     * @param shape the shape to the list
     */
    @Override
    public void addSharpe(ColoredShape shape) {
        Objects.requireNonNull(shape, "Shape is null");
        shapes.add(shape);
    }

    /**
     * return a shape at a given position
     * @param point given as argument
     * @return a shape
     */
    @Override
    public Shape getShapeAt(Point point) {
        for (Shape s : shapes) {
            if (s.isInside(point)) {
                return s;
            }
        }
        return null;
    }

    /**
     * return the height
     * @return height
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * return the width
     * @return width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * return the shape list
     * @return shapes
     */
    @Override
    public List<ColoredShape> getShapes() {
        return shapes;
    }

    /**
     * the paper constructor
     * @param width of the paper
     * @param height of the paper
     */
    public Paper(int width, int height) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("The paper length must not be negative" + width + " " + height);
        this.width = width;
        this.height = height;
        this.shapes = new ArrayList<>();
    }

    /**
     * default constructor of paper
     */
    public Paper() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    /**
     * toString of each shape on the paper
     * @return string representation of the shapes
     */
    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        for (var row = 0; row < getHeight(); row++) {
            for (var column = 0; column < getWidth(); column++) {
                var point = new Point(row, column);
                var shape = getShapeAt(point);
                var color = '0';
                if (shape != null) {
                    color = shape.getColor();
                }
                stringBuilder.append(color);

            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}

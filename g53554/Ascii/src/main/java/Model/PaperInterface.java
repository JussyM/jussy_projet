package Model;

import java.util.List;

public interface PaperInterface {
    /**
     * header for adding a shape to the shape list
     * @param shape that has to be added to the list
     */
    void addSharpe(ColoredShape shape);

    /**
     * return a shape at a given point
     * @param point as argument
     * @return shape at the point
     */
    Shape getShapeAt(Point point);

    /**
     * getter for height
     * @return height
     */
    int getHeight();

    /**
     * getter for width
     * @return width
     */
    int getWidth();

    /**
     * the shape list getter for shapes
     * @return shapes
     */
    List<ColoredShape> getShapes();


}

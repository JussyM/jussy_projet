package Model;

import java.util.Objects;

public class GroupShapes extends ColoredShape{
    private final ColoredShape shapeUno;
    private final ColoredShape shapeDos;

    /**
     * Colored shape constructor
     */
    public GroupShapes(ColoredShape shapeUno, ColoredShape shapeDos) {
        super('G');
        Objects.requireNonNull(shapeUno, "First Shape null");
        Objects.requireNonNull(shapeDos, "Second shape null");
        this.shapeUno = shapeUno;
        this.shapeDos = shapeDos;
    }

    @Override
    public boolean isInside(Point point) {
        return shapeDos.isInside(point) || shapeUno.isInside(point);
    }

    @Override
    public void move(double dx, double dy) {
        shapeUno.move(dx, dy);
        shapeDos.move(dx, dy);
    }

    @Override
    public String toString() {
        return "GroupShapes{" +
                "shapeUno=" + shapeUno.toString() +
                ", shapeDos=" + shapeDos.toString() +
                '}';
    }
}

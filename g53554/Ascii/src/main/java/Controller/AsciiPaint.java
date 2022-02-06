package Controller;

import Model.*;
import View.PaperView;

public class AsciiPaint {
    private final PaperInterface paper;
    private final PaperView paperDrawing;
    private boolean end;

    /**
     * Default constructor for asciiPaint controller
     */
    public AsciiPaint() {
        paper = new Paper();
        paperDrawing = new PaperView();
        end = false;
    }

    /**
     * Constructor with argument
     *
     * @param width  of the paper
     * @param height of the paper
     */
    public AsciiPaint(int width, int height) {
        paper = new Paper(width, height);
        paperDrawing = new PaperView();
        end = false;
    }

    /**
     * Creat a new object Square
     *
     * @param x     for the point object
     * @param y     for the point object
     * @param side  of the square
     * @param color color of the square
     */
    private void newSquare(int x, int y, double side, char color) {
        paper.addSharpe(new Square(side, new Point(x, y), color));
    }

    /**
     * @param x      for the creation of the upperLeft Point
     * @param y      for the creation of the upperLeft Point
     * @param width  the longest side of the rectangle
     * @param height the shotest side of the rectangle
     * @param color  color of the rectangle
     */
    private void newRectangle(int x, int y, double width, double height, char color) {
        paper.addSharpe(new Rectangle(new Point(x, y), width, height, color));
    }

    /**
     * Creat a new object of circle
     *
     * @param x      argument for center object
     * @param y      argument for center object
     * @param radius of the circle
     * @param color  color of the circle
     */
    private void newCircle(int x, int y, double radius, char color) {
        paper.addSharpe(new Circle(new Point(x, y), radius, color));
    }

    /**
     * Main method to begin the drawing
     */
    public void start() {
        String input;
        do {
            input = paperDrawing.askShapes();
            action(input);
        } while (!end);
        paperDrawing.printShape(paper);
    }

    /**
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param color
     */
    private void newLine(int x1, int y1, int x2, int y2, char color) {
        paper.addSharpe(new Line(color, new Point(x1, y1), new Point(x2, y2)));
    }

    /**
     * @param index
     * @param x
     * @param y
     */
    private void moveShape(int index, int x, int y) {
        paper.getShapes().get(index).move(x, y);
    }

    /**
     * @param index
     * @param color
     */
    private void setShapeColor(int index, char color) {
        paper.getShapes().get(index).setColor(color);
    }

    /**
     * @param index
     */
    private void delectShape(int index) {
        paper.getShapes().remove(index);
    }

    /**
     * @param indexUno
     * @param indexDos
     */
    private void groupShape(int indexUno, int indexDos) {
        paper.addSharpe(new GroupShapes(paper.getShapes().get(indexUno), paper.getShapes().get(indexDos)));
        delectShape(indexUno);
        delectShape(indexUno);
    }

    private void displayShapes() {
        paperDrawing.displayShapeList(paper.getShapes());
    }

    /**
     * Appply the appropriate action according to the user input
     *
     * @param input of the user
     */
    private void action(String input) {
        int[] in = paperDrawing.stringConvertToInt(input);
        var color = input.charAt(input.length() - 1);
        String[] strings = input.split(" ");
        var string = "";
        if (!strings[0].equals("add")) {
            string = strings[0];

        } else {
            string = strings[1];
        }
        switch (string) {
            case "rectangle" -> newRectangle(in[0], in[1], in[2], in[3], color);
            case "square" -> newSquare(in[0], in[1], in[2], color);
            case "circle" -> newCircle(in[0], in[1], in[2], color);
            case "line" -> newLine(in[0], in[1], in[2], in[3], color);
            case "show" -> end = true;
            case "list" -> displayShapes();
            case "move" -> moveShape(in[0], in[1], in[2]);
            case "group" -> groupShape(in[0], in[1]);
            case "delect" -> delectShape(in[0]);
            case "color" -> setShapeColor(in[0], strings[strings.length - 1].charAt(0));
            default -> paperDrawing.printMessage("Element non prise en compte...");

        }
    }

}

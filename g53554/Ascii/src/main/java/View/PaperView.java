package View;

import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaperView {
    private static final int default_Input_Size_1 = 1;
    private static final int default_Input_Size_2 = 2;
    private static final int default_Input_Size_3 = 3;
    private static final int default_Input_Size_4 = 4;

    /**
     * ask the shape for the user to be added inside the list
     *
     * @return the input of the user String type
     */
    public String askShapes() {
        System.out.println("Taper 'add' ou 'show' pour afficher les formes suivi de la figure voulu: ");
        var input = new Scanner(System.in);
        var string = input.nextLine();
        while (!correctInput(string)) {
            System.out.println("Input Incorrect retry...");
            string = input.nextLine();
        }
        return string;
    }

    /**
     * return true if the input is correct
     *
     * @param input user input
     * @return boolean
     */
    private boolean correctInput(String input) {
        var split = input.split(" ");
        return match(input, split);
    }

    /**
     * return true if the input match with the regex
     *
     * @param split user input turn into split
     * @return boolean
     */
    private boolean match(String input, String[] split) {
        var size = stringConvertToInt(input);
        if (isInside(cmd(), split[0])) {
            String form = "";
            if (split.length > 1) form = split[1];
            switch (split[0]) {
                case "add" -> {
                    if (isInside(shapes(), form)) {
                        return switch (form) {
                            case "rectangle", "line" -> size.length == default_Input_Size_4
                                    && split[split.length - 1].matches("\\p{Alnum}");
                            case "square", "circle" -> size.length == default_Input_Size_3
                                    && split[split.length - 1].matches("\\p{Alnum}");
                            default -> false;
                        };

                    }

                }
                case "move" -> {
                    if (size.length == default_Input_Size_3) return true;
                }
                case "group" -> {
                    if (size.length == default_Input_Size_2) return true;
                }
                case "color" -> {
                    if (size.length == default_Input_Size_1 && split.length == default_Input_Size_3)
                        return true;
                }
                case "delect" -> {
                    if (size.length == default_Input_Size_1) return true;
                }
                case "list" , "show"-> {
                    return true;
                }
            }

        }
        return false;

    }

    /**
     * Return an array of all the available command allow
     *
     * @return array of command (String)
     */
    private String[] cmd() {
        return new String[]{"add", "show", "group", "list", "move", "delect", "color"};
    }

    /**
     * return an array of shapes String version
     *
     * @return array of shapes (String)
     */
    private String[] shapes() {
        return new String[]{"rectangle", "square", "circle", "line"};
    }

    /**
     * @param elements array of string that is given for checkup
     * @param input    the string input for checkup
     * @return true if inside the array and false if not
     */
    private boolean isInside(String[] elements, String input) {
        for (String string : elements) {
            if (input.equals(string)) {
                return true;
            }
        }
        return false;
    }

    /**
     * convert the string input into integer type if present
     *
     * @param input of the user
     * @return array of int
     */
    public int[] stringConvertToInt(String input) {
        var list = new ArrayList<>();
        String[] split = input.split(" ");
        for (String current : split) {
            try {
                int parsedInt = Integer.parseInt(current);
                list.add(parsedInt);
            } catch (NumberFormatException ignored) {
            }
        }
        int[] result = new int[list.size()];
        for (int index = 0; index < list.size(); index++) {
            result[index] = (int) list.get(index);
        }
        return result;


    }

    /**
     * print the shape
     *
     * @param paper that contain the shape for printing
     */
    public void printShape(PaperInterface paper) {
        System.out.println(paper.toString());
    }


    /**
     * print message given as argument
     *
     * @param message for print
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void displayShapeList(List<ColoredShape> shapeList) {
        for (var index = 0; index < shapeList.size(); index++) {
            System.out.println(index + " -" + " " + shapeList.get(index).toString());
        }
    }
}

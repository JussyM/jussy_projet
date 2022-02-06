package g53554.humbug.view.console;

import g53554.humbug.designPattern.Observer;
import g53554.humbug.model.*;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Here is the game view contains all the method that help us to see what we
 * playing as game
 *
 * @author jj
 */
public class View extends Observer implements InterfaceView {

    /**
     * Display The board of the game according to the level
     *
     * @param board   of the game
     * @param animals arrays that contain all the animal of the game
     */
    @Override
    public void displayBoard(Board board, Animal... animals) {
        String[][] boardArrays = boardExtend(initBoard(board, animals), board);
        printColIndex(boardArrays[0]);
        System.out.println();
        printLine(boardArrays[0]);
        System.out.println();
        displayBoardMethod(boardArrays);

    }

    /**
     * DisplayBoard Code contain all the way to display each square according to
     * their specificity
     *
     * @param boardArrays is the board of the game converted to arrays of String
     *                    for the print
     */
    private void displayBoardMethod(String[][] boardArrays) {
        int line;
        var endLine = 2;
        for (line = 0; line < boardArrays.length; line++) {
            for (int col = 0; col < boardArrays[line].length; col++) {
                if (!emptyBoard(boardArrays[line], "nothing")) {
                    switch (boardArrays[line][col]) {
                        case "gr":
                        case "grass_t":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "gr_w":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#  }" + TerminalColor.toDefault);
                            break;
                        case "gr_e":
                            System.out.print(
                                    TerminalColor.GREEN_BACKGROUND
                                            + "{  #}" + TerminalColor.toDefault);
                            break;
                        case "st":
                            System.out.print(TerminalColor.YELLOW_BACKGROUND
                                    + "{ * }" + TerminalColor.toDefault);
                            break;
                        case "sn":
                            System.out.print(TerminalColor.GREEN_BACKGROUND
                                    + "{ E }" + TerminalColor.toDefault);
                            break;
                        case "sn_w":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#E }" + TerminalColor.toDefault);
                            break;
                        case "sn_e":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{ E#}" + TerminalColor.toDefault);
                            break;
                        case "sp":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{ A }" + TerminalColor.toDefault);
                            break;
                        case "sp_w":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#A }" + TerminalColor.toDefault);
                            break;
                        case "sp_e":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{ A#}" + TerminalColor.toDefault);
                            break;
                        case "gh":
                            System.out.print(TerminalColor.GREEN_BACKGROUND
                                    + "{ G }" + TerminalColor.toDefault);
                            break;
                        case "gh_w":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#G }" + TerminalColor.toDefault);
                            break;
                        case "gh_e":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{ G#}" + TerminalColor.toDefault);
                            break;
                        case "lb":
                            System.out.print(TerminalColor.GREEN_BACKGROUND
                                    + "{ L }" + TerminalColor.toDefault);
                            break;
                        case "lb_w":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#L }" + TerminalColor.toDefault);
                            break;
                        case "lb_e":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{ L#}" + TerminalColor.toDefault);
                            break;
                        case "bb":

                            System.out.print(TerminalColor.GREEN_BACKGROUND
                                    + "{ B }" + TerminalColor.toDefault);
                            break;
                        case "bb_w":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#B }" + TerminalColor.toDefault);
                            break;
                        case "bb_r":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{ B#}" + TerminalColor.toDefault);
                            break;
                        case "bu":
                            System.out.print(TerminalColor.GREEN_BACKGROUND
                                    + "{ P }" + TerminalColor.toDefault);
                            break;
                        case "bu_w":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#P }" + TerminalColor.toDefault);
                            break;
                        case "bu_r":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{ P#}" + TerminalColor.toDefault);
                            break;

                        case "st_w":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{#* }" + TerminalColor.toDefault);
                            break;
                        case "st_e":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ *#}" + TerminalColor.toDefault);
                            break;
                        case "grass_t_n":
                            System.out.print(TerminalColor.GREEN_BACKGROUND
                                    + "{ # }" + TerminalColor.toDefault);
                            break;

                        case "st_b":
                            System.out.print(
                                    TerminalColor.YELLOW_BACKGROUND
                                            + "{#*#}" + TerminalColor.toDefault);
                            break;
                        case "gr_b":
                            System.out.print(TerminalColor.GREEN_BACKGROUND
                                    + "{# #}" + TerminalColor.toDefault);
                            break;
                        case "sn_b":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#E#}" + TerminalColor.toDefault);
                            break;

                        case "sp_b":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#A#}" + TerminalColor.toDefault);
                            break;

                        case "gh_b":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#G#}" + TerminalColor.toDefault);
                            break;

                        case "lb_b":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#L#}" + TerminalColor.toDefault);

                        case "bb_b":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#B#}" + TerminalColor.toDefault);
                            break;

                        case "bu_b":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.GREEN_BACKGROUND
                                    + "{#P#}" + TerminalColor.toDefault);
                        default:
                            System.out.print(TerminalColor.WHITE_BACKGROUND
                                    + "     " + TerminalColor.toDefault);
                            break;

                    }
                    if (col == boardArrays[0].length - 1 && line == endLine) {
                        System.out.println();
                        printLine(boardArrays[0]);
                        System.out.println();
                        endLine += 3;

                    } else if (col == boardArrays[0].length - 1
                            && line != endLine) {
                        printLineIndex(line);
                        System.out.println();
                    }

                }

            }

        }

    }

    /**
     * Print the endLine
     *
     * @param boardArray board use as reference for the printing
     */
    private void printLine(String[] boardArray) {
        int i = 0;
        while (i < boardArray.length) {
            System.out.print("-----");
            i++;
        }
    }

    /**
     * verify if the board given as an argument is empty or not if yes nothing
     * need to be printOut
     *
     * @param boardArrays will be the arrays use for verification
     * @return boolean true if empty false if not
     */
    private boolean emptyBoard(String[] boardArrays, String string) {
        var i = 0;
        while (i < boardArrays.length && boardArrays[i].equals(string)) {
            i++;
        }
        return i == boardArrays.length;
    }

    /**
     * print each line index
     *
     * @param col here is the column index use to know in which line we are
     */
    private void printLineIndex(int col) {
        switch (col) {
            case 1:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 0);
                break;
            case 4:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 1);
                break;
            case 7:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 2);
                break;
            case 10:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 3);
                break;
            case 13:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 4);
                break;
            case 16:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 5);
                break;
            case 19:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 6);
                break;
            case 22:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 7);
                break;
            case 25:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 8);
                break;
            case 28:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 9);
                break;
            case 31:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 10);
                break;

        }

    }

    /**
     * return the correct square Position of the board
     *
     * @param row of the board
     * @param col of the board
     * @return the real position of the board
     */
    private Position squareCorrectPos(int row, int col) {
        switch (row) {
            case 1:
                row = 0;
                return new Position(row, col);
            case 4:
                row = 1;
                return new Position(row, col);
            case 7:
                row = 2;
                return new Position(row, col);
            case 10:
                row = 3;
                return new Position(row, col);
            case 13:
                row = 4;
                return new Position(row, col);
            case 16:
                row = 5;
                return new Position(row, col);
            case 19:
                row = 6;
                return new Position(row, col);
            case 22:
                row = 7;
                return new Position(row, col);
            case 25:
                row = 8;
                return new Position(row, col);
            case 28:
                row = 9;
                return new Position(row, col);
            case 31:
                row = 10;
                return new Position(row, col);

        }
        return null;
    }

    /**
     * Print each column position
     *
     * @param board use the arrays of string as ref to print the column index
     */
    private void printColIndex(String[] board) {
        for (var i = 0; i < board.length; i++) {
            System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                    + TerminalColor.toDefault, i);

        }

    }

    /**
     * Turn the board into a String arrays and assigned each square names
     *
     * @param board   of the game
     * @param animals of the game
     * @return new String board
     */
    private String[][] initBoard(Board board, Animal... animals) {
        String[][] boardArrays = new String[board.getNbRow()][board
                .getNbColumn()];
        for (var row = 0; row < boardArrays.length; row++) {
            for (var col = 0; col < boardArrays[row].length; col++) {
                Position position = new Position(row, col);
                boolean animalIsPresent = animalIsPresent(position, animals);

                assignedSquareName(board, boardArrays, position, animalIsPresent,
                        row, col,
                        animals);

            }

        }
        return boardArrays;
    }

    /**
     * Insert each square sigle according to the position with a board with or
     * without wall
     *
     * @param board           of the game
     * @param boardArrays     arrays of String that will printOut the game
     * @param position        each square position
     * @param animalIsPresent boolean that determine if animal is present or not
     * @param row             position row
     * @param col             position column
     * @param animals         arrays that contain all the animal of the game
     */
    private void assignedSquareName(Board board, String[][] boardArrays,
                                    Position position,
                                    boolean animalIsPresent, int row, int col, Animal... animals) {
        if (board.isInside(position)
                && board.getSquareType(position) == SquareType.STAR) {
            boardArrays[row][col] = "st";
        } else if (board.isInside(position)
                && board.getSquareType(position) == SquareType.GRASS
                && !animalIsPresent) {
            boardArrays[row][col] = "gr";

        } else if (board.isInside(position)
                && board.getSquareType(position) == SquareType.GRASS
                && animalIsPresent) {
            for (Animal animal1 : animals) {
                if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Snail) {
                    boardArrays[row][col] = "sn";
                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Spider) {
                    boardArrays[row][col] = "sp";
                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Grasshopper) {
                    boardArrays[row][col] = "gh";

                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Ladybird) {
                    boardArrays[row][col] = "lb";
                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Bumbelbee) {
                    boardArrays[row][col] = "bb";

                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Butterfly) {
                    boardArrays[row][col] = "bu";

                }
            }
        } else {
            boardArrays[row][col] = "null";
        }

    }

    /**
     * Extend The String Board From (line x column) size to ((line x 4)x column)
     * size
     *
     * @param sBoard the initial String board of the game
     * @return new extend board with more line
     */
    private String[][] boardExtend(String[][] sBoard, Board board) {
        String[][] eBoard = new String[sBoard.length * 4][sBoard[0].length];
        changeNull(eBoard);
        assignedArrays(sBoard, eBoard);
        for (int row = 0; row < eBoard.length; row++) {
            for (int col = 0; col < eBoard[row].length; col++) {
                char[] squareWall;
                Position position;
                String[][] names = animalAndSquareName();
                String[] name;
                switch (eBoard[row][col]) {
                    case "sp":
                        name = names[1];
                        position = squareCorrectPos(row, col);
                        squareWall = squareHasWall(board, position);
                        assignedName(name, squareWall, row, col, eBoard);
                        break;
                    case "sn":
                        name = names[0];
                        position = squareCorrectPos(row, col);
                        squareWall = squareHasWall(board, position);
                        assignedName(name, squareWall, row, col, eBoard);
                        break;
                    case "gr":
                        name = names[2];
                        position = squareCorrectPos(row, col);
                        squareWall = squareHasWall(board, position);
                        assignedName(name, squareWall, row, col, eBoard);
                        break;
                    case "st":
                        name = names[3];
                        position = squareCorrectPos(row, col);
                        squareWall = squareHasWall(board, position);
                        assignedName(name, squareWall, row, col, eBoard);
                        break;
                    case "gh":
                        name = names[6];
                        position = squareCorrectPos(row, col);
                        squareWall = squareHasWall(board, position);
                        assignedName(name, squareWall, row, col, eBoard);
                        break;
                    case "lb":
                        name = names[4];
                        position = squareCorrectPos(row, col);
                        squareWall = squareHasWall(board, position);
                        assignedName(name, squareWall, row, col, eBoard);
                        break;
                    case "bb":
                        name = names[5];
                        position = squareCorrectPos(row, col);
                        squareWall = squareHasWall(board, position);
                        assignedName(name, squareWall, row, col, eBoard);
                        break;

                    case "bu":
                        name = names[7];
                        position = squareCorrectPos(row, col);
                        squareWall = squareHasWall(board, position);
                        assignedName(name, squareWall, row, col, eBoard);
                        break;
                    default:
                        break;
                }

            }

        }

        return eBoard;
    }

    /**
     * Full out each respective part of the extend board
     *
     * @param sBoard initial board
     * @param eBoard extend board
     */
    private void assignedArrays(String[][] sBoard, String[][] eBoard) {
        var index = 1;
        for (String[] sBoard1 : sBoard) {
            eBoard[index] = sBoard1;
            index += 3;
        }
        for (int i = 0; i < eBoard.length; i++) {
            if (emptyBoard(eBoard[i], "null")) {
                eBoard[i - 1] = eBoard[i];
                eBoard[i + 1] = eBoard[i];
                i++;
            }
        }
    }

    /**
     * Change the null value of the extend board to avoid nullPointerException
     *
     * @param tab extend board
     */
    private void changeNull(String[][] tab) {
        for (String[] tab1 : tab) {
            Arrays.fill(tab1, "nothing");
        }
    }

    /**
     * Return a boolean if an animal is present
     *
     * @param position that need to be check
     * @param animals  of the game
     * @return boolean true if animal is present false if not
     */
    private boolean animalIsPresent(Position position, Animal... animals) {
        return Arrays.stream(animals).anyMatch(item -> item.getPositionOnBoard().equals(position));
    }

    /**
     * Display a an error message if occure
     *
     * @param message of the error
     */
    @Override
    public void displayError(String message) {
        System.err.print(TerminalColor.toRed(message));
    }

    /**
     * Ask the position to the user
     *
     * @return new position
     */
    @Override
    public Position askPosition() {
        System.out.println("Entrez une ligne valide: ");
        var lg = valideValue();
        System.out.println("Entrez une colonne valide: ");
        var col = valideValue();

        return new Position(lg, col);

    }

    /**
     * Ask the users a valide input
     *
     * @return primitif Integer
     */
    private int valideValue() {
        var clavier = new Scanner(System.in);
        while (!clavier.hasNextInt()) {
            clavier.next();
            displayError("L'input n'est pas un entier ou pas valable"
                    + "\n" + "Retry" + "\n");
        }
        return clavier.nextInt();
    }

    /**
     * Ask a direction and return a direction given by the user
     *
     * @return direction or null
     */
    @Override
    public Direction askDirection() {
        var input = valideDirection();
        switch (input) {
            case "N":
                return Direction.NORTH;
            case "S":
                return Direction.SOUTH;
            case "W":
                return Direction.WEST;
            case "E":
                return Direction.EAST;
            default:

        }
        return null;

    }

    /**
     * Ask a direction for the user
     *
     * @return input which is string that determine the direction of the animal
     */
    private String valideDirection() {
        String[] direction = {"north==> N", "east==> E",
                "west==> W", "south==> S"};
        displayMessage("Direction Possible: " + Arrays.toString(direction));
        var in = new Scanner(System.in);
        var input = in.nextLine().toUpperCase();
        while (!correct(input)) {
            displayError("La direction n'est pas valable ");
            input = in.next().toUpperCase();

        }
        return input;
    }

    /**
     * verify if the direction is correct return true if it's correct false if
     * it's not
     *
     * @param input of the user
     * @return boolean if correct true and false if not
     */
    private boolean correct(String input) {
        String[] direction = {"N", "E", "W", "S"};
        var found = false;
        var i = 0;
        while (i < direction.length && !found) {
            if (input.equals(direction[i])) {
                found = true;
            }
            i++;
        }
        return found;
    }

    /**
     * Display The game begin
     */
    @Override
    public void displayGameName() {
        System.out.println(TerminalColor.toGreen("*****************************"
                + "*"));
        System.out.println(TerminalColor.toRed("***********HUMBUG***********"
                + "**"));
        System.out.println(TerminalColor.toGreen("****************************"
                + "**" + "\n"));

    }

    /**
     * Display win message
     */
    @Override
    public void displayWinnerMsg() {
        System.out.println(TerminalColor.toBlue("WIN"));
    }


    /**
     * return an array of character according to the wall that's present
     *
     * @param board    of the game
     * @param position that need to be check if wall is present or not
     * @return arrays of character
     */
    private char[] squareHasWall(Board board, Position position) {
        Square[][] boardSquare = board.getSquares();
        boolean[] arraysWalls = Wall(boardSquare, position);
        char[] wallName = new char[arraysWalls.length];
        for (var i = 0; i < wallName.length; i++) {
            switch (i) {
                case 0:
                    if (arraysWalls[i]) {
                        wallName[i] = 'n';
                    } else {
                        wallName[i] = 'v';
                    }
                    break;
                case 1:
                    if (arraysWalls[i]) {
                        wallName[i] = 's';
                    } else {
                        wallName[i] = 'v';
                    }
                    break;

                case 2:
                    if (arraysWalls[i]) {
                        wallName[i] = 'e';
                    } else {
                        wallName[i] = 'v';
                    }
                    break;
                case 3:
                    if (arraysWalls[i]) {
                        wallName[i] = 'w';
                    } else {
                        wallName[i] = 'v';
                    }
                    break;
                default:

                    break;

            }
        }
        return wallName;
    }

    /**
     * return an arrays of boolean that determine where the wall is on the
     * square
     *
     * @param boardSquare the square of the board
     * @param position    that need to be check
     * @return array boolean
     */
    private boolean[] Wall(Square[][] boardSquare, Position position) {
        boolean[] arraysWalls = {boardSquare[position.getRow()][position.
                getColumn()].
                isNorthWall(), boardSquare[position.getRow()][position
                .getColumn()].
                isSouthWall(),
                boardSquare[position.getRow()][position.getColumn()].
                        isEastWall(),
                boardSquare[position.getRow()][position.getColumn()].
                        isWestWall()};
        return arraysWalls;
    }

    /**
     * Display the number of moves remaining for game
     *
     * @param getMoves number of moves remains
     */
    @Override
    public void displayRemainingMove(int getMoves) {
        System.out.println("Nombre de déplacement: " + getMoves + "\n");
    }

    /**
     * Display the animals sigle
     */
    @Override
    public void displayAnimalSigle() {
        System.out.println(TerminalColor.toPurple("E ==> Pour escargot")
                + "\n" + TerminalColor.toPurple("A ==> Pour araignée")
                + "\n" + TerminalColor.toPurple("G ==> Pour sauterrelle")
                + "\n"
                + TerminalColor.toPurple("L ==> Pour coccinelle")
                + "\n" + TerminalColor.toPurple("B ==> Pour le Bourdon")
                + "\n" + TerminalColor.toPurple("P ==> Pour le papillion")
                + "\n");
    }

    /**
     * Display the message given as argument
     *
     * @param message to print the number of level or something else
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(TerminalColor.toRed(message));
    }

    /**
     * return an arrays of the square and animal acronym sn==> snail,
     * sp==>spider, gr==> grass, st==> star, lb==> ladybird, bb==> bumbelbee
     * bu==> butterfly, gh==> grasshopper
     *
     * @return name of the animals
     */
    private String[][] animalAndSquareName() {
        String[][] names
                = {{"sn_e", "sn_w", "sn_b"},
                {"sp_e", "sp_w", "sp_b"},
                {"gr_e", "gr_w", "gr_b"},
                {"st_e", "st_w", "st_b"},
                {"lb_e", "lb_w", "lb_b"},
                {"bb_e", "bb_w", "bb_b"},
                {"gh_e", "gh_w", "gh_b"},
                {"bu_e", "bu_w", "bu_b"}};

        return names;
    }

    /**
     * assigned the correct name to the square according to animal or the square
     *
     * @param names      arrays of the names given to each square according to the
     *                   square specificity
     * @param squareWall char of the direction of the wall
     * @param row        of the board
     * @param col        of the board
     * @param boardArray the arrays String where the name will be assigned to
     */
    private void assignedName(String[] names, char[] squareWall,
                              int row, int col, String[][] boardArray) {
        for (var i = 0; i < squareWall.length; i++) {
            switch (squareWall[i]) {
                case 'n':
                    boardArray[row - 1][col] = "grass_t_n";
                    break;
                case 's':

                    boardArray[row + 1][col] = "grass_t_n";

                    break;
                case 'e':
                    if (twoWall(squareWall, 'w')) {
                        boardArray[row][col] = names[names.length - 1];
                    } else {
                        boardArray[row][col] = names[names.length - 3];
                    }
                    break;
                case 'w':
                    if (twoWall(squareWall, 'e')) {
                        boardArray[row][col] = names[names.length - 1];
                    } else {
                        boardArray[row][col] = names[names.length - 2];
                    }
                    break;
                case 'v':
                    asignedNameToEmptySquare(i, boardArray, row, col);
                    break;

            }

        }
    }

    /**
     * assigned name to the square that have no specificity but usefull
     *
     * @param i          index of each character of the squareWall method
     * @param boardArray the arrays String where the name will be assigned to
     * @param row        of the board
     * @param col        of the board
     */
    private void asignedNameToEmptySquare(int i, String[][] boardArray,
                                          int row, int col) {
        switch (i) {
            case 0:
                boardArray[row - 1][col] = "grass_t";
                break;
            case 1:
                boardArray[row + 1][col] = "grass_t";
                break;
        }
    }

    /**
     * return true if the square have two wall on his own false if not
     *
     * @param squareWall array of char for the wall
     * @param wall       character of wall name
     * @return boolean true/false
     */
    private boolean twoWall(char[] squareWall, char wall) {
        var i = 0;
        var found = false;
        while (i < squareWall.length && !found) {

            if (wall == squareWall[i]) {
                found = true;
            }
            i++;
        }
        return found;
    }

    /**
     * Ask the level for the player
     *
     * @return an integer
     */
    @Override
    public int askLevel() {
        displayMessage("Choisir le niveau de jeu entre (1-100): ");
        return verifyAndReturnCorrectInput();
    }

    /**
     * verify the input is correct and can be use to launch the game
     *
     * @return correct input (int) level number
     */
    private int verifyAndReturnCorrectInput() {
        var level = valideValue();
        while (level <= 0 || level > 100) {
            displayError("input pas valable" + "\n" + "Retry" + "\n");
            level = valideValue();
        }
        return level;
    }

    @Override
    public void update(Object args) {
        var game = (Game) args;
        displayRemainingMove(game.getRemainingMoves());
        displayBoard(game.getBoard(), game.getAnimals());

    }
}

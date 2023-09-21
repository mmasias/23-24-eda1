import java.util.Scanner;

public class HojaDeCalculo {

    public static String[][] spreadsheet = new String[15][10];

    public static String emthyCell = "       ";
    public static String rowTitles(int row){if(row<=9) {return "| 0" + row +" ";} else return "| " + row +" ";}
    public static String dividers = "|";
    public static int xPosition = 0; // Right movement
    public static int yPosition = 0; // Down movement

    public enum Direction {
        up, down, right, left
    };

    public static void main(String[] args) {
        setUp();
    }

    public static void setUp() {
        printSpriteSheet();
    }

    public void buildSpriteSheet() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                spreadsheet[i][j] = "       ";
            }
            System.out.print(dividers);
            System.out.println("");
        }
    }

    public static void printHeader(){
        System.out.print("#----");
        for (int i = 0; i < 10; i++){
            System.out.print("|---------");
        }
        System.out.println("#");
    }


    public static void printSpriteSheet() { 
        printHeader();
        System.out.print("|    ");
        for (int i = 0; i < 10; i++){
            System.out.print("|    " + getColumnLetter(i) + "    ");
        }
        System.out.println("|");
        printHeader();


        for (int i = 0; i < 15; i++) {
            System.out.print(rowTitles(i + 1));
            for (int j = 0; j < 10; j++) {
                String extendedCell = getCell(i, j) + "       ";
                String cellToPrint = extendedCell.substring(0, 7);
                if (!isSelected(i, j)) {
                    System.out.print(dividers + " " + cellToPrint + " ");
                } else {
                    System.out.print(dividers + "[" + cellToPrint + "]");
                }
            }
            System.out.print(dividers);
            System.out.println("");
        }
        printHeader();
        printCurrentCell();
        printInstructions();
    }

    public static void printCurrentCell() {
        String cellPosition = String.valueOf(getColumnLetter(yPosition)) + xPosition; 
        String cellContent = spreadsheet[xPosition][yPosition];
        String emthyCell = "";
        String printedContent = cellContent!= null ? cellContent : emthyCell;
        System.out.println(cellPosition + ": " + printedContent);
    }

    public static char getColumnLetter(int index){
        char character = (char) (65 + index);
        return character;
    }

    public static boolean isSelected(int x, int y) {
        if (x == xPosition && y == yPosition) {
            return true;
        }
        return false;
    }

    public static String getCell(int x, int y) {
        if (spreadsheet[x][y] != null) {
            return spreadsheet[x][y];
        } else
            return emthyCell;
    }

    public static void printInstructions() {
        System.out.println("Use e to modify celll");
        System.out.println("Use WASD to move");
        System.out.println("Use x to exit");
        userInput();
    }

    public static void userInput() {
        Scanner s = new Scanner(System.in);
        String instruction = s.nextLine();
        switch (instruction) {
            case "e":
                System.out.println("Type the new content (Only 7 characters will be printed)");
                String newContent = s.nextLine();
                modifyCell(newContent);
                break;
            case "w":
                move(Direction.up);
                break;
            case "a":
                move(Direction.left);
                break;
            case "s":
                move(Direction.down);
                break;
            case "d":
                move(Direction.right);
                break;
            case "x":
                System.out.println("Closing program...");
                break;
            default:
                userInput();
                break;
        }
        s.close();
    }

    public static void move(Direction direction) {
        switch (direction) {
            case up:
                if (xPosition > 0) {
                    xPosition--;
                }
                break;
            case down:
                if (xPosition < 14) {
                    xPosition++;
                }
                break;
            case left:
                if (yPosition > 0) {
                    yPosition--;
                }
                break;
            case right:
                if (yPosition < 9) {
                    yPosition++;
                }
                break;
            default:
                break;
        }
        printSpriteSheet();
    }

    public static void modifyCell(String newContent) {
        spreadsheet[xPosition][yPosition] = newContent;
        printSpriteSheet();
    }
}
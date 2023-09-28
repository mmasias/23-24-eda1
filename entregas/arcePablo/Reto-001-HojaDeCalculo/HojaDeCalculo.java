import java.util.*;

class HojaDeCalculo {

    public static void main(String[] args) {
        String[][] sheet = new String[18][11];
        String currentCell = "A1";
        Scanner input = new Scanner(System.in);

        while (true) {
            showSheet(sheet, currentCell);
            showMovementMenu(currentCell);
            String command = input.nextLine();
            if (command.equals("q")) {
                break;
            } else if (command.equals("e")) {
                System.out.println("Ingrese el nuevo valor de la celda " + currentCell + ":");
                String newValue = input.nextLine();
                updateNewValue(sheet, currentCell, newValue);
            } else {
                currentCell = handleCommand(command, currentCell);
            }
        }
        input.close();
    }

    static void showSheet(String[][] sheet, String currentCell) {

        for (int i = 0; i < sheet.length; i++) {
            for (int j = 0; j < sheet[i].length; j++) {
                System.out.print(getCellContent(i, j, sheet, currentCell));
            }
            System.out.println();
        }
    }

    static String getCellContent(int i, int j, String[][] sheet, String currentCell) {
        final int spacing = 6;

        if (i == 0 && j == 0) {
            return (" ").repeat(spacing);
        } else if (i == 0) {
            return " " + String.valueOf((char) (j + 64)) + (" ").repeat(spacing - 1);

        } else if (i == 1) {
            if (j == 0) {
                return "+" + ("-").repeat(spacing - 1);
            } else if (j == sheet[i].length - 1) {
                return "+" + ("-").repeat(spacing) + "+";
            } else {
                return "+" + ("-").repeat(spacing);
            }

        } else if (i == sheet.length - 1) {
            return ("-").repeat(spacing) + "+";

        } else if (j == 0) {
            int nSpace = 0;
            if (i < 11) {
                nSpace = spacing - 1;
            } else {
                nSpace = spacing - 2;
            }
            return String.valueOf(i - 1) + (" ").repeat(nSpace) + "|";

        } else if (getCellName(i - 1, j).equals(currentCell)) {
            return "[" + (" ").repeat(spacing - 2) + "]" + "|";
        } else {
            if (sheet[i][j] == null) {
                return (" ").repeat(spacing) + "|";
            } else {
                return sheet[i][j];
            }
        }
    }

    static void updateNewValue(String[][] sheet, String currentCell, String newValue) {
        int row = Integer.parseInt(currentCell.substring(1)) - 1;
        char column = currentCell.charAt(0);
        int columnIndex = column - 'A';

        if (newValue.length() > 7) {
            newValue = newValue.substring(0, 7);
        }

        sheet[row][columnIndex] = newValue;
    }

    static String getCellName(int i, int j) {
        return String.valueOf((char) (j + 64)) + String.valueOf(i);
    }

    static void showMovementMenu(String cell) {
        System.out.println("Celda actual: " + cell);
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione E para editar la celda actual.");
        System.out.println("Presione Q para salir.");
    }

    static String handleCommand(String command, String cell) {
        switch (command) {
            case "w":
                return moveUp(cell);
            case "a":
                return moveLeft(cell);
            case "s":
                return moveDown(cell);
            case "d":
                return moveRight(cell);
            default:
                System.out.println("Comando no reconocido.");
                return cell;
        }
    }

    static String moveUp(String cell) {
        char column = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1));

        if (row > 1) {
            row--;
            return cell.substring(0, 1) + String.valueOf(row);
        } else if (column == 'J' && row == 1) {
            return cell;
        } else if (column > 'A') {
            column--;
            return String.valueOf(column) + "15";
        } else {
            return cell;
        }
    }

    static String moveDown(String cell) {
        char column = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1));

        if (row < 15) {
            row++;
            return cell.substring(0, 1) + String.valueOf(row);
        } else if (column == 'A' && row == 15) {
            return cell;
        } else if (column < 'J') {
            column++;
            return String.valueOf(column) + "1";
        } else {
            return cell;
        }
    }

    static String moveLeft(String cell) {
        char column = cell.charAt(0);
        if (column > 'A') {
            column--;
            return String.valueOf(column) + cell.substring(1);
        } else {
            return cell;
        }
    }

    static String moveRight(String cell) {
        char column = cell.charAt(0);
        if (column < 'J') {
            column++;
            return String.valueOf(column) + cell.substring(1);
        } else {
            return cell;
        }
    }
}
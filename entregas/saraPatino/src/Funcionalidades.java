package src;

import java.util.Scanner;

public class Funcionalidades implements IFuncionalidades {
    private static final int ROWS = 15;
    private static final int COLUMNS = 10;

    public void startingExcel(String[][] excel) {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                excel[row][column] = "";
            }
        }
    }

    public void printHeaders() {
        System.out.print("      ");
        for (int column = 0; column < COLUMNS; column++) {
            char columnLetter = (char) ('A' + column);
            System.out.printf("%-8s", columnLetter);
        }
        System.out.println();
    }

    public void printLine() {
        System.out.print("     +");
        for (int column = 0; column < COLUMNS; column++) {
            System.out.print("-------+");
        }
        System.out.println();
    }

    public void printing(String[][] excel, int[] position) {
        int currentRow = position[0];
        int currentColumn = position[1];

        clean();
        printOptions(position);
        printHeaders();
        printLine();

        for (int row = 0; row < ROWS; row++) {
            System.out.printf("%-5d|", row + 1);
            for (int column = 0; column < COLUMNS; column++) {
                String celda = excel[row][column];
                celda = celda.length() > 5 ? celda.substring(0, 5) : String.format("%-5s", celda);
                if (row == currentRow && column == currentColumn) {
                    celda = "[" + celda + "]";
                } else {
                    celda = " " + celda + " ";
                }

                System.out.print(celda + "|");
            }
            System.out.println();
        }
        printLine();
        moving(2, 5);

    }

    public void printOptions(int[] position) {
        int currentRow = position[0];
        int currentColumn = position[1];

        System.out.println("DESPLAZAMIENTO: wasd | Edición: e | Salir: f");
        System.out.println("[" + (char) ('A' + currentColumn) + (currentRow + 1) + "] ");
    }

    public boolean processCommand(char command, String[][] excel, int[] position) {
        int currentRow = position[0];
        int currentColumn = position[1];

        switch (command) {
            case 'W':
                currentRow = Math.max(currentRow - 1, 0);
                break;
            case 'A':
                currentColumn = Math.max(currentColumn - 1, 0);
                break;
            case 'S':
                currentRow = Math.min(currentRow + 1, ROWS - 1);
                break;
            case 'D':
                currentColumn = Math.min(currentColumn + 1, COLUMNS - 1);
                break;
            case 'E':
                insertText(excel, currentRow, currentColumn);
                break;
            case 'F':
                System.out.println("Quitting...");
                return false;
            default:
                System.out.println("Command not available... try again");
        }

        position[0] = currentRow;
        position[1] = currentColumn;

        return true;
    }

    public void insertText(String[][] page, int currentRow, int currentColumn) {
        Scanner scanner = new Scanner(System.in);
        moving(2, 0);
        System.out.print("Insert text [" + (char) ('A' + currentColumn) + (currentRow + 1) + "]:");
        String text = scanner.nextLine();
        page[currentRow][currentColumn] = text;
        scanner.close();  
    }

    public void clean() {
        System.out.print("\033[0;0H\033[0;0J");
        System.out.flush();
    }

    public void moving(int row, int column) {
        char codigoDeEscape = 0x1B;
        System.out.print(String.format("%c[%d;%df", codigoDeEscape, row, column));
    }

}
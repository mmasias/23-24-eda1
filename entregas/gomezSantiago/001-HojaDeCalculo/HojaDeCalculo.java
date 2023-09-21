import java.util.Scanner;
import java.awt.*;

public class HojaDeCalculo {
    private static final int columns = 10;
    private static final int rows = 15;

    public static void main(String[] args) {
        String[][] spreadsheet = new String[rows][columns];
        String[][] columnLabels = generateColumnLabels();
        String[][] rowLabels = generateRowLabels();
        String message = "Bienvenido a tu hoja de calculo ";
        int currentrow = 0;
        int currentcolumn = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showSpreadSheet(spreadsheet, columnLabels, rowLabels, currentrow, currentcolumn, message);
            System.out.print("Ingrese comando: ");
            String comand = scanner.nextLine().trim().toUpperCase();

            switch (comand) {
                case "E":
                    System.out.println("Ingrese el texto: ");
                    String textToAssign = scanner.nextLine();
                    spreadsheet[currentrow][currentcolumn] = textToAssign;
                case "W":
                    if (currentrow > 0) {
                        currentrow--;
                    }
                    break;
                case "A":
                    if (currentcolumn > 0) {
                        currentcolumn--;
                    }
                    break;
                case "S":
                    if (currentrow < rows - 1) {
                        currentrow++;
                    }
                    break;
                case "D":
                    if (currentcolumn < columns - 1) {
                        currentcolumn++;
                    }
                    break;
                case "Q":
                    System.out.println("+---------------------+");
                    System.out.println("| Programa finalizado |");
                    System.out.println("+---------------------+");
                    return;
                default:
                    if (comand.length() <= 6) {
                        spreadsheet[currentrow][currentcolumn] = comand;
                    } else {
                        spreadsheet[currentrow][currentcolumn] = comand.substring(0, 6);
                    }
                    break;
            }

        }
    }

    private static void showSpreadSheet(String[][] spreadsheet, String[][] columnLabels, String[][] rowLabels,
            int currentrow, int currentcolumn, String message) {
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("|                      " + message + "                            |");
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.print("|" + "  ");

        for (int column = 0; column < columns; column++) {
            System.out.print("|   " + columnLabels[0][column] + ("   "));
        }
        System.out.print("|");
        System.out.println();
        System.out.println("+--+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");

        for (int row = 0; row < rows; row++) {
            System.out.print("|" + rowLabels[row][0]);
            for (int column = 0; column < columns; column++) {
                String content = spreadsheet[row][column];
                if (content == null) {
                    content = "";
                }
                content = String.format("%7s", content);
                
                String finalContent = content.substring(0,Math.min(7, content.length()));

                if (row == currentrow && column == currentcolumn) {
                    System.out.print("|[     ]");
                } else {
                    System.out.print("|" + finalContent);
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("+--+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println();
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("| Celda actual -> [ " + columnLabels[0][currentcolumn] + rowLabels[currentrow][0]
                + " ]                                                |");
        System.out.println("| Utilice las teclas W, A, S y D para moverse.                           |");
        System.out.println("| Presione 'E' para ingresar texto en la celda actual.                   |");
        System.out.println("| Presione 'Q' para salir.                                               |");
        System.out.println("+------------------------------------------------------------------------+");
    }

    private static String[][] generateColumnLabels() {
        String[][] columnLabels = new String[1][columns];
        for (int column = 0; column < columns; column++) {
            columnLabels[0][column] = Character.toString((char) ('A' + column));
        }
        return columnLabels;
    }

    private static String[][] generateRowLabels() {
        String[][] rowLabels = new String[rows][1];
        for (int row = 0; row < rows; row++) {
            rowLabels[row][0] = String.format("%2d", row + 1);
        }
        return rowLabels;
    }
}
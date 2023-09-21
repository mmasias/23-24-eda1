import java.util.Scanner;

public class SpeedSheat {

    private String[][] table;

    private String[] alphabet = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"
    };

    private int currentRow = 0;
    private int currentColumn = 0;

    public SpeedSheat (int rows, int columns){
        this.table = new String[rows][columns];
    }

    private void printColumns(){
        System.out.print("\t    ");

        for(int i = 0; i < table[0].length; i++){
            System.out.print(alphabet[i] + "        ");
        }

        System.out.println();
    }


    private void printHorizontalBorders() {
        System.out.print("\t");
        for (int i = 0; i < table[0].length; i++) {
            if (i == 0 || i < table[0].length - 1) {
                System.out.print("+--------");
            }
            if (i == (table[0].length - 1)) {
                System.out.print("+--------+");
            }
        }
        System.out.println();
    }

    public void printSheet() {
        printColumns();
        printHorizontalBorders();
        for (int i = 0; i < table.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < table[i].length; j++) {
                if (j == 0 || j < table[i].length - 1) {
                    String cellContent = formatCell(table[i][j]);
                    if (i == currentRow && j == currentColumn) {
                        System.out.print("|\u001B[47m" + cellContent + " \u001B[0m");
                    } else {
                        System.out.print("| " + cellContent);
                    }
                }
                if (j == (table[i].length - 1)) {
                    String cellContent = formatCell(table[i][j]);
                    if (i == currentRow && j == currentColumn) {
                        System.out.print("|\u001B[47m" + cellContent + " \u001B[0m|");
                    } else {
                        System.out.print("| " + cellContent + " |");
                    }
                }
            }
            System.out.println();
        }
        printHorizontalBorders();
        System.out.println("Celda actual → [" + alphabet[currentColumn] + (currentRow + 1) + "]");
        String currentCellContent = table[currentRow][currentColumn];
        System.out.println("Contenido actual: " + (currentCellContent != null ? currentCellContent : ""));

    }

    private String formatCell(String cellValue) {
        if (cellValue == null) {
            return "       ";
        } else if (cellValue.length() >= 7) {
            return cellValue.substring(0, 7);
        } else {
            int spacesToAdd = 7 - cellValue.length();
            StringBuilder formatted = new StringBuilder(cellValue);
            for (int i = 0; i < spacesToAdd; i++) {
                formatted.append(" ");
            }
            return formatted.toString();
        }
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printSheet();
            System.out.println("Utilice las teclas W, A, S y D para moverse.");
            System.out.println("Utiliza la tecla 'E' para ingresar texto.");
            System.out.println("Utiliza la tecla 'Q' para salir de la aplicacion.");
            System.out.print("Ingrese un comando: ");
            String command = scanner.next();
            handleCommand(command, scanner);
        }
    }


    private void handleCommand(String command, Scanner scanner) {
        switch (command) {
            case "w":
                if (currentRow > 0) {
                    currentRow--;
                }
                break;
            case "s":
                if (currentRow < table.length - 1) {
                    currentRow++;
                }
                break;
            case "a":
                if (currentColumn > 0) {
                    currentColumn--;
                }
                break;
            case "d":
                if (currentColumn < table[0].length - 1) {
                    currentColumn++;
                }
                break;
            case "e":
                System.out.print("Ingrese el valor: ");
                String value = scanner.next();
                table[currentRow][currentColumn] = value;
                break;
            case "q":
                System.exit(0);
                break;
            default:
                System.out.println("Comando no válido.");
        }
    }
}

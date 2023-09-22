import java.util.*;

class HojaDeCalculo {

    public static void main(String[] args) {
        String[][] sheet = new String[18][11];
        String currentCell = "A1";
        Scanner input = new Scanner(System.in);

        while (true) {
            showSheet(sheet);
            showMovementMenu(currentCell);
            String command = input.nextLine();
            if (command.equals("q")) {
                break;
            } else {
                handleCommand(command);
            }
        }

        input.close();
    }

    static void showSheet(String[][] sheet) {

        for (int i = 0; i < sheet.length; i++) {
            for (int j = 0; j < sheet[i].length; j++) {
                sheet[i][j] = getCellContent(i, j, sheet);
                System.out.print(sheet[i][j]);
            }
            System.out.println();
        }
    }

    static String getCellContent(int i, int j, String[][] sheet) {
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
        } else {
            return (" ").repeat(spacing) + "|";
        }
    }

    static void showMovementMenu(String cell) {
        System.out.println("Celda actual: " + cell);
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione E para editar la celda actual.");
        System.out.println("Presione Q para salir.");
    }

    static void handleCommand(String command) {

    }
}
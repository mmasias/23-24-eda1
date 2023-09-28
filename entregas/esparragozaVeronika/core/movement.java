package esparragozaVeronika.core;

import java.util.Scanner;

public class movement {
    static Scanner scanner = new Scanner(System.in);
    public void inputUserMovement(String userInput, String[][] table, int[] userPosition) {
        switch (userInput) {
            case "w":
                if (userPosition[1] > 1) {
                    userPosition[1]--;
                }
                break;
            case "s":
                if (userPosition[1] < table.length - 1) {
                    userPosition[1]++;
                }
                break;
            case "a":
                if (userPosition[0] > 0) {
                    userPosition[0]--;
                }
                break;
            case "d":
                if (userPosition[0] < table[0].length - 1) {
                    userPosition[0]++;
                }
                break;
            case ":q":
                System.out.println("Programa finalizado");
                break;
            case ":e":
                System.out.println("Que deseas escribir: ");
                String dataEnter = scanner.nextLine();
                putTextInCell(userPosition, table, dataEnter);
                break;
            default:
                System.out.println("Tecla no permitida");
                break;
        }
    }
    public void putTextInCell(int[] userPosition, String[][] table, String dataEnter){
        String textInputInCell = counterLetter(dataEnter);
        table[userPosition[1]][userPosition[0]] = textInputInCell;
    }
    public String counterLetter(String textInputinCell){
        if (textInputinCell == null) {
            return " ".repeat(8);
        } else if (textInputinCell.length() >= 7) {
            return textInputinCell.substring(0, 7);
        } else {
            int spacesToAdd = 7 - textInputinCell.length();
            StringBuilder formatted = new StringBuilder(textInputinCell);
            for (int i = 0; i < spacesToAdd; i++) {
                formatted.append(" ");
            }
            return formatted.toString();
        }
    }
}

package esparragozaVeronika.core;

import java.util.Scanner;

public class movement {
    public boolean isOperative;
    private user user;
    static Scanner scanner = new Scanner(System.in);
    public movement(user user) {
        this.user = user;
    }
    public void inputUserMovement(String userInput, String[][] table) {
        switch (userInput) {
            case "w":
                if (user.getUserPosition()[1] > 1) {
                    user.getUserPosition()[1]--;
                }
                break;
            case "s":
                if (user.getUserPosition()[1] < table.length - 1) {
                    user.getUserPosition()[1]++;
                }
                break;
            case "a":
                if (user.getUserPosition()[0] > 0) {
                    user.getUserPosition()[0]--;
                }
                break;
            case "d":
                if (user.getUserPosition()[0] < table[0].length - 1) {
                    user.getUserPosition()[0]++;
                }
                break;
            case ":q":
                System.out.println("Programa finalizado");
                isOperative = true;
                break;
            case ":e":
                System.out.println("Que deseas escribir: ");
                String dataEnter = scanner.nextLine();
                putTextInCell(table, dataEnter);
                break;
            default:
                System.out.println("Tecla no permitida");
                break;
        }
    }
    public void putTextInCell(String[][] table, String dataEnter){
        String textInputInCell = counterLetter(dataEnter);
        table[user.getUserPosition()[1]][user.getUserPosition()[0]] = textInputInCell;
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
    public boolean isOperative(){
        return isOperative;
    }
}

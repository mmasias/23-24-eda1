package veronikaEsparragoza;

import java.util.Scanner;

public class main {
    static Scanner scanner = new Scanner(System.in);
    static String[] celds = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public static void main(String[] args) {
        int[] user = {0, 1};
        boolean exit = false;
        String[][] table = new String[15][10];

        System.out.println("Bienvenido a la hoja de calculo");
        System.out.println("Para moverte usa las teclas w, a, s, d");
        System.out.println("Para escribir en una celda usa la tecla e");
        System.out.println("Para salir usa la tecla q");


        while (!exit) {
            printInitialBody(table, user);
            String inputUser = scanner.nextLine();

            exit = programsEnds(inputUser);
            userInputandMovement(inputUser, user, table);
        }
    }

    private static void printInitialBody(String[][] table, int[] user){
        System.out.print("--");
        for (int letra = 0; letra < celds.length; letra++){
            System.out.print("|___ " + celds[letra] + " ___|");
        }
        for (int i = 1; i < table.length; i++) {
            System.out.println("");
            if(i < 10){ System.out.print("0" + i);} else { System.out.print(i);};
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == null) {
                    System.out.print("|         |");
                } else {
                    System.out.print("|" + table[i][j] + "|");
                }
                if(user[0] == j && user[1] == i){
                    System.out.print("\u001B[31m|[       ]|\u001B[0m");
                }
            }
        }
    }
    private static void putTextInCell(int[] user, String[][] table, String textInputinCell){
        table[user[0]][user[1]] = textInputinCell;
    }

    private static void userInputandMovement(String inputUser, int[] user, String[][] table) {
        switch (inputUser) {
            case "w":
                if (user[1] >= 1) {
                    user[1]--;
                }
                break;
            case "s":
                if (user[1] < celds.length - 1) {
                    user[1]++;
                }
                break;
            case "a":
                if (user[0] < celds.length - 1) {
                    user[0]--;
                }
                break;
            case "d":
                if (user[0] < celds.length - 1) {
                    user[0]++;
                }
                break;
            case "e":
                System.out.println("Que deseas escribir:");
                String textInCell = counterLetter(scanner.nextLine());
                putTextInCell(user, table, textInCell);
                break;
            default:
                System.out.println("");
        }
    }
    private static String counterLetter(String textInputinCell){
        if (textInputinCell == null) {
            return "       ";
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
    private static boolean programsEnds(String inputUser){
        if (inputUser.charAt(0) == 'q'){
            return true;
        } else {
            return false;
        }
    }
}

package esparragozaVeronika;

import esparragozaVeronika.core.*;
import esparragozaVeronika.view.*;

import java.util.Scanner;

public class main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        main program = new main();
        program.initializeProgram();
    }
    public void initializeProgram() {
        String[][] table = new String[4][5];
        int[] initialPosition = {0, 1};
        cells cells = new cells(table);
        user currentUser = new user();
        currentUser.setUserPosition(initialPosition);
        spreadsheet spreadsheet = new spreadsheet(table);
        movement userMovement = new movement(currentUser);

        while (!userMovement.isOperative) {
            excelStructure excel = new excelStructure(table, cells, currentUser);
            System.out.println("Introduce una tecla ('w', 's', 'a', 'd', ':q' para salir, ':e' para editar): ");
            String userInput = scanner.nextLine();
            if (userMovement.isOperative()) {
                System.out.println("Programa finalizado");
            } else {
                userMovement.inputUserMovement(userInput, table);
            }
        }
    }
}
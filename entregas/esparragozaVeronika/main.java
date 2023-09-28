package esparragozaVeronika;

import esparragozaVeronika.core.*;
import esparragozaVeronika.view.*;

import java.util.Scanner;

import static esparragozaVeronika.view.initialInformation.printInformation;

public class main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int[] initialPosition = {0,1};
        boolean exitProgram = false;
        String[][] table = new String[15][10];

        user Usuario = new user();
        excelStructure Excel = new excelStructure();
        movement Movimiento = new movement();

        Usuario.setUserPosition(initialPosition);

        Excel.initialDataInTable(table);
        while (!exitProgram) {
            printInformation();
            Excel.printTableHeader();
            Excel.printTableBody(table, Usuario.getUserPosition());
            String inputUser = scanner.nextLine();
            exitProgram = Excel.programsEnds(inputUser);
            Usuario.setUserInput(inputUser);
            Movimiento.inputUserMovement(Usuario.getUserInput(), table, Usuario.getUserPosition());
        }
    }
}
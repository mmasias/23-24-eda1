package src;

import java.util.Scanner;

public class Excel {

    private static final int ROWS = 15;
    private static final int COLUMNS = 10;

    public static void main(String[] args) throws ExceptionsExcel {
        Scanner scanner = new Scanner(System.in);
        ExceptionsExcel exceptionsExcel = new ExceptionsExcel(null);
        Funcionalidades funcionalidades = new Funcionalidades();

        String[][] excel = new String[ROWS][COLUMNS];
        funcionalidades.startingExcel(excel);

        int[] position = { 0, 0 };
        boolean operating = true;

        try {
            while (operating) {
            funcionalidades.printing(excel, position);
            char command = scanner.next().toUpperCase().charAt(0);
            operating = funcionalidades.processCommand(command, excel, position);
        }

        funcionalidades.clean();
        scanner.close();
        } catch (Exception e) {
            System.out.println(exceptionsExcel.getMessage());
            throw new ExceptionsExcel("Hay un error en la hoja de cálculo");
        }
        
    }
}

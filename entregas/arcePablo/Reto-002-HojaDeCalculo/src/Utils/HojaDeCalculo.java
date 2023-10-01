package Utils;

import java.util.Scanner;

public class HojaDeCalculo {
    private Sheet sheet;
    private Movement movement;
    private Scanner input;

    public HojaDeCalculo() {
        sheet = new Sheet(18, 11);
        input = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            Menu.showSheet(sheet);
            Menu.showMovementMenu(sheet.getCurrentCell());
            String command = input.nextLine();
            if (command.equals("q")) {
                break;
            } else if (command.equals("e")) {
                System.out.println("Ingrese el nuevo valor de la celda " + sheet.getCurrentCell() + ":");
                String newValue = input.nextLine();
                sheet.setCellValue(movement.getCurrentRow(), movement.getCurrentColumn(), newValue);
            } else {
                movement.handleCommand(command);
            }
        }
        input.close();
    }
}
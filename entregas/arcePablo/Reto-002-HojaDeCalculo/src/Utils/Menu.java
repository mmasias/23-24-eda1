package Utils;

class Menu {

    public static void showSheet(Sheet sheet, String currentCell) {
        System.out.println("Hoja de Cálculo:");
        for (int i = 0; i < sheet.getSheetData().length; i++) {
            for (int j = 0; j < sheet.getSheetData()[i].length; j++) {
                System.out.print(sheet.getCellValue(i, j) + "\t");
            }
            System.out.println();
        }
    }

    public static void showMovementMenu() {
        System.out.println("Celda actual: " + Movement.getCurrentCell());
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione E para editar la celda actual.");
        System.out.println("Presione Q para salir.");
    }
}






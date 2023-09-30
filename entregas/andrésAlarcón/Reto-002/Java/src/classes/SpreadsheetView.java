package classes;

public class SpreadsheetView {
    public static void displaySpreadsheet(Spreadsheet spreadsheet, Navigation navigation) {
        System.out.print("  ");
        for (int col = 0; col < spreadsheet.getCols(); col++) {
            System.out.printf("%7s ", navigation.convertColumnToLetter(col));
        }
        System.out.println("");
        System.out.println("   +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");

        for (int i = 0; i < spreadsheet.getRows(); i++) {
            System.out.printf("%2d ", (i + 1));
            for (int j = 0; j < spreadsheet.getCols(); j++) {
                Cell cell = spreadsheet.getCell(i, j);
                if (i == navigation.getCurrentRow() - 1 && j == navigation.getCurrentColumn()) {
                    System.out.print("|[_____]");
                } else {
                    System.out.printf("|%7s", cell.getContent());
                }
            }
            System.out.println("|");
        }

        System.out.println("   +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
    }
}

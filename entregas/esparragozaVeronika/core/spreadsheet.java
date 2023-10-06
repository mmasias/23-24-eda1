package esparragozaVeronika.core;
public class spreadsheet {
    private cells cells;
    public spreadsheet(String[][] table) {
        this.cells = new cells(table);
        for (int column = 0; column < table.length; column++) {
            for (int row = 0; row < table[0].length; row++) {
                cells.setCellValue(column, row, " ".repeat(7));
            }
        }
    }
}

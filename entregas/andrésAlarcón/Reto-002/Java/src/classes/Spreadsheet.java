package classes;

public class Spreadsheet {
    private Cell[][] cells;

    public Spreadsheet(int rows, int cols) {
        this.cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public int getRows() {
        return cells.length;
    }

    public int getCols() {
        return cells[0].length;
    }
}

package classes;

public class Navigation {
    private int currentRow;
    private int currentColumn;
    private Spreadsheet spreadsheet;

    public Navigation(Spreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
        this.currentRow = 0;
        this.currentColumn = 0;
    }

    public void moveUp() {
        if (currentRow > 0) {
            currentRow--;
        }
    }

    public void moveDown() {
        if (currentRow < spreadsheet.getRows() - 1) {
            currentRow++;
        }
    }

    public void moveLeft() {
        if (currentColumn > 1) {
            currentColumn--;
        }
    }

    public void moveRight() {
        if (currentColumn < spreadsheet.getCols() - 1) {
            currentColumn++;
        }
    }

    public void enterText(String text) {
        Cell currentCell = spreadsheet.getCell(currentRow, currentColumn);
        currentCell.setContent(text.substring(0, Math.min(text.length(), 7)));
    }

    public String getCurrentColumnLetter() {
        char letter = (char) ('A' + currentColumn);
        return String.valueOf(letter);
    }

    public int getCurrentRow() {
        return currentRow + 1; // 1-based index
    }
    public int getCurrentColumn() {
        return currentColumn;
    }

    public int getRows() {
        return spreadsheet.getRows();
    }

    public int getCols() {
        return spreadsheet.getCols();
    }

    public char convertColumnToLetter(int column) {
        return (char) ('A' + column);
    }
}

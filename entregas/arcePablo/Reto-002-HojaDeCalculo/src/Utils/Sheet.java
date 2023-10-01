package Utils;

class Sheet {
    private String[][] sheetData;
    private String currentCell;

    public Sheet(int rows, int columns) {
        sheetData = new String[rows][columns];
        currentCell = "A1";
    }

    public String getCellContent(int i, int j) {
        final int spacing = 6;

        if (i == 0 && j == 0) {
            return (" ").repeat(spacing);
        } else if (i == 0) {
            return " " + String.valueOf((char) (j + 64)) + (" ").repeat(spacing - 1);

        } else if (i == 1) {
            if (j == 0) {
                return "+" + ("-").repeat(spacing - 1);
            } else if (j == this.sheetData[i].length - 1) {
                return "+" + ("-").repeat(spacing) + "+";
            } else {
                return "+" + ("-").repeat(spacing);
            }

        } else if (i == this.sheetData.length - 1) {
            return ("-").repeat(spacing) + "+";

        } else if (j == 0) {
            int nSpace = 0;
            if (i < 11) {
                nSpace = spacing - 1;
            } else {
                nSpace = spacing - 2;
            }
            return String.valueOf(i - 1) + (" ").repeat(nSpace) + "|";

        } else if (getCellName(i - 1, j).equals(this.currentCell)) {
            return "[" + (" ").repeat(spacing - 2) + "]" + "|";
        } else {
            if (this.sheetData[i][j] == null) {
                return (" ").repeat(spacing) + "|";
            } else {
                return this.sheetData[i][j];
            }
        }
    }
    static String getCellName(int i, int j) {
        return String.valueOf((char) (j + 64)) + String.valueOf(i);
    }

    public String getCurrentCell() {
        return currentCell;
    }

    public void setCellValue(int row, int col, String value) {
        sheetData[row][col] = value;
    }
    public String [][] getSheetData(){
        return sheetData;
    }
}
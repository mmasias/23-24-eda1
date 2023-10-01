package Utils;

class Sheet {
    private String[][] sheetData;
    private String currentCell;
    private final int spacing = 8;
    public Sheet(int rows, int columns) {
        sheetData = new String[rows][columns];
        currentCell = "A1";
    }

    public String getCellContent(int i, int j) {
        if (i == 0 && j == 0) {
            return (" ").repeat(spacing);
        } else if (i == 0) {
            return " " + (char) (j + 64) + (" ").repeat(spacing - 1);

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
            return i - 1 + (" ").repeat(nSpace) + "|";

        } else if (getCellName(i - 1, j).equals(this.currentCell)) {
            if (this.sheetData[i][j] == null) {
                return "[" + (" ").repeat(spacing - 2) + "]" + "|";
            } else {
                String cellValue = this.sheetData[i][j];
                if (cellValue.length() > spacing - 2) {
                    cellValue = cellValue.substring(0, spacing - 2);
                }
                return "[" + cellValue + "]" + "|";
            }
        } else {
            if (this.sheetData[i][j] == null) {
                return (" ").repeat(spacing) + "|";
            } else {
                return this.sheetData[i][j] + "|";
            }
        }
    }
    static String getCellName(int i, int j) {
        return (char) (j + 64) + String.valueOf(i);
    }

    public String getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(String currentCell) {
        this.currentCell = currentCell;
    }

    public void setCellValue(int row, int col, String value) {
        if (value.length() > spacing) {
            value = value.substring(0, spacing);
        } else if (value.length() < spacing) {
            int spacesToAdd = spacing - value.length();
            value = value + " ".repeat(spacesToAdd);
        }
        sheetData[row+2][col+1] = value;
    }



    public String [][] getSheetData(){
        return sheetData;
    }
}
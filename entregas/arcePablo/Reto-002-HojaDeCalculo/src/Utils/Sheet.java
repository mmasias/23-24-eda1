package Utils;

class Sheet {
    private String[][] sheetData;

    public Sheet(int rows, int columns) {
        sheetData = new String[rows][columns];
    }

    public String getCellValue(int row, int col) {
        return sheetData[row][col];
    }

    public void setCellValue(int row, int col, String value) {
        sheetData[row][col] = value;
    }
    public String [][] getSheetData(){
        return sheetData;
    }
}
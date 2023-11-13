package com;

import java.util.Scanner;

class ExcelSheet {

    private String[] alphabet = {
            "A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R",
            "S", "T", "V", "W", "X", "Y", "Z"
    };

    private String[][] table;
    private int maxColums, maxRows;
    private int actualColumn = 0, actualRow = 0;
    private int cellSpaceLength = 5;

    private Scanner input = new Scanner(System.in);

    public ExcelSheet(int colums, int rows) {
        this.maxColums = colums;
        this.maxRows = rows;
        this.table = new String[rows][colums];
    }

    private void printColums() {
        System.out.print("\t  ");
        for (int i = 0; i < table[0].length; i++) {
            System.out.print(alphabet[i] + "       ");
        }
        System.out.println();
    }

    private void printHorizontalBorders() {
        System.out.print("\t");

        for (int i = 0; i < table[0].length; i++) {
            System.out.print("+-------");
        }
        System.out.print("+");
        System.out.println();
    }

    private void printInformation() {
        String actualCell = "[" + alphabet[this.actualColumn] + "" + (this.actualRow + 1) + "]";

        System.out.println("Actual cell -> " + actualCell);
        System.out.println("Use the Keys W(Up), S(Down), A(Left), D(Rigth) for moove.");
        System.out.println("Press ':e' for write text in the actual text.");
        System.out.println("Press ':q' for exit the system.");
    }

    private String fixedCellValue(int row, int colum) {
        String cellValue = this.table[row][colum];
        String fixedValue = "";
        if (cellValue != null) {

            if (cellValue.length() > this.cellSpaceLength) {
                fixedValue = cellValue.substring(0, this.cellSpaceLength);
                return fixedValue;
            } else {
                fixedValue = cellValue;
                for (int i = fixedValue.length(); i < this.cellSpaceLength; i++) {
                    fixedValue += " ";
                }
                return fixedValue;
            }
        }

        for (int i = fixedValue.length(); i < this.cellSpaceLength; i++) {
            fixedValue += " ";
        }

        return fixedValue;
    }

    private void cellPrintHandler(int row, int column) {
        if (column == 0 || column < table[row].length - 1) {
            if (this.actualRow == row && this.actualColumn == column) {
                System.out.print("|[" + fixedCellValue(row, column) + "]");
            } else {
                System.out.print("| " + fixedCellValue(row, column) + " ");
            }

        }
        if (column == (table[row].length - 1)) {
            if (this.actualRow == row && this.actualColumn == column) {
                System.out.print("|[" + fixedCellValue(row, column) + "]|");
            } else {
                System.out.print("| " + fixedCellValue(row, column) + " |");
            }
        }
    }

    private void printSheet() {
        printColums();
        printHorizontalBorders();

        for (int i = 0; i < table.length; i++) {

            System.out.print((i + 1) + "\t");

            for (int j = 0; j < table[i].length; j++) {
                cellPrintHandler(i, j);
            }
            System.out.println("");
        }

        printHorizontalBorders();
        printInformation();
    }

    private void addValueToCell(String value) {
        this.table[this.actualRow][this.actualColumn] = value;
    }

    private void handleCellMovement(String direction) {
        if (direction.equals("w")) {
            if (this.actualRow > 0) {
                this.actualRow = this.actualRow - 1;
            }
        }
        if (direction.equals("s")) {
            if (this.actualRow < maxRows - 1) {
                this.actualRow = this.actualRow + 1;
            }
        }
        if (direction.equals("a")) {
            if (this.actualColumn > 0) {
                this.actualColumn = this.actualColumn - 1;
            }
        }
        if (direction.equals("d")) {
            if (this.actualColumn < maxColums - 1) {
                this.actualColumn = this.actualColumn + 1;
            }
        }
    }

    private boolean inputHandler(String inputValue) {
        String cellValue;

        if (inputValue.equals(":q")) {
            System.out.println("The system will close ....");
            return false;
        }
        if (inputValue.equals(":e")) {
            System.out.print("> Write the value for the cell: ");
            cellValue = input.nextLine();
            addValueToCell(cellValue);
            return true;
        }
        if (inputValue.equals("w") || inputValue.equals("s") || inputValue.equals("a") || inputValue.equals("d")) {
            handleCellMovement(inputValue);
            return true;
        }

        System.out.println("");
        System.out.println("INFO: ¡Write a valid command!");
        return true;
    }

    public void startExcel() {
        boolean isExcelActive = true;
        String inputValue;

        while (isExcelActive) {
            printSheet();
            System.out.print("Write command: ");
            inputValue = input.nextLine();
            isExcelActive = inputHandler(inputValue);
        }
    }
}
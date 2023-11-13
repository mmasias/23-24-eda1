package com;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int colums = 0;
        int rows = 0;

        System.out.println("Set the initial Parameters.");

        System.out.print("Colums: ");
        colums = input.nextInt();

        System.out.print("Rows: ");
        rows = input.nextInt();

        ExcelSheet newExcelSheet = new ExcelSheet(colums, rows);

        newExcelSheet.startExcel();
    }
}
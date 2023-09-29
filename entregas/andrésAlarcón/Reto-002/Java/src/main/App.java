package main;
import classes.Spreadsheet;
import java.util.Scanner;

public class App {
        public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(15, 10);
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            spreadsheet.display();

            System.out.println("Current cell -> " + "[" + spreadsheet.getCurrentColumnLetter()
                    + spreadsheet.getCurrentRow() + "]");
            System.out.println("Use the W, A, S & D keys to move around the spreadsheet.");
            System.out.println("Press 'E' to enter a text in the current cell.");
            System.out.println("Press 'Q' to exit.");

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "w":
                    spreadsheet.moveUp();
                    break;
                case "a":
                    spreadsheet.moveLeft();
                    break;
                case "s":
                    spreadsheet.moveDown();
                    break;
                case "d":
                    spreadsheet.moveRight();
                    break;
                case "e":
                    System.out.println("Enter the text for the cell: ");
                    String text = scanner.nextLine();
                    spreadsheet.enterText(text);
                    break;
                case "q":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
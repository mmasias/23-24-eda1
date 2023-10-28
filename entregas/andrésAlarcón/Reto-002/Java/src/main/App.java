package main;
import java.util.Scanner;
import classes.*;

public class App {

    private static Spreadsheet spreadsheet = new Spreadsheet(15, 10);
    private static Navigation navigation = new Navigation(spreadsheet);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            SpreadsheetView.displaySpreadsheet(spreadsheet, navigation);

            System.out.println("Current cell -> " + "[" + navigation.getCurrentColumnLetter() + navigation.getCurrentRow() + "]");
            System.out.println("Use the W, A, S & D keys to move around the spreadsheet.");
            System.out.println("Press 'E' to enter a text in the current cell.");
            System.out.println("Press 'Q' to exit.");

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "w":
                    navigation.moveUp();
                    break;
                case "a":
                    navigation.moveLeft();
                    break;
                case "s":
                    navigation.moveDown();
                    break;
                case "d":
                    navigation.moveRight();
                    break;
                case "e":
                    System.out.println("Enter the text for the cell: ");
                    String text = scanner.nextLine();
                    enterText(text);
                    break;
                case "q":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static void enterText(String text) {
        navigation.enterText(text);
    }
}

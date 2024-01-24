package entregas.joseLuisRodriguezGonzalez.examen_final;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String clientName = scanner.nextLine();

        Client client = new Client(clientName);
        App newApp = new App(client);

        System.out.println("Welcome!! " + clientName);
        newApp.showMainMenu();

        scanner.close();
    }
}
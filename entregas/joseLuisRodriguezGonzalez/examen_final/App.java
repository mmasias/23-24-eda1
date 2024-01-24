package entregas.joseLuisRodriguezGonzalez.examen_final;

import java.util.Scanner;

public class App {
    private Scanner scanner;
    private Client client;
    private Survey encuesta;

    public App(Client client) {
        this.scanner = new Scanner(System.in);
        this.client = client;
    }

    public void showMainMenu() {
        int option;
        do {
            imprimirMenu();
            option = getValidOption();

            switch (option) {
                case 1:
                    registerClient();
                    break;
                case 2:
                    createNewSurvey();
                    break;
                case 3:
                    openExistingSurvey();
                    break;
                case 4:
                    printResults();
                    break;
                case 0:
                    System.out.println("Exit app...");
                    break;
                default:
                    System.out.println("Invalid Option!!!");
                    break;
            }
        } while (option != 0);
    }

    private void registerClient() {
        System.out.print("Write Client Name: ");
        String clientName = scanner.nextLine();
        client = new Client(clientName);
        System.out.println("Client " + clientName + " registered.");
    }

    private void createNewSurvey() {
        client = new Client(client.getName());
        encuesta = new Survey();
        enterFood();
        System.out.println("Surver created for " + client.getName() + ".");
    }

    private void openExistingSurvey() {
        enterFood();
        System.out.println("Survey for " + client.getName() + " open.");
    }

    private void printResults() {
        System.out.println("Results for " + client.getName() + ":");
        encuesta.getDietInfo();
    }

    private void imprimirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Register new client");
        System.out.println("2. Create new survey");
        System.out.println("3. Edit existing survey");
        System.out.println("4. Mostrar resultados");
        System.out.println("0. Exit app");
    }

    private int getValidOption() {
        int option;
        while (true) {
            try {
                option = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid Number.");
            }
        }
        return option;
    }

    private void enterFood() {
        System.out.println("Enter foods -> type '-1' to finish:");

        int day;
        String intakeType;

        do {
            System.out.print(
                    "Select day \n" + //
                            "1.Monday \n" + //
                            "2.Tuesday \n" + //
                            "3.Wednesday \n" + //
                            "4.Thursday \n" + //
                            "5.Friday, \n" + //
                            "-1 to finish / -2 to list foods: ");
            day = getValidNumber();

            if (day == -1) {
                break;
            }

            if (day == -2) {
                System.out.println("Food list entered:");
                encuesta.getDietInfo();
                continue;
            }

            if (day < 1 || day > 5) {
                System.out.println("Invalid Day");
                continue;
            }

            int intakeOption;
            do {
                printIntakeOptions();
                intakeOption = getValidNumber();

                if (intakeOption == -1) {
                    break;
                }

                if (intakeOption < 1 || intakeOption > 5) {
                    System.out.println("Invalid Option");
                    continue;
                }

                intakeType = getIntakeType(intakeOption);
                System.out
                        .println("Enter food for " + intakeType + " from day " + day + " -> -1 to finish:");

                while (true) {
                    System.out.print("Enter a food: ");
                    String foodName = scanner.nextLine().trim();

                    if (foodName.equalsIgnoreCase("-1")) {
                        break;
                    }

                    Food food = new Food(foodName);
                    encuesta.addFood(food, day, intakeType);
                }
            } while (true);

        } while (true);
    }

    private void printIntakeOptions() {
        System.out.println("Select the intake you want to edit:");
        System.out.println("1. Breakfast");
        System.out.println("2. Midmorning");
        System.out.println("3. Lunch");
        System.out.println("4. Snack");
        System.out.println("5. Dinner");
        System.out.println("-1. Exit");
    }

    private String getIntakeType(int option) {
        switch (option) {
            case 1:
                return "Breakfast";
            case 2:
                return "Midmorning";
            case 3:
                return "Lunch";
            case 4:
                return "Snack";
            case 5:
                return "Dinner";
            default:
                return "";
        }
    }

    private int getValidNumber() {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }
        return number;
    }
}
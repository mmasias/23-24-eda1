package Reto007;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa tu nombre porfavor: ");
        String clientName = scanner.nextLine();

        System.out.println("Bienvenido " + clientName);

        int option;
        Cliente cliente = new Cliente(clientName);

        do {
            printMenu();
            System.out.print("Escoge una opcion: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    // Registrar nuevo cliente
                    System.out.print("ingresa el nombre del cliente: ");
                    String newClientName = scanner.nextLine();
                    cliente = new Cliente(newClientName);
                    System.out.println("Cliente " + newClientName + " registrado.");
                    break;
                case 2:
                    // Crear nueva encuesta
                    ingresarAlimentos(scanner, cliente);
                    System.out.println("Encuesta creada para " + clientName + ".");
                    break;
                case 3:
                    // Abrir encuesta existente
                    ingresarAlimentos(scanner, cliente);
                    System.out.println("Encuesta de" + clientName + " se ejecuto con éxito.");
                    break;
                case 4:
                    // Mostrar resultados
                    cliente.mostrarDieta();
                    break;
                case 0:
                    // Salir del programa
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Ingresa un numero correcto porfavor.");
                    break;
            }

        } while (option != 0);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Menú:");
        System.out.println("1. Registrar nuevo cliente");
        System.out.println("2. Nueva encuesta");
        System.out.println("3. Abrir encuesta existente");
        System.out.println("4. Mostrar resultados");
        System.out.println("0. Salir");
    
    }

    private static void ingresarAlimentos(Scanner scanner, Cliente cliente) {
        System.out.println("Ingresa las ingestas (escribe -1 para terminar):");

        int day;
        String mealType;

        do {
            System.out.print("Elige el dia (1-5, -1 para finalizar / -2 para listar las ingestas): ");
            day = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if (day == -1) {
                break;
            }

            if (day == -2) {
                System.out.println("Ingestas registradas:");
                cliente.mostrarDieta();
                continue;  
            }

            if (day < 1 || day > 5) {
                System.out.println("Dia invalido.Ingresa una fecha correcta.");
                continue;
            }

            System.out.println("Seleccione la ingesta que quiere editar:");
            System.out.println("1. Desayuno");
            System.out.println("2. Media Mañana");
            System.out.println("3. Almuerzo");
            System.out.println("4. Merienda");
            System.out.println("5. Cena");
            System.out.println("-1. Salir");

            int mealOption;
            do {
                System.out.print("Opcion: ");
                mealOption = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                if (mealOption == -1) {
                    break;
                }

                if (mealOption < 1 || mealOption > 5) {
                    System.out.println("Ingresa una opcion correcta porfavor.");
                    continue;
                }

                mealType = getMealType(mealOption);
                System.out.println("Ingresa las ingestas " + mealType + " en el dia " + day + " (-1 para finalizar / -2 para listar las ingestas):");

                // Enter foods until the user decides to stop
                while (true) {
                    System.out.print("Ingresa una ingesta: ");
                    String foodName = scanner.nextLine().trim();

                    if (foodName.equalsIgnoreCase("-1")) {
                        break;
                    }

                    Alimentos food = new Alimentos(foodName);
                    cliente.agregarAlimento(food, day, mealType);
                }
            } while (true);

        } while (true);
    }

    private static String getMealType(int option) {
        switch (option) {
            case 1:
                return "Desayuno";
            case 2:
                return "Media Mañana";
            case 3:
                return "Almuerzo2";
            case 4:
                return "Merienda";
            case 5:
                return "Cena";
            default:
                return "";
        }
    }
}

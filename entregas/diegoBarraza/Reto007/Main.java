package Reto007;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombreCliente = scanner.nextLine();

        System.out.println("Bienvenido " + nombreCliente);

        int opcion;
        Cliente cliente = new Cliente(nombreCliente);

        do {
            imprimirMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Registrar nuevo cliente
                    System.out.print("Ingrese el nombre del nuevo cliente: ");
                    String nuevoNombreCliente = scanner.nextLine();
                    cliente = new Cliente(nuevoNombreCliente);
                    System.out.println("Cliente " + nuevoNombreCliente + " registrado exitosamente.");
                    break;
                case 2:
                    // Crear nueva encuesta
                    cliente = new Cliente(nombreCliente);  // Reiniciar la instancia del Cliente
                    ingresarAlimentos(scanner, cliente);
                    System.out.println("Encuesta creada exitosamente para el cliente " + nombreCliente + ".");
                    break;
                case 3:
                    // Abrir encuesta existente
                    ingresarAlimentos(scanner, cliente);
                    System.out.println("Encuesta para el cliente " + nombreCliente + " abierta exitosamente.");
                    break;
                case 4:
                    // Mostrar resultados
                    cliente.mostrarDieta();
                    break;
                case 0:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void imprimirMenu() {
        System.out.println("Menú:");
        System.out.println("1. Registrar nuevo cliente");
        System.out.println("2. Crear nueva encuesta");
        System.out.println("3. Editar encuesta existente");
        System.out.println("4. Mostrar resultados");
        System.out.println("0. Salir");
    }

    private static void ingresarAlimentos(Scanner scanner, Cliente cliente) {
        System.out.println("Ingrese alimentos (escriba '-1' para finalizar):");

        int dia;
        String tipoIngesta;

        do {
            System.out.print("Seleccione día (1-5, -1 para finalizar / -2 para listar alimentos): ");
            dia = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if (dia == -1) {
                break;
            }

            if (dia == -2) {
                System.out.println("Alimentos ingresados:");
                cliente.mostrarDieta();
                continue;  
            }

            if (dia < 1 || dia > 5) {
                System.out.println("Día no válido. Inténtelo de nuevo.");
                continue;
            }

            int opcionIngesta;
            do {
                imprimirOpcionesIngesta();  // Muestra las opciones de ingestas
                System.out.print("Seleccione la ingesta que quiere editar: ");
                opcionIngesta = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                if (opcionIngesta == -1) {
                    break;
                }

                if (opcionIngesta < 1 || opcionIngesta > 5) {
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    continue;
                }

                tipoIngesta = obtenerTipoIngesta(opcionIngesta);
                System.out.println("Ingrese alimentos para " + tipoIngesta + " del día " + dia + " (-1 para terminar):");

                // Ingresar alimentos hasta que el usuario decida parar
                while (true) {
                    System.out.print("Ingrese un alimento: ");
                    String nombreAlimento = scanner.nextLine().trim();

                    if (nombreAlimento.equalsIgnoreCase("-1")) {
                        break;
                    }

                    Alimentos alimento = new Alimentos(nombreAlimento);
                    cliente.agregarAlimento(alimento, dia, tipoIngesta);
                }
            } while (true);

        } while (true);
    }

    private static void imprimirOpcionesIngesta() {
        System.out.println("Seleccione la ingesta que quiere editar:");
        System.out.println("1. Desayuno");
        System.out.println("2. Media Mañana");
        System.out.println("3. Almuerzo");
        System.out.println("4. Merienda");
        System.out.println("5. Cena");
        System.out.println("-1. Salir");
    }

    private static String obtenerTipoIngesta(int opcion) {
        switch (opcion) {
            case 1:
                return "Desayuno";
            case 2:
                return "Media Mañana";
            case 3:
                return "Almuerzo";
            case 4:
                return "Merienda";
            case 5:
                return "Cena";
            default:
                return "";
        }
    }
}

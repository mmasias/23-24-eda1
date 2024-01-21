import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingresar el nombre del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nombreCliente);

        ingresarAlimentos(scanner, cliente);

        // Mostrar información de la dieta
        cliente.mostrarDieta();

        scanner.close();
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

            System.out.print("Seleccione tipo de ingesta (Desayuno, Media Mañana, Almuerzo, Merienda, Cena): ");
            tipoIngesta = scanner.nextLine().trim();

            // Ingresar alimentos hasta que el usuario decida parar
            while (true) {
                System.out.print("Ingrese un alimento (escriba 'fin' para terminar): ");
                String nombreAlimento = scanner.nextLine().trim();

                if (nombreAlimento.equalsIgnoreCase("fin")) {
                    break;
                }

                Alimentos alimento = new Alimentos(nombreAlimento);
                cliente.agregarAlimento(alimento, dia, tipoIngesta);
            }

        } while (true);
    }
}

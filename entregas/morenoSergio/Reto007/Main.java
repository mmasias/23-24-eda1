import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numeroDia = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();

        LocalDate fechaAlta = Fechas.obtenerFecha("Ingrese la fecha de alta del paciente (dd-MM-yyyy):");
        LocalDate fechaEncuesta = Fechas.obtenerFecha("Ingrese la fecha de toma de la encuesta (dd-MM-yyyy):");

        System.out.println("Bienvenido al Sistema de Gestión de encuestas");
        System.out.println("Paciente: " + nombrePaciente + ".");

        EncuestaNutricional encuesta = new EncuestaNutricional(nombrePaciente);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Seleccionar día");
            System.out.println("2. Registrar comida");
            System.out.println("3. Mostrar datos");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if(opcion >=1 && opcion <= 4) {
                switch (opcion) {
                    case 1:
                        boolean continuar = true;
                        while (continuar == true){
                        System.out.print("Ingrese el número del día: ");
                        numeroDia = scanner.nextInt();
                        scanner.nextLine();
                            if(numeroDia >= 1 && numeroDia <= 5) {
                                encuesta.agregarDia(numeroDia);
                                System.out.println("Día " + numeroDia + " agregado correctamente.");
                                continuar = false;
                            } else {
                                continuar = true;
                            }
                        }
                        break;

                    case 2:
                        int diaRegistro = numeroDia;

                        System.out.print("Ingrese el tipo de ingesta (1-Desayuno, 2-Media mañana, 3-Almuerzo, 4-Merienda, 5-Cena): ");
                        int opcionIngesta = scanner.nextInt();
                        scanner.nextLine();
                        String tipoIngesta = "";

                        switch (opcionIngesta) {
                            case 1:
                                tipoIngesta = "Desayuno";
                                break;
                            case 2:
                                tipoIngesta = "Media mañana";
                                break;
                            case 3:
                                tipoIngesta = "Almuerzo";
                                break;
                            case 4:
                                tipoIngesta = "Merienda";
                                break;
                            case 5:
                                tipoIngesta = "Cena";
                                break;
                            default:
                                System.out.println("Opción no válida. Intente nuevamente.");
                                opcionIngesta = scanner.nextInt();
                                scanner.nextLine();  // Consumir la nueva línea después de nextInt()
                                break;
                        }

                        System.out.print("Ingrese el nombre del alimento: ");
                        String nombreAlimento = scanner.nextLine();

                        encuesta.registrarAlimento(diaRegistro, tipoIngesta, nombreAlimento);
                        System.out.println("Alimento registrado correctamente.");
                        break;

                    case 3:
                        encuesta.mostrarEncuesta(fechaAlta, fechaEncuesta);
                        break;

                    case 4:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        System.exit(0);

                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
                opcion = scanner.nextInt();
                scanner.nextLine();
            }
            }
        }
    }
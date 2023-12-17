import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SistemaEncuestas {
    private Paciente paciente;
    private Scanner scanner;

    public SistemaEncuestas() {
        this.paciente = new Paciente("");
        this.scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        // Solicitar el nombre del paciente al inicio
        System.out.print("Ingrese el nombre del paciente: ");
        paciente.nombre = scanner.nextLine();

        int opcion;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Llenar encuesta para un día");
            System.out.println("2. Mostrar estructura actual");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    llenarEncuesta();
                    break;
                case 2:
                    mostrarEstructura();
                    break;
                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 3);
    }

    private void llenarEncuesta() {
        System.out.print("Ingrese el número del día (1-5): ");
        int numeroDia = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt()

        if (numeroDia < 1 || numeroDia > 5) {
            System.out.println("Número de día no válido. Debe estar entre 1 y 5.");
            return;
        }

        Dia dia = paciente.obtenerDia(numeroDia);
        if (dia == null) {
            dia = new Dia();
            paciente.agregarDia(numeroDia, dia);
        }

        System.out.print("Ingrese el tipo de ingesta (Desayuno/Media mañana/Almuerzo/Merienda/Cena): ");
        String tipoIngesta = scanner.nextLine();

        if (!validarTipoIngesta(tipoIngesta)) {
            System.out.println("Tipo de ingesta no válido. Inténtelo de nuevo.");
            return;
        }

        llenarIngesta(dia, tipoIngesta);
        System.out.println("Encuesta para el día " + numeroDia + " completada.");
    }

    private boolean validarTipoIngesta(String tipoIngesta) {
        List<String> tiposIngesta = obtenerTiposIngesta();
        return tiposIngesta.contains(tipoIngesta);
    }

    private void llenarIngesta(Dia dia, String tipoIngesta) {
        Ingesta ingesta = dia.obtenerIngesta(tipoIngesta);
        if (ingesta == null) {
            ingesta = new Ingesta();
            dia.agregarIngesta(tipoIngesta, ingesta);
        }

        System.out.println("Ingrese alimentos para " + tipoIngesta + " (ingrese '-1' para terminar): ");
        String nombreAlimento;
        while (true) {
            System.out.print("Alimento: ");
            nombreAlimento = scanner.nextLine();

            if (nombreAlimento.equals("-1")) {
                break;
            }

            Alimento alimento = new Alimento(nombreAlimento);
            ingesta.agregarAlimento(tipoIngesta, alimento);
        }
    }

    private void mostrarEstructura() {
        System.out.println("Estructura actual:");
        System.out.println("Paciente: " + paciente.nombre);
        for (int i = 1; i <= 5; i++) {
            Dia diaActual = paciente.obtenerDia(i);
            if (diaActual != null) {
                System.out.println("    Encuesta Dia " + i);
                for (String tipoIngesta : obtenerTiposIngesta()) {
                    Ingesta ingestaActual = diaActual.obtenerIngesta(tipoIngesta);
                    if (ingestaActual != null) {
                        System.out.println("        " + tipoIngesta);
                        List<Alimento> alimentos = ingestaActual.obtenerAlimentos(tipoIngesta);
                        for (Alimento alimento : alimentos) {
                            System.out.println("            " + alimento);
                        }
                    }
                }
            }
        }
    }

    private List<String> obtenerTiposIngesta() {
        List<String> tiposIngesta = new ArrayList<>();
        tiposIngesta.add("Desayuno");
        tiposIngesta.add("Media mañana");
        tiposIngesta.add("Almuerzo");
        tiposIngesta.add("Merienda");
        tiposIngesta.add("Cena");
        return tiposIngesta;
    }
}

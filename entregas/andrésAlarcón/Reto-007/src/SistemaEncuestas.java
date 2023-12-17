import java.util.List;
import java.util.Scanner;

public class SistemaEncuestas {
    private String nombrePaciente;

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el nombre del paciente al inicio
        System.out.print("Ingrese el nombre del paciente: ");
        nombrePaciente = scanner.nextLine();

        Paciente paciente = new Paciente(nombrePaciente);

        System.out.print("Ingrese el número del día: ");
        int numeroDia = scanner.nextInt();

        Dia dia = new Dia();

        System.out.print("Ingrese tipo de ingesta (Desayuno/Media mañana/Almuerzo/Merienda/Cena): ");
        String tipoIngesta = scanner.next();

        Ingesta ingesta = new Ingesta();

        System.out.println("Ingrese alimentos consumidos (ingrese '-1' para terminar): ");
        String nombreAlimento;
        while (true) {
            System.out.print("Alimento: ");
            nombreAlimento = scanner.next();

            if (nombreAlimento.equals("-1")) {
                break;
            }

            Alimento alimento = new Alimento(nombreAlimento);
            ingesta.agregarAlimento(tipoIngesta, alimento);
        }

        dia.agregarIngesta(tipoIngesta, ingesta);

        paciente.agregarDia(numeroDia, dia);

        Dia diaObtenido = paciente.obtenerDia(numeroDia);
        if (diaObtenido != null) {
            Ingesta ingestaObtenida = diaObtenido.obtenerIngesta(tipoIngesta);
            if (ingestaObtenida != null) {
                List<Alimento> alimentosConsumidos = ingestaObtenida.obtenerAlimentos(tipoIngesta);

                System.out.println("Paciente: " + paciente.nombre);
                System.out.println("Día: " + numeroDia);
                System.out.println("Tipo de ingesta: " + tipoIngesta);
                System.out.println("Alimentos consumidos:");
                for (Alimento alimento : alimentosConsumidos) {
                    System.out.println(" - " + alimento);
                }
            } else {
                System.out.println("No se encontró información de la ingesta para el tipo ingresado.");
            }
        } else {
            System.out.println("No se encontró información del día ingresado.");
        }
    }
}

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestion {
    private List<Paciente> pacientes;

    public Gestion() {
        pacientes = new ArrayList<>();
    }

    public void iniciarInterfazUsuario() {
        Scanner scanner = new Scanner(System.in);
        Paciente paciente = buscarOCrearPaciente(scanner);

        LocalDate fechaAlta = paciente.getFechaAlta();

        LocalDate fechaEncuesta;
        while (true) {
            System.out.print("Ingrese la fecha de la encuesta (formato dd/MM/yyyy) o 'salir' para terminar: ");
            String input = scanner.nextLine();
            if ("salir".equalsIgnoreCase(input)) break;

            try {
                fechaEncuesta = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Encuesta encuesta = buscarOCrearEncuesta(paciente, fechaEncuesta);
                manejarDias(scanner, encuesta);
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Por favor, intente de nuevo.");
            }
        }

        System.out.println(paciente);
        scanner.close();
    }

    private Paciente buscarOCrearPaciente(Scanner scanner) {
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();

        for (Paciente p : pacientes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }

        Paciente nuevoPaciente = new Paciente(nombre);
        System.out.print("Ingrese el peso del paciente (kg): ");
        nuevoPaciente.setPeso(scanner.nextDouble());
        System.out.print("Ingrese la altura del paciente (cm): ");
        nuevoPaciente.setAltura(scanner.nextInt());
        System.out.print("Ingrese la edad del paciente: ");
        nuevoPaciente.setEdad(scanner.nextInt());
        System.out.print("Ingrese el sexo del paciente (m/f): ");
        nuevoPaciente.setSexo(scanner.next().charAt(0));
        System.out.print("Ingrese el DNI del paciente: ");
        nuevoPaciente.setDni(scanner.next());
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese la fecha de alta del paciente (formato dd/MM/yyyy): ");
        try {
            LocalDate fechaAlta = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            nuevoPaciente.setFechaAlta(fechaAlta);
        } catch (Exception e) {
            System.out.println("Formato de fecha de alta inválido. Se usará la fecha actual.");
            nuevoPaciente.setFechaAlta(LocalDate.now());
        }

        pacientes.add(nuevoPaciente);
        return nuevoPaciente;
    }

    private Encuesta buscarOCrearEncuesta(Paciente paciente, LocalDate fecha) {
        for (Encuesta encuesta : paciente.getEncuestas()) {
            if (encuesta.getFechaEncuesta().equals(fecha)) {
                return encuesta;
            }
        }
        Encuesta nuevaEncuesta = new Encuesta(fecha);
        paciente.agregarEncuesta(nuevaEncuesta);
        return nuevaEncuesta;
    }

    private void manejarDias(Scanner scanner, Encuesta encuesta) {
        int numeroDia;
        while (true) {
            System.out.print("Seleccione un día para ingresar datos (1-7) o -1 para terminar: ");
            numeroDia = scanner.nextInt();
            if (numeroDia == -1) break;
            if (numeroDia < 1 || numeroDia > 7) {
                System.out.println("Número de día inválido. Por favor, seleccione un número entre 1 y 7.");
                continue;
            }
            Dia dia = buscarOCrearDia(encuesta, numeroDia);
            manejarIngestas(scanner, dia);
        }
    }

    private Dia buscarOCrearDia(Encuesta encuesta, int numeroDia) {
        for (Dia dia : encuesta.getDias()) {
            if (dia.getNumeroDia() == numeroDia) {
                return dia;
            }
        }
        Dia nuevoDia = new Dia(numeroDia);
        encuesta.agregarDia(nuevoDia);
        return nuevoDia;
    }

    private void manejarIngestas(Scanner scanner, Dia dia) {
        while (true) {
            System.out.print("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú anterior): ");
            int opcion = scanner.nextInt();
            if (opcion == -1) break;
            if (opcion < 1 || opcion > 5) {
                System.out.println("Número inválido. Las opciones válidas son -1, 1, 2, 3, 4, 5. Intente de nuevo.");
                continue;
            }

            String tipoIngesta = tipoIngestaSegunOpcion(opcion);
            System.out.print("Ingrese la hora para el " + tipoIngesta + " (formato HH:mm): ");
            LocalTime horaIngesta = LocalTime.parse(scanner.next(), DateTimeFormatter.ofPattern("HH:mm"));
            Ingesta ingesta = dia.buscarIngesta(tipoIngesta);
            if (ingesta == null) {
                ingesta = new Ingesta(tipoIngesta, horaIngesta);
                dia.agregarIngesta(ingesta);
            }

            manejarAlimentos(scanner, ingesta);
        }
    }

    private void manejarAlimentos(Scanner scanner, Ingesta ingesta) {
        while (true) {
            System.out.print("Ingrese un alimento para " + ingesta.getTipoComida() + " (-1 para terminar / -2 para listar alimentos ingresados): ");
            String input = scanner.next();
            if ("-1".equals(input)) break;
            if ("-2".equals(input)) {
                System.out.println(ingesta.listarAlimentos());
                continue;
            }

            double cantidad;
            while (true) {
                System.out.print("Ingrese la cantidad del alimento (en gramos, solo números positivos): ");
                cantidad = scanner.nextDouble();
                if (cantidad > 0) break;
                System.out.println("Por favor, ingrese un valor positivo.");
            }
            ingesta.agregarAlimento(new Alimento(input, cantidad));
        }
    }

    private String tipoIngestaSegunOpcion(int opcion) {
        switch (opcion) {
            case 1: return "Desayuno";
            case 2: return "Media mañana";
            case 3: return "Almuerzo";
            case 4: return "Merienda";
            case 5: return "Cena";
            default: return "Otra";
        }
    }

    public static void main(String[] args) {
        Gestion gestion = new Gestion();
        gestion.iniciarInterfazUsuario();
    }
}



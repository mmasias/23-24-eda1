import java.util.Scanner;

public class GestionEncuestaLista {
    private Lista<Paciente> pacientes;
    private Scanner scanner;

    public GestionEncuestaLista() {
        this.pacientes = new Lista<>();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("Menú Principal:");
            System.out.println("1. Agregar Paciente");
            System.out.println("2. Gestionar Encuesta de Paciente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarPaciente();
                    break;
                case 2:
                    gestionarEncuestasPaciente();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void agregarPaciente() {
        System.out.print("Ingrese nombre del paciente: ");
        String nombre = scanner.next();
        Paciente paciente = new Paciente(nombre);
        pacientes.add(paciente);
        System.out.println("Paciente agregado con éxito.");
    }

    private void gestionarEncuestasPaciente() {
        System.out.println("Seleccione un paciente:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNombre());
        }
        System.out.print("Ingrese el número del paciente: ");
        int indicePaciente = scanner.nextInt() - 1;
        if (indicePaciente >= 0 && indicePaciente < pacientes.size()) {
            Paciente paciente = pacientes.get(indicePaciente);
            System.out.println("Gestionando encuesta de " + paciente.getNombre());
            gestionarDiasEncuesta(paciente);

        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    private void gestionarDiasEncuesta(Paciente paciente) {
        Encuesta encuesta = paciente.getEncuesta();
        boolean volver = false;
        while (!volver) {
            System.out.println("Seleccione día (1-5) o -1 para volver:");
            int diaSeleccionado = scanner.nextInt();
            if (diaSeleccionado == -1) {
                volver = true;
            } else if (diaSeleccionado >= 1 && diaSeleccionado <= 5) {
                gestionarIngestasDia(paciente.getEncuesta().obtenerDia(diaSeleccionado -1));
            } else {
                System.out.println("Día no válido.");
            }
        }
    }

    private void gestionarIngestasDia(Dia dia) {
        boolean volver = false;
        while (!volver) {
            System.out.println("Seleccione ingesta:");
            for (TipoIngesta tipo : TipoIngesta.values()) {
                System.out.println(tipo.getIndex() + ". " + tipo.getTipo());
              } 
            System.out.println("-1. Volver");
            System.out.print("Opción: ");
            int opcionIngesta = scanner.nextInt();

            if (opcionIngesta == -1) {
                volver = true;
            } else if (opcionIngesta >0 && opcionIngesta <= TipoIngesta.values().length) {
                Ingesta ingesta = dia.obtenerIngesta(opcionIngesta - 1);
                agregarAlimentosIngesta(ingesta);
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private void agregarAlimentosIngesta(Ingesta ingesta) {
        boolean terminar = false;
        while (!terminar) {
            System.out.println("Ingrese un alimento para " + ingesta.getTipo() +
                               " (-1 para terminar, -2 para listar alimentos ingresados):");
            String alimento = scanner.next();
            if (alimento.equals("-1")) {
                terminar = true;
            } else if (alimento.equals("-2")) {
                System.out.println(ingesta.listarAlimentos());
            } else {
                ingesta.agregarAlimento(alimento);
            }
        }
    }

    public static void main(String[] args) {
        GestionEncuestaLista gestionEncuesta = new GestionEncuestaLista();
        gestionEncuesta.iniciar();
    }
}

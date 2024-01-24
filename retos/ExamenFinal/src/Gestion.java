import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gestion {
    private List<Paciente> pacientes;
    private Scanner sc;
    private DateTimeFormatter formato;
    private int ultimoPacienteIndex;

    public Gestion() {
        this.pacientes = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void insertarPaciente() {
        String nombre = "";
        LocalDate fechaDeAlta = null;
        System.out.println("Introduce el nombre del paciente");
        nombre = sc.nextLine();
        boolean ok;
        do {
            ok = true;
            System.out.println("Introduce la fecha de alta del paciente (dd/mm/aaaa)");
            try {
                fechaDeAlta = LocalDate.parse(sc.nextLine(), formato);
            } catch (Exception e) {
                System.out.println("Fecha incorrecta");
                ok = false;
            }

        } while (!ok);

        Paciente paciente = new Paciente(nombre, fechaDeAlta);
        pacientes.add(paciente);
    }

    public void insertarEncuesta() {
        LocalDate fecha = null;
        boolean ok;
        do {
            ok = true;
            System.out.println("Introduce la fecha de la encuesta (dd/mm/aaaa)");
            try {
                fecha = LocalDate.parse(sc.nextLine(), formato);
            } catch (Exception e) {
                System.out.println("Fecha incorrecta");
                ok = false;
            }
        } while (!ok);

        Encuesta encuesta = new Encuesta(fecha);
        pacientes.get(pacientes.size() - 1).addEncuesta(encuesta);
    }

    List<Dia> dias = pacientes.get(ultimoPacienteIndex).getEncuestas()[0].getDias();

    public void insertarIngesta() {
        boolean ok;
        int dia = 0;
        int opcion = 0;
        String opcion2 = "";
        Horario horario = null;

        do {
            do {
                System.out.println("Seleccione el dia: (1/5) / (0 para salir)");
                try {
                    dia = sc.nextInt();
                } catch (Exception e) {
                    dia = -1;
                    System.out.println("Dia no existente");
                }
            } while (dia < 0 || dia > 5);

            if (dia == 0) {
                break;
            }

            Dia diaSeleccionado = obtenerDiaSeleccionado(dia);

            do {
                ok = true;
                System.out.println("Selecciona la ingesta: 1. (Desayuno) / 2. (Media mañana) / 3. (Almuerzo) / 4. (Merienda) / 5. (Cena) / -1. (Menu anterior)");
                try {
                    opcion = sc.nextInt();
                } catch (NumberFormatException e) {
                    System.out.println("Opcion incorrecta");
                    ok = false;
                }

                switch (opcion) {
                    case 1:
                        horario = Horario.DESAYUNO;
                        break;
                    case 2:
                        horario = Horario.MEDIA_MAÑANA;
                        break;
                    case 3:
                        horario = Horario.ALMUERZO;
                        break;
                    case 4:
                        horario = Horario.MERIENDA;
                        break;
                    case 5:
                        horario = Horario.CENA;
                        break;
                    case -1:
                        break;
                    default:
                        ok = false;
                        System.out.println("Opcion incorrecta");
                        break;
                }
            } while (!ok);

            if (opcion != -1) {
                Ingesta ing = new Ingesta(horario);
                ingresarAlimento(ing);

                if (diaSeleccionado != null) {
                    diaSeleccionado.addIngesta(ing);
                }
            }
        } while (true);
    }

    private Dia obtenerDiaSeleccionado(int dia) {
        Dia diaSeleccionado = null;

        if (!pacientes.isEmpty() && pacientes.get(pacientes.size() - 1).getEncuestas() != null && pacientes.get(pacientes.size() - 1).getEncuestas().length > 0) {
            Encuesta ultimaEncuesta = pacientes.get(pacientes.size() - 1).getEncuestas()[0];

            if (ultimaEncuesta.getDias() != null && ultimaEncuesta.getDias().size() > 0 && dia >= 1 && dia <= ultimaEncuesta.getDias().size()) {
                diaSeleccionado = ultimaEncuesta.getDias().get(dia - 1);
            }
        }

        return diaSeleccionado;
    }

    private void ingresarAlimento(Ingesta ing) {
        boolean ok;
        String opcion2;

        do {
            System.out.println("Ingrese un alimento del " + ing.getHorario().getDescription() + ". (-1 para terminar) / (-2 para listar alimentos ingresados) / (-3 para borrar todos los alimentos)");
            opcion2 = sc.nextLine();

            if (opcion2.equals("-2")) {
                System.out.println("Los alimentos son: " + ing.getInformacion());
            } else if (opcion2.equals("")) {
                System.out.println("Alimento no valido");

            } else if (opcion2.equals("-3")) {
                ing.getAlimentos().clear();
            } else if (!opcion2.equals("-1")) {
                do {
                    ok = true;
                    System.out.println("Introduce los gramos del alimento: ");
                    try {
                        int gramos = sc.nextInt();
                        ing.addAlimento(new Alimento(opcion2, gramos));
                    } catch (InputMismatchException e) {
                        System.out.println("Gramos incorrectos");
                        ok = false;
                    }
                } while (!ok);
            }
        } while (!opcion2.equals("-1"));
    }

    public void capturarDatos() {
        insertarPaciente();
        insertarEncuesta();
        insertarDia();
        insertarIngesta();
    }

    private void insertarDia() {
        boolean ok;
        int dia = 0;
        int opcion = 0;
        String opcion2 = "";
        Horario horario = null;

        do {
            do {
                System.out.println("Seleccione el dia: (1/5) / (0 para salir)");
                try {
                    dia = sc.nextInt();
                } catch (Exception e) {
                    dia = -1;
                    System.out.println("Dia no existente");
                }
            } while (dia < 0 || dia > 5);

            if (dia == 0) {
                break;
            }

            Dia diaSeleccionado = obtenerDiaSeleccionado(dia);

            do {
                ok = true;
                System.out.println("Selecciona la ingesta: 1. (Desayuno) / 2. (Media mañana) / 3. (Almuerzo) / 4. (Merienda) / 5. (Cena) / -1. (Menu anterior)");
                try {
                    opcion = sc.nextInt();
                } catch (NumberFormatException e) {
                    System.out.println("Opcion incorrecta");
                    ok = false;
                }

                switch (opcion) {
                    case 1:
                        horario = Horario.DESAYUNO;
                        break;
                    case 2:
                        horario = Horario.MEDIA_MAÑANA;
                        break;
                    case 3:
                        horario = Horario.ALMUERZO;
                        break;
                    case 4:
                        horario = Horario.MERIENDA;
                        break;
                    case 5:
                        horario = Horario.CENA;
                        break;
                    case -1:
                        break;
                    default:
                        ok = false;
                        System.out.println("Opcion incorrecta");
                        break;
                }
            } while (!ok);

            if (opcion != -1) {
                Ingesta ing = new Ingesta(horario);
                ingresarAlimento(ing);

                if (diaSeleccionado != null) {
                    diaSeleccionado.addIngesta(ing);
                }
            }
        } while (true);
    }

    public void mostrar() {
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getInformacion());
            for (Encuesta encuesta : paciente.getEncuestas()) {
                System.out.println(encuesta.getInformacion());
                for (Dia dia : encuesta.getDias()) {
                    System.out.println(dia.getInformacion());
                    for (Ingesta ingesta : dia.getIngestas()) {
                        System.out.println(ingesta.getInformacion());
                    }
                }
            }
        }
    }

    public void cerrarScanner() {
        if (sc != null) {
            sc.close();
        }
    }
}

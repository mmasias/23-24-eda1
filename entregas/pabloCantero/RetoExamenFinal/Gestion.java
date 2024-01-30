package RetoExamenFinal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Gestion {

    private Scanner escaner;
    private List<Paciente> listaPacientes;
    private DateTimeFormatter formato;

    public Gestion() {
        this.listaPacientes = new ArrayList<>();
        this.escaner = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void insertarPaciente() {
        String nombre;
        LocalDate fechaAlta = null;
        boolean ok = true;
        System.out.println("Introduzca el nombre: ");
        nombre = escaner.nextLine();
        do {
            System.out.println("Introduzca la fecha de alta con el siguiente formato (dd/MM/yyyy): ");
            try {
                ok = true;
                fechaAlta = LocalDate.parse(escaner.nextLine(), formato);
            } catch (Exception e) {
                System.out.println("Fecha incorrecta, escriba una valida");
                ok = false;
            }
        } while (!ok);

        Paciente paciente = new Paciente(fechaAlta, nombre);
        listaPacientes.add(paciente);
    }

    public void insertarEncuesta() {
        LocalDate fechaEncuesta = null;
        boolean ok = true;

        if (!listaPacientes.isEmpty()) {
            Paciente paciente = listaPacientes.get(0);
            LocalDate fechaAlta = paciente.getFechaDeAlta();

            do {
                System.out.println("Introduzca la fecha de la encuesta con el siguiente formato (dd/MM/yyyy): ");
                try {
                    ok = true;
                    fechaEncuesta = LocalDate.parse(escaner.nextLine(), formato);
                    if (fechaEncuesta.isBefore(fechaAlta)) {
                        System.out.println("Error: La fecha de la encuesta no puede ser anterior a la fecha de alta.");
                        ok = false;
                    }
                } catch (Exception e) {
                    System.out.println("Fecha incorrecta, escriba una válida");
                    ok = false;
                }
            } while (!ok);

            Encuesta encuesta = new Encuesta(fechaEncuesta);
            paciente.setEncuesta(encuesta);
        } else {
            System.out.println("Error: No hay pacientes para realizar la encuesta.");
        }
    }

    public void insertarDias() {
        if (!listaPacientes.isEmpty()) {
            Paciente paciente = listaPacientes.get(0);
            Encuesta encuesta = paciente.getEncuesta();
            if (encuesta != null) {
                List<Dia> diasEncuesta = encuesta.getDias();
                for (int i = 1; i <= 5; i++) {
                    Dia dia = new Dia(i);
                    diasEncuesta.add(dia);
                }
            } else {
                System.out.println("Error: No hay encuesta para añadir días.");
            }
        } else {
            System.out.println("Error: No hay pacientes para añadir días.");
        }
    }

    public void insertarIngestas() {
        if (!listaPacientes.isEmpty()) {
            Paciente paciente = listaPacientes.get(0);
            Encuesta encuesta = paciente.getEncuesta();
            if (encuesta != null) {
                List<Dia> diasEncuesta = encuesta.getDias();
                int dia = obtenerDia();
                if (dia > 0 && dia <= diasEncuesta.size()) {
                    Dia diaSeleccionado = diasEncuesta.get(dia - 1);
                    Ingesta ing = obtenerIngesta();
                    if (ing != null) {
                        diaSeleccionado.addIngesta(ing);
                        gestionarAlimentos(ing);
                    }
                } else {
                    System.out.println("Error: El índice del día no es válido.");
                }
            } else {
                System.out.println("Error: No hay encuesta para añadir ingestas.");
            }
        } else {
            System.out.println("Error: No hay pacientes para añadir ingestas.");
        }
    }

    private int obtenerDia() {
        int dia = -1;
        boolean ok = true;

        do {
            System.out.println("Seleccione día (1-5) (0 para salir): ");
            try {
                dia = escaner.nextInt();
                ok = true;
            } catch (InputMismatchException e) {
                escaner.nextLine();
                dia = -1;
                System.out.println("Error: Ingrese un número válido.");
                ok = false;
            }

            if (dia < 0 || dia > 5) {
                System.out.println("Error: El día debe estar entre 1 y 5, o 0 para salir.");
                ok = false;
            }

        } while (!ok);

        return dia;
    }

    private Ingesta obtenerIngesta() {
        int opcion = 0;
        boolean ok = true;
        Ingesta ing = null;

        do {
            ok = true;
            System.out.println("Seleccione ingesta: 1-Desayuno / 2-Media Mañana / 3-Almuerzo /4-Merienda / 5-Cena/ -1 - (Menu Anterior)");
            try {
                opcion = escaner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Inserte un número, no una letra");
                escaner.nextLine();
                ok = false;
            }
            switch (opcion) {
                case 1:
                    ing = new Ingesta(Horario.DESAYUNO);
                    break;
                case 2:
                    ing = new Ingesta(Horario.MEDIAMAÑANA);
                    break;
                case 3:
                    ing = new Ingesta(Horario.ALMUERZO);
                    break;
                case 4:
                    ing = new Ingesta(Horario.MERIENDA);
                    break;
                case 5:
                    ing = new Ingesta(Horario.CENA);
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Opcion incorrecta, elige otra");
                    ok = false;
                    break;
            }
        } while (!ok);

        return ing;
    }

    private void gestionarAlimentos(Ingesta ing) {
        String opcionAlimento = null;
        do {
            System.out.println("Inserte un alimento del " + ing.getHorario().getDescription() + " (-1 para terminar / -2 para listar alimentos ingresados / -3 para vaciar)");
            opcionAlimento = escaner.nextLine();

            if (opcionAlimento.equals("-2")) {
                System.out.println("Los alimentos ya ingresados son: \n" + ing.getInformacion());
            } else if (opcionAlimento.equals("-3")) {
                ing.vaciar();
            } else if (!opcionAlimento.equals("-1")) {
                boolean isNumeric = true;
                int gramos = 0;
                do {
                    try {
                        System.out.println("Introduzca la cantidad de gramos: ");
                        gramos = Integer.parseInt(opcionAlimento);
                        if (gramos <= 0) {
                            System.out.println("Error: La cantidad de gramos no puede ser negativa.");
                            isNumeric = false;
                        } else {
                            isNumeric = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingrese solo números para la cantidad de gramos.");
                        isNumeric = false;
                    }
                } while (!isNumeric);

                ing.insertarAlimento(new Alimento(opcionAlimento, gramos));
            }
        } while (!opcionAlimento.equals("-1"));
    }

    public void capturarDatos() {
        insertarPaciente();
        insertarEncuesta();
        insertarDias();
        insertarIngestas();
    }
    public void mostrar() {
       
    }
    
    

}



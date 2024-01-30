import Coleciones.GenericList;
import Coleciones.IDataStructure;
import clases.Alimento;
import clases.Encuesta;
import clases.Horario;
import clases.Ingesta;
import clases.Persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Gestion {
    private GenericList<IDataStructure> datos;
    private DateTimeFormatter formato;
    private Scanner sc;

    public Gestion() {
        datos = new GenericList<>();
        formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sc = new Scanner(System.in);
    }

    public void insertarActualizarPaciente() {
        System.out.println("Introduzca nombre del paciente");
        String nombre = sc.nextLine();

        LocalDate fecha = null;
        boolean ok = true;
        do {
            ok = true;
            try {
                System.out.println("Introduzca fecha de alta (dd/mm/yyyy)");
                fecha = LocalDate.parse(sc.nextLine(), formato);
            } catch (Exception e) {
                ok = false;
            }
        } while (!ok);

        if (datos.isEmpty()) {
            datos.insertFront(new Persona(nombre, fecha));

        } else {
            datos.get(0).setValue(new Persona(nombre, fecha));
        }
    }

    public void insertarEncuesta() {
        if (!datos.isEmpty()) {
            LocalDate fecha = null;
            boolean ok = true;
            do {
                ok = true;
                try {
                    System.out.println("Introduzca fecha de la encuesta (dd/mm/yyyy)");
                    fecha = LocalDate.parse(sc.nextLine(), formato);
                } catch (Exception e) {
                    ok = false;
                }
            } while (!ok);

            datos.get(0).insertarHijos(new Encuesta(fecha));
        }
    }


    public void insertarIngesta() {
        if (datos.size() > 0) {
            System.out.println("Hay 5 días");

            int dia = 0;
            boolean ok;
            do {
                do {
                    ok = true;
                    System.out.println("Seleccione día / -1 (Salir)");
                    try {
                        dia = sc.nextInt();
                        if ((dia < 1 || dia > 5) {
                            System.out.println("El día seleccionado no existe");
                            ok = false;
                        }
                        if (dia == -1) {
                            return;
                        }
                    } catch (Exception e) {
                        System.out.println("Día no válido");
                        ok = false;
                        sc.nextLine(); // Consumir la entrada incorrecta
                    }
                } while (!ok);

                IDataStructure diaSeleccionado = (IDataStructure) datos.get(0).insertarHijos().get(dia - 1);
                System.out.println("---------" + diaSeleccionado.getInformacion());

                int opcion;
                do {
                    System.out.println(
                            "Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú anterior)");
                    opcion = sc.nextInt();

                    if (opcion >= 1 && opcion <= 5) {
                        Horario horario = obtenerHorarioDesdeOpcion(opcion);
                        IDataStructure ingesta = obtenerOInsertarIngesta(diaSeleccionado, horario);

                        String opcion2;
                        do {
                            System.out.println("Ingrese un alimento de " + horario.getNombre() + " del día " + dia
                                    + " -1 para terminar) / -2 para listar alimentos ingresados)");
                            sc.nextLine(); // Consumir la nueva línea pendiente
                            opcion2 = sc.nextLine();

                            if (opcion2.equals("-2")) {
                                System.out.println(((Ingesta) ingesta).getInformacion());
                            } else if (!opcion2.equals("-1")) {
                                System.out.println("Cantidad (gr.):");
                                int cantidad = sc.nextInt();
                                ((Ingesta) ingesta).insertarAlimento(new Alimento(opcion2, cantidad));
                            }
                        } while (!opcion2.equals("-1"));
                    } else if (opcion != -1) {
                        System.out.println("Opción no válida");
                    }
                } while (opcion != -1);
            } while (true);
        }
    }

    private Horario obtenerHorarioDesdeOpcion(int opcion) {
        switch (opcion) {
            case 1:
                return Horario.DESAYUNO;
            case 2:
                return Horario.MEDIA_MAÑANA;
            case 3:
                return Horario.ALMUERZO;
            case 4:
                return Horario.MERIENDA;
            case 5:
                return Horario.CENA;
            default:
                return null; // Manejar errores o lanzar una excepción según tus necesidades
        }
    }

    private IDataStructure obtenerOInsertarIngesta(IDataStructure dia, Horario horario) {
        for (IDataStructure ingesta : dia.insertarHijos())
            if (((Ingesta) ingesta).getHorario() == horario) {
                return ingesta;
            }

        Ingesta nuevaIngesta = new Ingesta(horario);
        dia.insertarHijos(nuevaIngesta);
        return nuevaIngesta;
    }
    public void capturarDatos() {
        this.insertarActualizarPaciente();
        this.insertarEncuesta();
        this.insertarIngesta();
    }
    public void mostrar() {
        for (int i = 0; i < datos.size(); i++) {
            System.out.println(datos.get(i).getInformacion());
        }
    }
}
import Coleciones.Arbol;
import Coleciones.GenericList;
import Coleciones.IDataStructure;
import Coleciones.NodoArbol;
import clases.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Gestion {
    private Arbol<IDataStructure> datos;
    private DateTimeFormatter formato;
    private Scanner sc;

    public Gestion() {
        datos = new Arbol<IDataStructure>(null);
        formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sc = new Scanner(System.in);
    }

    public void insertarActualizarPaciente() {

        if (datos.getRaiz() == null) {
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

            NodoArbol<IDataStructure> raiz = new NodoArbol<IDataStructure>(new Persona(nombre, fecha));
            datos.setRaiz(raiz);

        } else {
            System.out.println("Introduzca nuevo nombre del paciente");
            String nombre = sc.nextLine();

            LocalDate fecha = null;
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            boolean ok = true;
            do {
                ok = true;
                try {
                    System.out.println("Introduzca nueva fecha de alta (dd/mm/yyyy)");
                    fecha = LocalDate.parse(sc.nextLine(), formato);
                } catch (Exception e) {
                    ok = false;
                }

            } while (!ok);
            datos.getRaiz().setValor(new Persona(nombre, fecha));
        }
    }

    public void insertarEncuesta() {

        if (datos.getRaiz() != null) {

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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

            datos.getRaiz().agregarHijo(new NodoArbol<IDataStructure>(new Encuesta(fecha)));
        }
    }

    public void insertarDias() {
        NodoArbol<IDataStructure> nodoEncuesta = datos.getRaiz().getHijos().getValorPorPosicion(0);
        for (int i = 1; i <= 5; i++) {

            nodoEncuesta.agregarHijo(new NodoArbol<IDataStructure>(new Dia(i)));
        }

    }

    public void insertarIngesta() throws Exception {
        System.out.println("hay " + datos.getRaiz().getHijos().getValorPorPosicion(0).getHijos().size() + " dias");

        int dia = 0;
        boolean ok = true;
        do {
            do {
                ok = true;
                System.out.println("Seleccione dia / -1 (Salir)");
                try {
                    sc = new Scanner(System.in);
                    dia = sc.nextInt();
                    if ((dia < 1
                            || dia > datos.getRaiz().getHijos().getValorPorPosicion(0).getHijos().size())
                            && dia != -1) {
                        System.out.println("El día seleccionado no existe");
                        ok = false;
                    }
                    if (dia == -1) {
                        throw new Exception("Salir");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("clases.Dia no valido");
                    ok = false;
                }

            } while (!ok);

            NodoArbol<IDataStructure> nodoDia = datos.getRaiz().getHijos().getValorPorPosicion(0).getHijos()
                    .getValorPorPosicion(dia - 1);
            System.out.println("---------" + nodoDia.getValor().getInformacion());
            int opcion = 0;

            do {
                System.out.println(
                        "Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menu anterior)");
                opcion = sc.nextInt();

                Ingesta ing = null;
                Horario horario = null;
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
                        System.out.println("Opcion no valida");

                }
                // Compruebo si con anterioridad hemos añadido ese tipo de ingesta. En caso
                // afirmativo lo recuperamos.
                NodoArbol<IDataStructure> nodoIngesta = existeNodoIngesta(dia, horario);
                if (nodoIngesta != null) {
                    ing = (Ingesta) nodoIngesta.getValor();
                } else {
                    ing = new Ingesta(horario);
                }

                if (opcion != -1) {
                    String opcion2 = "";
                    do {
                        System.out.println("Ingrese un alimento de " + ing.getHorario().getNombre() + " del dia " + dia
                                + " -1 para terminar) / -2 para listar alimentos ingresados)");
                        sc = new Scanner(System.in);
                        opcion2 = sc.nextLine();
                        if (opcion2.equals("-2")) {
                            System.out.println(ing.getInformacion());
                        } else if (!opcion2.equals("-1")) {
                            System.out.println("Cantidad (gr.):");
                            int cantidad = sc.nextInt();
                            Alimento alimento = new Alimento(opcion2, cantidad);
                            ing.insertarAlimento(alimento);
                        }

                    } while (!opcion2.equals("-1"));
                    if (ing != null && nodoIngesta == null) {//aqui la ingesta no existe. La añado como algo nuevo
                        nodoDia.agregarHijo(new NodoArbol<IDataStructure>(ing));
                    }
                    if (nodoIngesta != null) {  //aqui la ingesta ya existia, me limito a actualizar
                        nodoIngesta.setValor(ing);
                    }
                }
            } while (opcion != -1);
        } while (true);
    }

    public void capturarDatos() {
        this.insertarActualizarPaciente();
        this.insertarEncuesta();
        this.insertarDias();
        boolean salir = false;
        do {
            salir = false;
            try {
                this.insertarIngesta();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                salir = true;
            }

        } while (!salir);

    }

    public void mostrar() {
        datos.recorridoPreOrden(datos.getRaiz());
    }

    // Comprueba si existe un horario en un dia concreto y devueleve el nodo o nulo
    // si no existe.
    public NodoArbol<IDataStructure> existeNodoIngesta(int dia, Horario horario) {
        NodoArbol<IDataStructure> result = null;

        NodoArbol<IDataStructure> nodoDia = datos.getRaiz().getHijos().getValorPorPosicion(0).getHijos()
                .getValorPorPosicion(dia - 1);
        GenericList<NodoArbol<IDataStructure>> nodosIngesta = nodoDia.getHijos();
        for (int i = 0; i < nodosIngesta.size(); i++) {
            Ingesta ing = (Ingesta) nodosIngesta.getValorPorPosicion(i).getValor();
            if (ing.getHorario() == horario) {
                result = nodosIngesta.getValorPorPosicion(i);
                break;
            }
        }

        return result;
    }
}
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestion {

    private Scanner sc;
    private Paciente paciente;
    DateTimeFormatter formato;

    public Gestion() {
        this.paciente = new Paciente();
        this.sc = new Scanner(System.in);
        this.formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void insertarPaciente() {
        String nombre;
        LocalDate fecha = null;
        System.out.println("Introduzca el nombre: ");
        nombre = sc.nextLine();
        this.paciente.setNombre(nombre);
        boolean okey = true;
        do {
            System.out.println("Introduzca la fecha(dd/MM/aaaa): ");
            try {
                fecha = LocalDate.parse(sc.nextLine(), formato);
                okey = true;
            } catch (Exception e) {
                System.out.println("Fecha incorrecta, escriba una valida(dd/MM/aaaa)");
                okey = false;
            }
        } while (!okey);
        this.paciente.setFechaDeAlta(fecha);

    }

    public void insertarEncuesta() {
        LocalDate fecha = null;
        boolean okey = true;

        do {
            System.out.println("Introduzca la fecha de la encuesta(dd/MM/aaaa): ");
            try {
                fecha = LocalDate.parse(sc.nextLine(), formato);
                okey = true;
            } catch (Exception e) {
                System.out.println("Fecha incorrecta, escriba una valida(dd/MM/aaaa)");
                okey = false;
            }
        } while (!okey);

        this.paciente.getEncuesta().setFecha(fecha);

    }

    public void insertarDias() {

        for (int i = 1; i <= 5; i++) {
            Dia d = new Dia(i);
            this.paciente.getEncuesta().insertarDia(d);

        }
    }

    public void insertarIngestas() {
        boolean okey = true;
        Ingesta ing = null;
        Horario horario = null;
        String opcion2 = null;
        int dia = 0;

        do {

            do {
                System.out.println("Seleccione dia(1-5): (0 para salir)");
                try {
                    dia = sc.nextInt();
                } catch (NumberFormatException e) {
                    dia = -1;
                    System.out.println("Seleccione un día válido(1-5)");
                }
            } while (dia < 0 || dia > 5);

            if (dia == 0)
                break;

            Dia d = this.paciente.getEncuesta().getDias().getValorPorPosicion(dia - 1);
            // NodoArbol<DatosArbol> nodoDia =
            // arbol.getRaiz().getHijos().getObjeto(0).getHijos().getObjeto(dia - 1);
            int opcion = 0;

            do {
                okey = true;
                System.out.println(
                        "Seleccione ingesta: 1(Desayuno)/2(Mediamañana)/3(Almuerzo)/4(Merienda)/5(Cena)/-1(Menu Anterior)");
                try {
                    opcion = sc.nextInt();
                } catch (NumberFormatException e) {
                    okey = false;
                    System.out.println("Escoge una opción correcta");
                }

                switch (opcion) {
                    case 1:
                        horario = Horario.DESAYUNO;
                        break;
                    case 2:
                        horario = Horario.MEDIAMAÑANA;
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
                        okey = false;
                        System.out.println("Opción incorrecta, elija otra opción");
                        break;

                }
            } while (!okey);

            int pos = existeIngesta(dia, horario);
            if (pos >=0) {
                ing = d.getIngestas().getValorPorPosicion(pos);
            } else {
                ing = new Ingesta(horario);
            }

            do {
                int gramos = 0;
                System.out.println("Ingrese un alimento del " + ing.getHorario().getDescription() + " del dia " + dia
                        + " (-1 para terminar / -2 para listar alimentos ingresados / -3 para vaciar la lista)");
                sc = new Scanner(System.in);
                opcion2 = sc.nextLine();
                if (opcion2.equals("-2")) {
                    System.out.println(ing.getInfo());
                } else if (opcion2.equals("-3")) {
                    ing.vaciar();

                } else if (!opcion2.equals("-1")) {
                    try {
                        System.out.println("Introduzca la cantidad de gramos: ");
                        gramos = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Ingrese una cantidad válida");
                    }
                    ing.insertarAlimento(new Alimento(opcion2, gramos));
                }

            } while (!opcion2.equals("-1"));

            if (ing != null && pos  <0) {
                d.insertarIngesta(ing);
                //// nodoDia.insertarHijos(new NodoArbol<DatosArbol>(ing));
            }
            if (pos>=0) {
                GenericList<Ingesta> misIngestas = this.paciente.getEncuesta().getDias().getValorPorPosicion(dia).getIngestas();
                misIngestas.actualizarPorPosicion(pos, ing);
            }

        } while (true);
    }

    public void capturarDatos() {
        insertarPaciente();
        insertarEncuesta();
        insertarDias();
        insertarIngestas();
    }

    public void mostrar() {
        System.out.println(this.paciente.getInfo());
        Encuesta e = this.paciente.getEncuesta();
        System.out.println(e.getInfo());
        GenericList<Dia> dias = e.getDias();
        for(int i= 0; i<dias.size();i++){
            Dia d= dias.getValorPorPosicion(i);
            System.out.println(d.getInfo());
            GenericList<Ingesta> ingestas= d.getIngestas();
            for(int j=0; j< ingestas.size();j++){
                Ingesta ing = ingestas.getValorPorPosicion(j);
                System.out.println(ing.getInfo());
            }
        }

    }

    public int existeIngesta(int dia, Horario horario) {
        int result = -1;
        GenericList<Ingesta> misIngestas = this.paciente.getEncuesta().getDias().getValorPorPosicion(dia).getIngestas();

        for (int i = 0; i < misIngestas.size(); i++) {
            Ingesta ing = misIngestas.getValorPorPosicion(i);
            if (ing.getHorario() == horario) {
                result = i;
                break;
            }
        }
        return result;
    }

    
}
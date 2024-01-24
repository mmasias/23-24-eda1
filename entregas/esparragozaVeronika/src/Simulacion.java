package arbolReto6.src;

import java.util.Scanner;

public class Simulacion {
    private Lista<String> nombresUsuarios;
    private Lista<String> listaComidasPorDias;
    private int cantidadDias;
    private Lista<Nodo<>> listaArbolesCreados;

    public Simulacion(Lista<String> nombresUsuarios, Lista<String> listaComidasPorDias, int cantidadDias) {
        this.nombresUsuarios = nombresUsuarios;
        this.listaComidasPorDias = listaComidasPorDias;
        this.cantidadDias = cantidadDias;
    }

    public Simulacion() {
    }


    public void imprimirFormularioInicial(){
        System.out.println("A continuación, ¿que desea realizar?");
        System.out.println("1. Crear un nuevo paciente");
        System.out.println("2. Ingresar la ingesta de comidas de un paciente");

        Scanner scanner = new Scanner(System.in);
        System.out.print("-> ");
        int opcion = scanner.nextInt();
        opcionesFormularioInicial(opcion);
    }
    public void opcionesFormularioInicial(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("######### Creando nuevo paciente #########");
                creacionPacientes(nombresUsuarios);
                break;
            case 2:
                System.out.println("Ingresando ingesta de comidas de un paciente");
                imprimirFormularioInscripcion();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    // ############################
    public String vistaCreacionPacientes(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cual es el nombre del usuario a agregar?");
        System.out.print("-> ");
        return scanner.next();
    }
    public void creacionPacientes(Lista<String> nombresUsuarios){
        Nodo<String> nuevoUsuario = new Nodo<>(vistaCreacionPacientes());
        nombresUsuarios.agregar(nuevoUsuario);

        nombresUsuarios.imprimirLista(nombresUsuarios);

        imprimirFormularioFinal();
    }

    // ###########################
    public void imprimirFormularioFinal(){
        System.out.println("¿Que deseas hacer ahora?");
        System.out.println("1. Terminar el programa");
        System.out.println("2. Volver al menu principal");
        //System.out.println("3. Revisar arboles del paciente");

        Scanner scanner = new Scanner(System.in);
        System.out.print("-> ");
        opcionesFormularioFinal(scanner.nextInt());
    }

    public void opcionesFormularioFinal(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("######### Terminando el programa #########");
                break;
            case 2:
                System.out.println("######### Volviendo al menu principal #########");
                imprimirFormularioInicial();
                break;
            case 3:
                System.out.println("######### Ver arbol del paciente #########");
                elegirArbolPaciente();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    public void elegirArbolPaciente(){
        System.out.println("¿Que paciente deseas ver?");
        for (int indexArbol = 0; indexArbol < listaArbolesCreados.size(); indexArbol++) {
//            System.out.println((indexArbol + 1) + ". " + listaArbolesCreados.get(indexArbol).getDato().getRaiz());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("-> ");
        int usuarioElegido = scanner.nextInt() - 1;
//        System.out.println("Elegiste al paciente: " + listaArbolesCreados.get(usuarioElegido).getDato().getRaiz());

//        listaArbolesCreados.get(usuarioElegido).getDato().imprimirArbol(listaArbolesCreados.get(usuarioElegido).getDato().getRaiz(), 0);
    }
    // ############################
    public void imprimirFormularioInscripcion(){
        System.out.println("¿Que usuario deseas ingresar la ingesta de comidas?");
        for (int nombresInscritos = 0; nombresInscritos < nombresUsuarios.size(); nombresInscritos++) {
            System.out.println((nombresInscritos + 1) + ". " + nombresUsuarios.get(nombresInscritos).getDato());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("-> ");
        int usuarioElegido = scanner.nextInt() - 1;
        System.out.println("Elegiste al paciente: " + nombresUsuarios.get(usuarioElegido).getDato());

        crearArbolPaciente(nombresUsuarios.get(usuarioElegido).getDato());
    }

    public Lista<Nodo> crearArbolPaciente(String nombreUsuario) {
        Lista<String> nuevaListaPaciente = new Lista<>();
        poblandoListaPaciente(nuevaListaPaciente);
        listaArbolesCreados.agregar(new Nodo<> (nuevaListaPaciente));
        return listaArbolesCreados;
    }

    public void poblandoListaPaciente(Lista nuevaListaPaciente){
        for (int i = 1; i <= cantidadDias; i++) {
            nuevaListaPaciente.agregar(new Nodo ("Dia " + i));
            Nodo<String> nodoActual = nuevaListaPaciente.get(i - 1);
            for (int j = 0; j < listaComidasPorDias.size(); j++) {
                nuevaListaPaciente.agregar(listaComidasPorDias.get(j));
            }
        }
        añadirAlimentos(formularioInscripcionPorDias(nuevaListaPaciente), nuevaListaPaciente);
        imprimirFormularioFinal();
    }


    public Nodo formularioInscripcionPorDias(Lista paciente){
        System.out.println("Elige el dia que deseas ingresar la ingesta de comidas");
        for (int diaActual = 0; diaActual < paciente.get(0).getHijos().size(); diaActual++) {
            System.out.println((diaActual + 1) + ". " + paciente.get(0).getHijos().get(diaActual).getDato());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("-> ");
        int diaElegido = scanner.nextInt();
        Nodo<String> nodoDeDiaElegido = paciente.get(0).getHijos().get(diaElegido - 1);
        System.out.println("Elegiste el dia: " + nodoDeDiaElegido.getDato());

        System.out.println("Elige la comida que deseas ingresar a la ingesta");
        for (int comidaActual = 0; comidaActual < nodoDeDiaElegido.getHijos().size(); comidaActual++) {
            System.out.println((comidaActual + 1) + ". " + nodoDeDiaElegido.getHijos().get(comidaActual));
        }
        System.out.print("-> ");
        int comidaElegida = scanner.nextInt();
        Nodo<String> nodoDeComidaElegida = nodoDeDiaElegido.getHijos().get(comidaElegida - 1);
        System.out.println("Elegiste la comida: " + nodoDeComidaElegida + " del " + nodoDeDiaElegido);

        return nodoDeComidaElegida;
    }

    public void añadirAlimentos(Nodo nodo, Lista paciente){
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Que comiste en" + articuloComidas(nodo.getDato().toString()) + nodo.getDato().toString() + "?");
        System.out.print("-> ");
        String respuestaComidas = scanner.nextLine();

        paciente.agregar(new Nodo respuestaComidas);
    }


    public String articuloComidas(String comida){
        if (comida.charAt(comida.length() - 1) == 'o') {
            return " el ";
        } else {
            return " la ";
        }
    }
}

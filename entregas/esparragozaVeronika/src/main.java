package arbolReto6.src;

public class main {
    public static Lista<String> listaComidasPorDias = new Lista<>();
    public final static int cantidadDias = 5;
    public static Lista<String> nombresUsuarios = new Lista<>();
    public static void main(String[] args) {
        main programa = new main();
        programa.iniciarSimulacion();
    }
    public void iniciarSimulacion(){
        listaComidasPorDias.agregar(new Nodo<>("Desayuno"));
        listaComidasPorDias.agregar(new Nodo<>("Media mañana"));
        listaComidasPorDias.agregar(new Nodo<>("Almuerzo"));
        listaComidasPorDias.agregar(new Nodo<>("Merienda"));
        listaComidasPorDias.agregar(new Nodo<>("Cena"));

        Simulacion NuevaSimulacion = new Simulacion(nombresUsuarios, listaComidasPorDias, cantidadDias);
        NuevaSimulacion.imprimirFormularioInicial();
    }
    public void imprimirListaDePersonas(Lista<Arbol> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("####### lista de " + lista.get(i).getDato().getRaiz().getDato() + " #######");
            lista.get(i).getDato().imprimirArbol(lista.get(i).getDato().getRaiz(), 0);
        }
    }
}



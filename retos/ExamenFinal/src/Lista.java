import java.util.ArrayList;
import java.util.List;

public class Lista<T extends DatosArbol> {
    private List<Lista<T>> hijos;
    private T value;

    public Lista(T value) {
        this.value = value;
        this.hijos = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public List<Lista<T>> getHijos() {
        return hijos;
    }

    public void agregarHijo(Lista<T> hijo) {
        hijos.add(hijo);
    }

    public void preOrden(Lista<T> nodo, String nivel) {
        if (nodo != null) {
            System.out.println(nivel + nodo.getValue().getInformacion());
            for (Lista<T> hijo : nodo.getHijos()) {
                preOrden(hijo, nivel + "    ");
            }
        }
    }

    public void postOrden(Lista<T> nodo) {
        if (nodo != null) {
            for (Lista<T> hijo : nodo.getHijos()) {
                postOrden(hijo);
            }
            System.out.println(nodo.getValue().getInformacion());
        }
    }

   
}

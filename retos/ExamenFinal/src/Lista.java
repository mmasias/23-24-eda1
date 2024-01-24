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

    public int totalCalorias(Lista<T> nodo) {
        if (nodo != null) {
            int total = 0;
            if (nodo.getValue() instanceof Ingesta) {
                Ingesta ingesta = (Ingesta) nodo.getValue();
                total += ingesta.totalCaloriasI();
            }
            for (Lista<T> hijo : nodo.getHijos()) {
                total += totalCalorias(hijo);
            }
            return total;
        } else {
            return 0;
        }
    }

    public int totalTipo(Lista<T> nodo, String nombre) {
        if (nodo != null) {
            int total = 0;
            if (nodo.getValue() instanceof Ingesta) {
                Ingesta ingesta = (Ingesta) nodo.getValue();
                total += ingesta.totalTipoI(nombre);
            }
            for (Lista<T> hijo : nodo.getHijos()) {
                total += totalTipo(hijo, nombre);
            }
            return total;
        } else {
            return 0;
        }
    }
}

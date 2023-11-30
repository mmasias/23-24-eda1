package arboles;

public class Arbol {
    Nodo raiz;

    public Arbol(String dato) {
        this.raiz = new Nodo(dato);
    }

    public void añadirNodo(String dato, Nodo padre) {
        Nodo nuevoNodo = new Nodo(dato);
        padre.hijos.insert(nuevoNodo, -1);
    }
}

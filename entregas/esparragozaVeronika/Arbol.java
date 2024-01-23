package arbolReto6;

public class Arbol<T> {
    private Nodo<T> raiz;

    public Arbol(T dato) {
        this.raiz = new Nodo<>(dato);
    }

    public Nodo<T> agregar(T dato, Nodo<T> padre) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (padre == null) {
            raiz.getHijos().agregar(nuevoNodo);
        } else {
            padre.getHijos().agregar(nuevoNodo);
        }
        return nuevoNodo;
    }

    public int size(Nodo<T> nodoActual, int contador) {
        if (nodoActual.getHijos().isEmpty()){
            return contador + 1;
        }
        Lista<T> hijos = nodoActual.getHijos();
        for (int i = 0; i < hijos.size(); i++) {
            contador = contador + size(hijos.get(i),0);
        }
        return contador;
    }

    public void imprimirArbol(Nodo<T> nodoActual, int nivel) {
        System.out.println( "--".repeat(nivel) + nodoActual.getDato());
        Lista<T> hijos = nodoActual.getHijos();
        for (int i = 0; i < hijos.size(); i++) {
            imprimirArbol(hijos.get(i), nivel + 1);
        }
    }


    public Nodo<T> getRaiz() {
        return this.raiz;
    }

    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }
}


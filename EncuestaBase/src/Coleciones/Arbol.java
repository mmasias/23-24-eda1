package Coleciones;

import Coleciones.NodoArbol;

public class Arbol<T extends IDataStructure> {
    private NodoArbol<T> raiz;

    public Arbol(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    // Recorrido en preorden
    public void recorridoPreOrden(NodoArbol<T> nodo) {
        if (nodo != null) {
            System.out.println(nodo.getValor().getInformacion() + " ");
            for (NodoArbol<T> hijo : nodo.getHijos()) {
                recorridoPreOrden(hijo);
            }
        }
    }

    // Recorrido en profundidad (DFS) postorden
    public void recorridoPostOrden(NodoArbol<T> nodo) {
        if (nodo != null) {
            for (NodoArbol<T> hijo : nodo.getHijos()) {
                recorridoPostOrden(hijo);
            }
            System.out.println(nodo.getValor().getInformacion() + " ");
        }
    }

    // Búsqueda en el árbol
    public NodoArbol<T> buscar(T valor, NodoArbol<T> nodo) {
        if (nodo == null) {
            return null;
        }

        if (nodo.getValor().equals(valor)) {
            return nodo;
        }

        for (NodoArbol<T> hijo : nodo.getHijos()) {
            NodoArbol<T> resultado = buscar(valor, hijo);
            if (resultado != null) {
                return resultado;
            }
        }

        return null;
    }

}

public class ArbolIngestas {
    private NodoIngesta raiz;

    public void insertar(Ingestas ingesta) {
        raiz = insertarRec(raiz, ingesta);
    }

    private NodoIngesta insertarRec(NodoIngesta nodo, Ingestas ingesta) {
        if (nodo == null) {
            return new NodoIngesta(ingesta);
        }

        // Comparar la fecha u otro criterio para decidir en qué rama insertar
        if (ingesta.getFecha().compareTo(nodo.getIngesta().getFecha()) < 0) {
            nodo.setIzquierda(insertarRec(nodo.getIzquierda(), ingesta));
        } else if (ingesta.getFecha().compareTo(nodo.getIngesta().getFecha()) > 0) {
            nodo.setDerecha(insertarRec(nodo.getDerecha(), ingesta));
        }

        return nodo;
    }

    // Puedes añadir otros métodos según sea necesario
}

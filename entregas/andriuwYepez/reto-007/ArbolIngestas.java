public class ArbolIngestas {
    private NodoIngesta raiz;

    public void insertar(Ingestas ingesta) {
        raiz = insertarRec(raiz, ingesta);
    }

    private NodoIngesta insertarRec(NodoIngesta nodo, Ingestas ingesta) {
        if (nodo == null) {
            return new NodoIngesta(ingesta);
        }

        if (ingesta.getFecha().compareTo(nodo.getIngesta().getFecha()) < 0) {
            nodo.setIzquierda(insertarRec(nodo.getIzquierda(), ingesta));
        } else if (ingesta.getFecha().compareTo(nodo.getIngesta().getFecha()) > 0) {
            nodo.setDerecha(insertarRec(nodo.getDerecha(), ingesta));
        }

        return nodo;
    }
}

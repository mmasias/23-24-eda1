public class FamiliaTree<T> {
    private NodoFamilia<T> raiz;

    public FamiliaTree() {
    }

    public NodoFamilia<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoFamilia<T> raiz) {
        this.raiz = raiz;
    }

    public void agregarMiembro(T dato, T padre, boolean esHijoIzquierdo) {
        NodoFamilia<T> nuevoMiembro = new NodoFamilia<>(dato);
        if (raiz == null) {
            raiz = nuevoMiembro;
        } else {
            NodoFamilia<T> nodoPadre = buscarNodo(raiz, padre);
            if (nodoPadre != null) {
                if (esHijoIzquierdo) {
                    nodoPadre.setHijoIzquierdo(nuevoMiembro);
                } else {
                    nodoPadre.setHijoDerecho(nuevoMiembro);
                }
            } else {
                System.out.println("No se encontró al padre en el árbol.");
            }
        }
    }

    private NodoFamilia<T> buscarNodo(NodoFamilia<T> raiz, T dato) {
        if (raiz == null || raiz.getDato().equals(dato)) {
            return raiz;
        }

        NodoFamilia<T> izquierdo = buscarNodo(raiz.getHijoIzquierdo(), dato);
        if (izquierdo != null) {
            return izquierdo;
        }

        return buscarNodo(raiz.getHijoDerecho(), dato);
    }

    public void imprimirArbol() {
        System.out.println("Representación de la familia:");
        imprimirArbol(raiz, 0);
    }

    private void imprimirArbol(NodoFamilia<T> nodo, int nivel) {
        if (nodo != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nivel; i++) {
                sb.append("  ");
            }
            System.out.println(sb.toString() + nodo.getDato());
            imprimirArbol(nodo.getHijoIzquierdo(), nivel + 1);
            imprimirArbol(nodo.getHijoDerecho(), nivel + 1);
        }
    }
}
public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.izquierda = insertarRec(raiz.izquierda, valor);
        } else if (valor > raiz.valor) {
            raiz.derecha = insertarRec(raiz.derecha, valor);
        }
        return raiz;
    }

    Nodo buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    
    Nodo buscarRec(Nodo raiz, int valor) {
        
        if (raiz == null || raiz.valor == valor) {
            return raiz;
        }

        if (valor < raiz.valor) {
            return buscarRec(raiz.izquierda, valor);
        }

        
        return buscarRec(raiz.derecha, valor);
    }

   
    void imprimirInorden() {
        imprimirInordenRec(raiz);
        System.out.println();
    }

   
    void imprimirInordenRec(Nodo raiz) {
        if (raiz != null) {
           
            imprimirInordenRec(raiz.izquierda);
            System.out.print(raiz.valor + " ");
            imprimirInordenRec(raiz.derecha);
        }
    }

    
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        int[] valores = { 10, 5, 15, 3, 7, 12, 20 };

        
        for (int valor : valores) {
            arbol.insertar(valor);
        }

        
        arbol.imprimirInorden(); // Salida esperada: 3 5 7 10 12 15 20

        
        int buscarValor = 7;
        Nodo nodoEncontrado = arbol.buscar(buscarValor);
        if (nodoEncontrado != null) {
            System.out.println("Valor " + buscarValor + " encontrado en el árbol.");
        } else {
            System.out.println("Valor " + buscarValor + " no encontrado en el árbol.");
        }
    }

}

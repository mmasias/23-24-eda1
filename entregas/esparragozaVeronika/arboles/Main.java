package arboles;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main programa = new Main();
        programa.iniciarArbol();
    }

    public void iniciarArbol() {
        Arbol arbol = new Arbol("A");
        Nodo nodoB = new Nodo("B");
        Nodo nodoC = new Nodo("C");
        arbol.añadirNodo("D", arbol.raiz);
        arbol.añadirNodo("E", arbol.raiz);
        arbol.añadirNodo("F", nodoB);
        arbol.añadirNodo("G", nodoB);
        arbol.añadirNodo("H", nodoC);
    }
}

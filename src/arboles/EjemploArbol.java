public class EjemploArbol {

    public static void main(String[] args) {

        BinaryTree<Integer> arbol = new BinaryTree<>();

        // Insertar elementos en el árbol
        arbol.insertar(5);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(2);
        arbol.insertar(4);
        arbol.insertar(6);
        arbol.insertar(8);

        System.out.println("Recorrido InOrden:");
        arbol.inOrder();

    }
}

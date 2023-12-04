public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public void insertar(T data) {
        root = recursiveInsert(root, data);
    }

    private Node<T> recursiveInsert(Node<T> actual, T data) {
        if (actual == null) {
            return new Node<>(data);
        }

        if (data.compareTo(actual.getData()) < 0) {
            actual.setLeft(recursiveInsert(actual.getLeft(), data));
        } else if (data.compareTo(actual.getData()) > 0) {
            actual.setRight(recursiveInsert(actual.getRight(), data));
        }

        return actual;
    }

    public void inOrder() {
        recursiveInOrder(root);
    }

    private void recursiveInOrder(Node<T> actual) {
        if (actual != null) {
            recursiveInOrder(actual.getLeft());
            System.out.println(actual.getData());
            recursiveInOrder(actual.getRight());
        }
    }
}

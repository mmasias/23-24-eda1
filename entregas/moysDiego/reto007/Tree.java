public class Tree<T> {
    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node<T> node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.println(node.getData());
            printInOrder(node.getRight());
        }
    }

    public void insert(Node<T> newNode) {
        this.root = recursiveInsert(this.root, newNode);
    }

    private Node<T> recursiveInsert(Node<T> actualNode, Node<T> newNode) {
        if (actualNode == null) {
            return newNode;
        }
        if (newNode.getIndex() < actualNode.getIndex()) {
            actualNode.setLeft(recursiveInsert(actualNode.getLeft(), newNode));
        } else if (newNode.getIndex() > actualNode.getIndex()) {
            actualNode.setRight(recursiveInsert(actualNode.getRight(), newNode));
        }
        return actualNode;
    }
}

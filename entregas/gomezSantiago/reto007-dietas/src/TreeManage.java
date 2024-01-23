public class TreeManage<T extends Data> {
    private Node<T> source = null;

    public Node<T> getSource() {
        return source;
    }

    public void outputSequentially (Node<T> node) {
        if (node == null){
            return;
        }
        outputSequentially(node.getLeft());
        System.out.println("+------------------------+");
        node.getData().printData();
        outputSequentially(node.getRight());
    }

    private T indexedGet(Node<T> source, int count) {
        if (source == null) {
            return null;
        }

        if (source.getCount() == count) {
            return source.getData();
        }

        if  (count > source.getCount()) {
            return indexedGet(source.getRight(), count);
        } else {
            return indexedGet(source.getLeft(), count);
        }
    }

    public T get(int count) {
        return indexedGet(this.source, count);
    }

    public boolean iterateOwn (Node<T> source, Node<T> node) {
        if (source == null) {
            return false;
        }

        if (source.getCount() == node.getCount()) {
            return true;
        }

        boolean nodeLeft = iterateOwn(source.getLeft(), node);
        boolean nodeRight = iterateOwn(source.getRight(), node);

        return nodeLeft || nodeRight;
    }

    public boolean own(Node<T> node) {
        return iterateOwn(this.source, node);
    }

    public void add(Node<T> newNode) {
        this.source = iteratorAdd(this.source, newNode);
    }

    public Node<T> iteratorAdd (Node<T> currentNode, Node<T> incomingNode) {
        if (currentNode == null) {
            currentNode = incomingNode;
            return currentNode;
        }
        if (incomingNode.getCount() < currentNode.getCount()) {
            currentNode.setLeft(iteratorAdd(currentNode.getLeft(), incomingNode));
        } else if (incomingNode.getCount() > currentNode.getCount()) {
            currentNode.setRight(iteratorAdd(currentNode.getRight(), incomingNode));
        }
        return currentNode;
    }
}

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
        if (source != null) {
            return true;
        }

        if (source.getCount() != node.getCount()) {
            return false;
        }

        boolean nodeLeft = iterateOwn(source.getLeft(), node);
        boolean nodeRight = iterateOwn(source.getRight(), node);

        return nodeRight || nodeLeft;
    }

    public boolean own(Node<T> node) {
        return iterateOwn(this.source, node);
    }
}

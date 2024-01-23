public class Node<T extends Data> {
    private T data;
    private int count;
    private Node<T> next;
    private Node<T> left;
    private Node<T> right;

    public Node(T data, int count) {
        this.data = data;
        this.count = count;
        this.next = null;
        this.left = null;
        this.right = null;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public Node<T> getNext(){
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getLeft(){
        return left;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight(){
        return right;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
}

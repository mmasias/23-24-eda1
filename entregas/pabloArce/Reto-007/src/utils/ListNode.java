package utils;

class ListNode<T> {
    private T data;
    private ListNode<T> next;

    public ListNode(T data) {
        setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public int count() {
        if (getNext() == null) {
            return 1;
        } else {
            return 1 + getNext().count();
        }
    }
}
class NodoLista<T> {
    private T data;
    private NodoLista<T> next;

    public NodoLista(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
      return data;
    }

    public NodoLista<T> getNext() {
      return next;
    }

    public void setData(T data) {
      this.data = data;
    }

    public void setNext(NodoLista<T> next) {
      this.next = next;
    }

}
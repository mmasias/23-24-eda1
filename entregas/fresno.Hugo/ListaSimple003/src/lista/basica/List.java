package lista.basica;

public class List {
    private Node first = null;
    private int size = 0; // Contador de elementos en la lista

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insert(String value) {
        System.out.println(" > Llegó " + value); // Mensaje descriptivo de entrada
        Node nodoQueEntra = new Node(value);
        if (this.first == null)
            this.first = nodoQueEntra;
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(nodoQueEntra);
        }
        this.size++; // Incrementamos el contador de elementos
    }

    public void delete() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            if (previous != null) {
                System.out.println("Se fue " + iterator.getValue()); // Mensaje descriptivo de salida
                previous.setNext(null);
            } else {
                // Caso especial: solo hay un elemento en la lista
                System.out.println("Se fue " + this.first.getValue());
                this.first = null;
            }
            this.size--; // Decrementamos el contador de elementos
        }
    }

    public String[] listAll() {
        String[] list = new String[this.size];
        Node iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}

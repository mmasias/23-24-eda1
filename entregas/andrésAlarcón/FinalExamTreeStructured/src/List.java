import java.util.Iterator;

class List implements Iterable<Object> {
    Node head;

    public List() {
        this.head = null;
    }

    public void add(Object data) {
        add(size(), data);
    }

    public void add(int index, Object data) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            while (size() < index) {
                add(null);
            }
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int indexOf(Object data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1; // Element not found
    }

    public Object get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        Node current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Object next() {
                Object data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
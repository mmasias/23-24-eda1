import java.util.ArrayList;
import java.util.List;

public class GenericList<T extends Comparable<T>> {

    private List<ListNode<T>> nodes;

    public GenericList() {
        this.nodes = new ArrayList<>();
    }

    public int size() {
        return this.nodes.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void insertFront(T value) {
        ListNode<T> newNode = new ListNode<>(value);
        if (!this.isEmpty()) {
            newNode.addNextNode(nodes.get(0));
        }
        nodes.add(0, newNode);
    }

    public void insertEnd(T value) {
        ListNode<T> newNode = new ListNode<>(value);
        if (!this.isEmpty()) {
            ListNode<T> lastNode = nodes.get(nodes.size() - 1);
            lastNode.addNextNode(newNode);
        }
        nodes.add(newNode);
    }

    public void deleteFront() {
        if (!this.isEmpty()) {
            nodes.remove(0);
        }
    }

    public ListNode<T> getFirst() {
        return this.isEmpty() ? null : nodes.get(0);
    }

    public ListNode<T> getLast() {
        return this.isEmpty() ? null : nodes.get(nodes.size() - 1);
    }

    public List<T> listarTodo() {
        List<T> list = new ArrayList<>();
        for (ListNode<T> node : nodes) {
            list.add(node.getValue());
        }
        return list;
    }

    public void insertarOrdenado(T value) {
        ListNode<T> newNode = new ListNode<>(value);

        if (this.isEmpty() || value.compareTo(nodes.get(0).getValue()) < 0) {
            newNode.addNextNode(nodes.get(0));
            nodes.add(0, newNode);
        } else {
            int index = 0;
            while (index < nodes.size() && value.compareTo(nodes.get(index).getValue()) >= 0) {
                index++;
            }
            if (index < nodes.size()) {
                ListNode<T> current = nodes.get(index);
                nodes.add(index, newNode);
                if (index > 0) {
                    ListNode<T> previous = nodes.get(index - 1);
                    previous.addNextNode(newNode);
                }
                newNode.addNextNode(current);
            } else {
                // Insert at the end
                nodes.add(newNode);
                ListNode<T> previous = nodes.get(nodes.size() - 2);
                previous.addNextNode(newNode);
            }
        }
    }

    public T getObjeto(int posicion) {
        if (posicion < 0 || posicion >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        return nodes.get(posicion).getValue();
    }

    public void vaciar() {
        nodes.clear();
    }

    public T getValorPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        return nodes.get(posicion).getValue();
    }

    public int indexOf(T value) {
        for (int index = 0; index < nodes.size(); index++) {
            if (nodes.get(index).getValue().equals(value)
                    || (nodes.get(index).getValue() instanceof String
                            && ((String) nodes.get(index).getValue()).equalsIgnoreCase((String) value))) {
                return index;
            }
        }
        return -1;
    }
}

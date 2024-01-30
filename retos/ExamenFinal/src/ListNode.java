import java.util.ArrayList;
import java.util.List;

public class ListNode<T> {
    private T value;
    private List<ListNode<T>> nextNodes;

    public ListNode(T value) {
        this.setValue(value);
        this.nextNodes = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T newValue) {
        this.value = newValue;
    }

    public List<ListNode<T>> getNextNodes() {
        return nextNodes;
    }

    public void addNextNode(ListNode<T> nextNode) {
        this.nextNodes.add(nextNode);
    }
}

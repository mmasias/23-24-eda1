public class CustomerQueue {
    Node front, rear;

    public CustomerQueue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int id) {
        Node newNode = new Node(id);

        if (isEmpty()) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1; // Return a special value to indicate queue is empty
        }

        int id = front.id;
        front = front.next;

        if (front == null) {
            rear = null; // If last element is removed, set rear to null
        }

        return id;
    }

    public int peek() {
        if (isEmpty()) {
            return -1; // Return a special value to indicate queue is empty
        }

        return front.id;
    }
}
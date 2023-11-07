import java.util.LinkedList;

public class Queue {

  private LinkedList<Client> queue;

  public Queue() {
    queue = new LinkedList<>();
  }

  public void addClient(Client client) {
    queue.add(client);
  }

  public Client removeClient() {
    return queue.remove();
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

}

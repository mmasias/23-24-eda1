import java.util.LinkedList;
import java.util.Queue;

public class Client {
  private static int idCounter = 0;
  private String name;
  private Items items;
  private Queue<Client> queue;

  public Client(String name) {
    this.name = name;
    this.items = new Items();
    this.queue = new LinkedList<Client>();
  }

  public void addItem(Item item) {
    items.addItem(item);
  }

  public void removeItem(Item item) {
    items.removeItem(item);
  }

  public int countItems() {
    return items.countItems();
  }

  public void joinQueue() {
    queue.add(this);
  }

  public void leaveQueue() {
    queue.remove();
  }

  public int queueSize() {
    return queue.size();
  }

  public String getNextClientName() {
    if (queue.isEmpty()) {
      return "No clients in front of you";
    } else {
      return queue.peek().getName();
    }
  }

  public String getName() {
    return name;
  }

  public String getId() {
    return idCounter + "";
  }
}

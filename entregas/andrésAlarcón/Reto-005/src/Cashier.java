import java.util.Queue;

public class Cashier {
  private Queue<Client> queue;
  private int timePerClient;

  public Cashier(Queue<Client> queue, int timePerClient) {
    this.queue = queue;
    this.timePerClient = timePerClient;
  }

  public void attendClients() {
    while (!queue.isEmpty()) {
      Client client = queue.poll();
      System.out.println("Attending client " + client.getId());
      try {
        Thread.sleep(timePerClient);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Finished attending client " + client.getId());
    }
  }

}



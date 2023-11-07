import java.util.ArrayList;

public class Register {
  private ArrayList<Client> queue;
  private int maxQueueSize;
  private int numRegisters;
  boolean isOpen = false;

  public Register(int maxQueueSize, int numRegisters) {
    this.queue = new ArrayList<Client>();
    this.maxQueueSize = maxQueueSize;
    this.numRegisters = numRegisters;
  }

  public void addClient(Client client) {
    if (queue.size() < maxQueueSize) {
      queue.add(client);
    } else {
      System.out.println("Queue is full, please wait in line.");
    }
  }

  public void attendClients() {
    int numClients = queue.size();
    int numRegistersToUse = Math.min(numClients, numRegisters);

    for (int i = 0; i < numRegistersToUse; i++) {
      Client client = queue.remove(0);
      System.out.println("Attending client " + client.getName());
    }
  }

  public void addRegisters(int numRegistersToAdd) {
    this.numRegisters += numRegistersToAdd;
  }

  public boolean isOpen() {
    return false;
  }
}

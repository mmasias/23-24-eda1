package entregas.quiñonezJorge;

public class List {

  private Node first = null;
  private int size = 0;

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size() > 0 ? false : true;
  }

  public void insertEnd(String value) {
    Node lastNode = new Node(value);
    System.out.println(" > El último el llegar es " + lastNode.getValue());
    if (this.first == null) {
      this.first = lastNode;
    } else {
      Node iterator = this.first;
      while (iterator.getNext() != null) {
        iterator = iterator.getNext();
      }
      iterator.setNext(lastNode);
    }
    this.size++;
  }

  public void insertStart(String value) {
    Node firstNode = new Node(value);
    if (this.first == null) {
      this.first = firstNode;
    } else {
      firstNode.setNext(this.first);
      this.first = firstNode;
    }
  }

  public void deleteLast() {
    if (this.first != null) {
      Node iterator = this.first;
      Node previous = null;
      while (iterator.getNext() != null) {
        previous = iterator;
        iterator = iterator.getNext();
      }
      if (previous != null) {
        System.out.println(" > Se fue " + iterator.getValue());
        previous.setNext(null);

      } else {
        this.first = null;
      }
      this.size--;
    }
  }

  public void deleteStart() {
    if (this.first != null) {
      System.out.println(" > Se fue " + this.first.getValue());
      Node nextNode = this.first.getNext();
      this.first = null;
      this.first = nextNode;
      this.size--;
    }
  }

  public String[] listAll() {
    String[] list = new String[this.size()];
    Node iterator = this.first;
    int count = 0;
    while (iterator != null) {
      list[count] = iterator.getValue();
      count++;
      iterator = iterator.getNext();
    }
    return list;
  }
}
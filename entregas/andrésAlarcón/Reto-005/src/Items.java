import java.util.ArrayList;

public class Items {
  private ArrayList<Item> items;

  public Items() {
    items = new ArrayList<Item>();
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void removeItem(Item item) {
    items.remove(item);
  }

  public int countItems() {
    return items.size();
  }
}

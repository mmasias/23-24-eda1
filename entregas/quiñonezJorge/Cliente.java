public class Cliente {

 private Pack items;
 private Cliente next;

 public Cliente() {
  int itemsLenght = (int) (Math.random() * (15 - 5) + 5);
  this.setItems(itemsLenght);
 }

 private void setItems(int size) {
  items = new Pack(size);
 }

 public void reduceItemsSize() {
  items.reduceSize();
 }

 public int getItemsLenght() {
  return items.getSize();
 }

 public Cliente getNext() {
  return next;
 }

 public void setNext(Cliente next) {
  this.next = next;
 }
}

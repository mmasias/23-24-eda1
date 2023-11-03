public class Cliente {

 private Pack items;
 private Cliente next;
 private int itemsLenght = (int) Math.random() * (15 - 5) + 5;

 public Cliente() {
  setItems(itemsLenght);
 }

 private void setItems(int size) {
  this.items = new Pack(size);
 }

 public Pack getPack() {
  return items;
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

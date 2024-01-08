public class List<T extends DataProvider> {

 private Node<T> first = null;
 private int size = 0;

 public int getSize() {
  return size;
 }

 public boolean isEmpty() {
  return this.getSize() > 0 ? false : true;
 }

 public void add(Node<T> node) {
  if (this.first == null) {
   this.first = node;
  } else {
   Node<T> iterator = this.first;
   while (iterator.getNext() != null) {
    iterator = iterator.getNext();
   }
   iterator.setNext(node);
  }
  this.size++;
 }

 public void delete() {
  if (this.first != null) {
   Node<T> iterator = this.first;
   Node<T> previous = null;
   while (iterator.getNext() != null) {
    previous = iterator;
    iterator = iterator.getNext();
   }
   if (previous != null) {
    previous.setNext(null);
   } else {
    this.first = null;
   }
   this.size--;
  }
 }

 public T[] getList() {
  T[] list = (T[]) new Object[this.getSize()];
  Node<T> iterator = this.first;
  if (iterator != null) {
   for (int i = 0; i < this.getSize(); i++) {
    list[i] = iterator.getData();
    iterator = iterator.getNext();
   }
  }
  return list;
 }

}

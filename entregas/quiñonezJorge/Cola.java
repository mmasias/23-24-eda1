public class Cola {

 private Cliente first = null;
 private int size = 0;

 public int size() {
  return size;
 }

 public boolean isEmpty() {
  return size() > 0 ? false : true;
 }

 public Cliente getFirst() {
  return first;
 }

 public void newClient(Cliente client) {
  if (first == null) {
   first = client;
  } else {
   Cliente iterator = first;
   while (iterator.getNext() != null) {
    iterator = iterator.getNext();
   }
   iterator.setNext(client);
  }
  System.out.print("Llego 1 persona - ");
  size++;
 }

 public void removeClient() {
  if (first != null) {
   first = first.getNext();
   size--;
  }
 }
}

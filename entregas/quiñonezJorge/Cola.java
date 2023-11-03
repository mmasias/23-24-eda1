public class Cola {

 private Cliente first = null;
 private int size = 0;

 public int size() {
  return size;
 }

 public boolean isEmpty() {
  return this.size() > 0 ? false : true;
 }

 public Cliente getFirst() {
  return this.first;
 }

 public void newClient(Cliente client) {
  if (this.first == null) {
   this.first = client;
   System.out.print("Llego 1 persona a la cola - ");
  } else {
   Cliente iterator = this.first;
   while (iterator.getNext() != null) {
    iterator = iterator.getNext();
   }
   iterator.setNext(client);
  }
  this.size++;
 }

 public void removeClient() {
  if (this.first != null) {
   this.first = this.first.getNext();
   this.size--;
  }
 }
}

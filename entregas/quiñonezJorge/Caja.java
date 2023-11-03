public class Caja {

 private Cliente actualClient = null;
 private boolean isEmpty = true;

 public void recieveClient(Cliente newClient) {
  this.actualClient = newClient;
  this.isEmpty = false;
 }

 public void chargeItem() {
  actualClient.reduceItemsSize();
  if (actualClient.getItemsLenght() == 0) {
   setFree();
  }
 }

 public void setFree() {
  actualClient = null;
  isEmpty = true;
 }

 public boolean isEmpty() {
  return isEmpty;
 }

 public void printRemainingItems() {
  if (actualClient != null) {
   System.out.println("[" + actualClient.getItemsLenght() + "]");
  } else {
   System.out.println("[0]");
  }
 }
}

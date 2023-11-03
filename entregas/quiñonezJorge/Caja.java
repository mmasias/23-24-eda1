public class Caja {

 private Cliente actualClient = null;
 private boolean isEmpty = true;

 public void recieveClient(Cliente newClient) {
  this.actualClient = newClient;
  this.isEmpty = false;
 }

 public void chargeItem() {
  this.actualClient.getPack().reduceSize();
 }

 public void setFree() {
  this.actualClient = null;
  this.isEmpty = true;
 }

 public boolean isEmpty() {
  return this.isEmpty;
 }
}

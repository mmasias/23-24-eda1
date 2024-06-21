public class Carrefour {

 private Horario schedule;
 private int availableCashiers = 4;
 private Caja[] cajas = new Caja[availableCashiers];
 private Cola line;

 public Carrefour() {
  this.schedule = new Horario();
  this.line = new Cola();
  this.createCashiers();
 }

 private void createCashiers() {
  for (int i = 0; i < availableCashiers; i++) {
   cajas[i] = new Caja();
  }
 }

 private void addClient() {
  Cliente newClient = new Cliente();
  line.newClient(newClient);
 }

 private void attendClient() {
  for (int i = 0; i < availableCashiers; i++) {
   if (cajas[i].isEmpty() && !line.isEmpty()) {
    cajas[i].recieveClient(line.getFirst());
    line.removeClient();
   }
  }
 }

 private void printClientStatus() {
  System.out.println("En cola: " + line.size());
  for (int i = 0; i < availableCashiers; i++) {
   System.out.print("Caja " + (i + 1) + ": ");
   cajas[i].printRemainingItems();
  }
  System.out.println("===============================================");
 }

 private void processItems() {
  for (int i = 0; i < availableCashiers; i++) {
   if (!cajas[i].isEmpty()) {
    cajas[i].chargeItem();
   }
  }
 }

 public void openShop() {
  while (schedule.isOpen()) {
   schedule.clock();
   int newClientProb = (int) (Math.random() * 100);
   if (newClientProb <= 40) {
    addClient();
   } else {
    System.out.print("No llega nadie  - ");
   }
   attendClient();
   printClientStatus();
   processItems();
   schedule.checkTime();
  }
 }
}

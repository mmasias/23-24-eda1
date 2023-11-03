public class Carrefour {

 private Horario schedule;
 private int availableCajas;
 private Caja[] cajas = new Caja[availableCajas];
 private Cola line;

 public Carrefour() {
  this.schedule = new Horario();
  this.availableCajas = 4;
  this.line = new Cola();
  this.createCajas();
 }

 private void createCajas() {
  for (int i = 0; i < this.availableCajas; i++) {
   cajas[i] = new Caja();
  }
 }
}

public class Horario {

 private int minutes = 0;
 private boolean stillOpen = true;

 private void close() {
  System.out.println("========== Cerrando el supermercado ==========");
  stillOpen = false;
 }

 public boolean isOpen() {
  return stillOpen;
 }

 public void clock() {
  minutes++;
  System.out.print("MINUTO: " + minutes + " - ");
 }

 public void checkTime() {
  if (minutes == 720) {
   close();
  }
 }
}

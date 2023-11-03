public class Horario {

 private int minutes = 720;
 private boolean stillOpen = true;

 private void close() {
  this.stillOpen = false;
 }

 public boolean isOpen() {
  return this.stillOpen;
 }

 public void reduceTime() {
  this.minutes--;
  if (this.minutes == 0) {
   this.close();
  }
 }

}

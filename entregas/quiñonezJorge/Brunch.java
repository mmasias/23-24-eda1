public class Brunch implements DataProvider {

 private String name;
 private List<Food> food = null;
 private boolean open = false;

 public Brunch(String name) {
  this.name = name;
  this.food = new List<Food>();
 }

 public void open() {
  this.open = true;
  int input;
 }

 @Override
 public void printData() {
  System.out.println("            " + this.name);
  this.printList();
 }

 private void printList() {
  if (!this.food.isEmpty()) {
   Food[] list = this.food.getList();
   for (int i = 0; i < this.food.getSize(); i++) {
    list[i].printData();
   }
  } else {
   System.out.println("");
  }
 }
}

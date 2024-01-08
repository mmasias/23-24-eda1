public class Day implements DataProvider {

 private String name;
 private Tree<Brunch> brunches = null;

 public Day(String name) {
  this.name = name;
  this.brunches = new Tree<Brunch>();
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 @Override
 public void printData() {
  System.out.println(this.name);
  System.out.print("  ");
  this.brunches.printInOrder(this.brunches.getRoot());
 }
}

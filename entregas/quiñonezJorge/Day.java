public class Day {

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
}

public class Food implements DataProvider {

 private String name;
 private List<Nutrient> nutrients;

 public Food(String name) {
  this.name = name;
  this.nutrients = new List<Nutrient>();
 }

 public String getName() {
  return name;
 }

 public List<Nutrient> getNutrients() {
  return nutrients;
 }

 public void addNutrient(Nutrient nutrient) {
  this.nutrients.add(new Node<Nutrient>(nutrient));
 }

 @Override
 public void printData() {
  System.out.println("                " + this.getName());
 }
}

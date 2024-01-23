public class Nutrient implements DataProvider {

 private String name;

 public Nutrient(String name) {
  this.name = name;
 }

 public String getName() {
  return name;
 }

 @Override
 public void printData() {
  System.out.println("                        " + this.getName());
 }
}

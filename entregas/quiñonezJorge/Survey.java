public class Survey {

 private boolean open = false;

 public void open() {
  this.open = true;
  this.printInstructions();
  this.printMenu();
 }

 public void close() {
  this.open = false;
 }

 public boolean isOpen() {
  return this.open;
 }

 private void printMenu() {
  System.out.println("--------------------");
  System.out.println("Menu:");
  System.out.println("1. Monday");
  System.out.println("2. Tuesday");
  System.out.println("3. Wednesday");
  System.out.println("4. Thursday");
  System.out.println("5. Friday");
  System.out.println("0. Exit");
  System.out.println("--------------------");
 }

 private void printInstructions() {
  System.out.println("--------------------");
  System.out.println("Instructions:");
  System.out.println("During a week you must fill the form with all the brunches you had each day");
  System.out.println(
    "It's very important that you remember and be specific with the amount of food eaten, preparation methods, product brands, and portion sizes.");
  System.out.println("This also includes any food, drink, snacks or any other supplements you may have taken.");
  System.out.println("Please, be as accurate as possible.");
 }
}

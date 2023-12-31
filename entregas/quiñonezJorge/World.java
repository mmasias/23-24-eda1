import java.util.Scanner;

public class World {

 private boolean mainMenu = true;
 private Client client = null;

 public static void main(String[] args) {
  World world = new World();
  world.Start();
 }

 private void Start() {
  int input;

  do {
   this.manageMenu();
   System.out.print("Choose an option: ");
   input = new Scanner(System.in).nextInt();
   manageInput(input);
  } while (input != 0);
 }

 private void manageInput(int input) {
  switch (input) {
   case 1:
    System.out.print("Input your name: ");
    String name = new Scanner(System.in).nextLine();
    this.client = new Client(name);
    break;
   case 2:
    if (this.client == null) {
     System.out.println("Can't create a survey without registering first");
     new Scanner(System.in).nextLine();
    } else {
     this.displayMenu(false);
     this.client.createSurvey();
     this.client.displaySurvey(true);
    }
  }
 }

 private void manageMenu() {
  if (this.mainMenu) {
   this.printWelcome();
   this.printMenu();
  }
 }

 private void printWelcome() {
  if (this.client != null) {
   System.out.println("--------------------");
   System.out.println("Welcome " + this.client.getName());
  }
 }

 private void printMenu() {
  System.out.println("--------------------");
  System.out.println("Menu:");
  System.out.println("1. Register as new client");
  System.out.println("2. Create new survey");
  System.out.println("3. Show survey");
  System.out.println("0. Exit");
  System.out.println("--------------------");
 }

 public void displayMenu(boolean active) {
  this.mainMenu = active;
 }

}

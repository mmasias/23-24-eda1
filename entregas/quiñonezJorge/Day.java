import java.util.Scanner;

public class Day implements DataProvider {

  private String name;
  private Tree<Brunch> brunches = null;
  private boolean open = false;

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

  public void open() {
    this.open = true;
    int input;
    do {
      this.printMenu();
      input = new Scanner(System.in).nextInt();
      this.manageInput(input);
    } while (input != 0);
  }

  public void close() {
    this.open = false;
  }

  private void printMenu() {
    if (this.open) {
      System.out.println();
      System.out.println(this.name);
      System.out.println("--------------------");
      System.out.println("Menu:");
      System.out.println("1. Fill breakfast");
      System.out.println("2. Fill mid morning");
      System.out.println("3. Fill lunch");
      System.out.println("4. Fill snack");
      System.out.println("5. Fill dinner");
      System.out.println("6. Fill late dinner");
      System.out.println("7. Show brunches");
      System.out.println("0. Return");
      System.out.println("--------------------");
      System.out.print("Choose an option: ");
    }
  }

  @Override
  public void printData() {
    System.out.println("        " + this.name);
    this.showBrunches();
  }

  private void manageInput(int input) {
    Brunch brunch = null;
    switch (input) {
      case 1:
        brunch = new Brunch("Breakfast");
        break;
      case 2:
        brunch = new Brunch("Mid morning");
        break;
      case 3:
        brunch = new Brunch("Lunch");
        break;
      case 4:
        brunch = new Brunch("Snack");
        break;
      case 5:
        brunch = new Brunch("Dinner");
        break;
      case 6:
        brunch = new Brunch("Late dinner");
        break;
      case 7:
        this.showBrunches();
        break;
      case 0:
        this.close();
        break;
      default:
        this.invalidOption();
        break;
    }
    if (brunch != null) {
      this.createBrunch(brunch, input);
    }
  }

  private void createBrunch(Brunch brunch, int index) {
    Node<Brunch> node = new Node<Brunch>(brunch, index);
    if (!this.brunches.has(node)) {
      this.brunches.insert(node);
      this.openBrunch(index);
    } else {
      this.openBrunch(index);
    }
  }

  private void openBrunch(int index) {
    Brunch brunch = this.brunches.get(index);
    this.open = false;
    brunch.open();
    this.open = true;
  }

  public void showBrunches() {
    this.brunches.printInOrder(this.brunches.getRoot());
    new Scanner(System.in).nextLine();
  }

  private void invalidOption() {
    System.out.println("Invalid option");
    new Scanner(System.in).nextLine();
  }

}

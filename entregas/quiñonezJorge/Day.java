import java.util.Scanner;

public class Day implements DataProvider {

  private String name;
  private Tree<Brunch> brunches;
  private boolean isOpen = false;

  public Day(String name) {
    this.name = name;
    this.brunches = new Tree<Brunch>();
  }

  public String getName() {
    return name;
  }

  public void start() {
    this.open();
    int input;
    do {
      this.printMenu();
      input = new Scanner(System.in).nextInt();
      this.manageInput(input);
    } while (input != 0);
  }

  public void open() {
    this.isOpen = true;
  }

  public void close() {
    this.isOpen = false;
  }

  private void printMenu() {
    if (this.isOpen) {
      this.clearTerminal();
      System.out.println(this.name);
      this.printOptions();
    }
  }

  private void clearTerminal() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private void printOptions() {
    System.out.println("--------------------");
    System.out.println("Menu:");
    System.out.println("1. Breakfast");
    System.out.println("2. Mid morning");
    System.out.println("3. Lunch");
    System.out.println("4. Snack");
    System.out.println("5. Dinner");
    System.out.println("6. Late dinner");
    System.out.println("7. Show brunches");
    System.out.println("0. Return");
    System.out.println("--------------------");
    System.out.println();
    System.out.print("Choose an option: ");
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
        this.clearTerminal();
        this.showBrunches();
        new Scanner(System.in).nextLine();
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
    this.close();
    brunch.start();
    this.open();
  }

  private void showBrunches() {
    System.out.println("        " + this.name);
    this.brunches.printInOrder(this.brunches.getRoot());
  }

  private void invalidOption() {
    System.out.println("Invalid option");
    new Scanner(System.in).nextLine();
  }

  @Override
  public void printData() {
    this.showBrunches();
  }
}

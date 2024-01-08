import java.util.Scanner;

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
    do {
      this.printMenu();
      input = new Scanner(System.in).nextInt();
      this.manageInput(input);
    } while (input != 0);
  }

  private void close() {
    this.open = false;
  }

  private void printMenu() {
    if (this.open) {
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
    System.out.println("1. Add food");
    System.out.println("2. Show food");
    System.out.println("0. Return");
    System.out.println("--------------------");
    System.out.print("Select an option: ");
  }

  private void manageInput(int input) {
    switch (input) {
      case 1:
        this.addFood();
        break;
      case 2:
        this.showFood();
        break;
      case 0:
        this.close();
        break;
      default:
        this.invalidOption();
        break;
    }
  }

  private void addFood() {
    String input;
    do {
      System.out.print("Enter food name: ");
      input = new Scanner(System.in).nextLine();
      if (!input.equals("0")) {
        if (!input.equals("")) {
          this.food.add(new Node<Food>(new Food(input)));
        }
      }
    } while (!input.equals("0"));
  }

  private void showFood() {
    this.printList();
    new Scanner(System.in).nextLine();
  }

  private void printList() {
    if (!this.food.isEmpty()) {
      this.food.printAll();
    }
  }

  private void invalidOption() {
    System.out.println("Invalid option");
    new Scanner(System.in).nextLine();
  }

  @Override
  public void printData() {
    System.out.println("            " + this.name);
    this.printList();
  }
}

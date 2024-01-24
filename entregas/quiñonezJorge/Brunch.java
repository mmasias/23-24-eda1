import java.util.Scanner;

public class Brunch implements DataProvider {

  private String name;
  private List<Food> food;
  private boolean isOpen = false;

  public Brunch(String name) {
    this.name = name;
    this.food = new List<Food>();
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
    System.out.println("1. Add food");
    System.out.println("2. Open food");
    System.out.println("3. Show food");
    System.out.println("0. Return");
    System.out.println("--------------------");
    System.out.println();
    System.out.print("Select an option: ");
  }

  private void manageInput(int input) {
    switch (input) {
      case 1:
        this.addFood();
        break;
      case 2:
        this.openFood();
        break;
      case 3:
        this.clearTerminal();
        this.showFood();
        new Scanner(System.in).nextLine();
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
          this.food.add(new Node<Food>(new Food(input), this.food.getSize() + 1));
        }
      }
    } while (!input.equals("0"));
  }

  private void openFood() {
    if (!this.food.isEmpty()) {
      this.printList();
      System.out.print("Select the food with a number starting from 1: ");
      int input = new Scanner(System.in).nextInt();
      if (input > 0 && input <= this.food.getSize()) {
        Food selected = this.food.get(input);
        this.close();
        selected.start();
        this.open();
      }
    }
  }

  private void showFood() {
    System.out.println("            " + this.getName());
    this.printList();
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
    this.showFood();
  }
}

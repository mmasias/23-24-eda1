import java.util.Scanner;

public class Survey {

  private boolean open = false;
  private Tree<Day> week = null;

  public Survey() {
    this.week = new Tree<Day>();
  }

  public void open() {
    this.open = true;
    int input;
    this.printInstructions();
    this.printMenu();
    do {
      System.out.print("Select an option: ");
      input = new Scanner(System.in).nextInt();
      this.manageMenu(input);
    } while (input != 0);
  }

  private void printInstructions() {
    System.out.println();
    System.out.println("--------------------");
    System.out.println("Instructions:");
    System.out.println("During a week you must fill the form with all the brunches you had each day");
    System.out.println(
        "It's very important that you remember and be specific with the amount of food eaten, preparation methods, product brands, and portion sizes.");
    System.out.println("This also includes any food, drink, snacks or any other supplements you may have taken.");
    System.out.println("Please, be as accurate as possible.");
  }

  private void printMenu() {
    System.out.println("--------------------");
    System.out.println("Menu:");
    System.out.println("1. Monday");
    System.out.println("2. Tuesday");
    System.out.println("3. Wednesday");
    System.out.println("4. Thursday");
    System.out.println("5. Friday");
    System.out.println("0. Return");
    System.out.println("--------------------");
  }

  public void close() {
    this.open = false;
  }

  public boolean isOpen() {
    return this.open;
  }

  private void manageMenu(int input) {
    Day day = null;
    switch (input) {
      case 1:
        System.out.println("Editing Monday");
        day = new Day("Monday");
        break;
      case 2:
        System.out.println("Editing Tuesday");
        day = new Day("Tuesday");
        break;
      case 3:
        System.out.println("Editing Wednesday");
        day = new Day("Wednesday");
        break;
      case 4:
        System.out.println("Editing Thursday");
        day = new Day("Thursday");
        break;
      case 5:
        System.out.println("Editing Friday");
        day = new Day("Friday");
        break;
      case 0:
        break;
      default:
        this.invalidOption();
        break;
    }
    if (day != null) {
      this.createDay(day, input);
    }
  }

  private void createDay(Day day, int index) {
    Node<Day> node = new Node<Day>(day, index);
    if (!this.week.has(node)) {
      this.week.insert(node);
    } else {
      System.out.println("Day already created");
    }
    this.week.printInOrder(this.week.getRoot());
    new Scanner(System.in).nextLine();
  }

  private void invalidOption() {
    System.out.println("Invalid option");
    new Scanner(System.in).nextLine();
  }
}
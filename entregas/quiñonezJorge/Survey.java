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
    do {
      this.print();
      input = new Scanner(System.in).nextInt();
      this.manageInput(input);
    } while (input != 0);
  }

  public void close() {
    this.open = false;
  }

  private void print() {
    if (this.open) {
      this.clearTerminal();
      this.printInstructions();
      this.printMenu();
    }
  }

  private void clearTerminal() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
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
    System.out.println("6. Show days");
    System.out.println("0. Return");
    System.out.println("--------------------");
    System.out.print("Select an option: ");
  }

  private void manageInput(int input) {
    Day day = null;
    switch (input) {
      case 1:
        day = new Day("Monday");
        break;
      case 2:
        day = new Day("Tuesday");
        break;
      case 3:
        day = new Day("Wednesday");
        break;
      case 4:
        day = new Day("Thursday");
        break;
      case 5:
        day = new Day("Friday");
        break;
      case 6:
        this.clearTerminal();
        this.showDays();
        break;
      case 0:
        this.close();
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
      this.openDay(index);
    } else {
      this.openDay(index);
    }
  }

  private void openDay(int index) {
    Day day = this.week.get(index);
    this.open = false;
    day.open();
    this.open = true;
  }

  public void showDays() {
    System.out.println("    Survey ");
    this.week.printInOrder(this.week.getRoot());
    new Scanner(System.in).nextLine();
  }

  private void invalidOption() {
    System.out.println("Invalid option");
    new Scanner(System.in).nextLine();
  }
}
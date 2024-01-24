import java.util.Scanner;

public class Survey {

  private boolean isOpen = false;
  private List<Day> week;

  public Survey() {
    this.week = new List<Day>();
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
      this.printInstructions();
      this.printOptions();
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

  private void printOptions() {
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
    System.out.println();
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
      this.week.add(node);
      this.openDay(index);
    } else {
      this.openDay(index);
    }
  }

  private void openDay(int index) {
    Day day = this.week.get(index);
    this.close();
    day.start();
    this.open();
  }

  public void showDays() {
    this.week.printAll(this.week.getFirst());
    new Scanner(System.in).nextLine();
  }

  private void invalidOption() {
    System.out.println("Invalid option");
    new Scanner(System.in).nextLine();
  }
}
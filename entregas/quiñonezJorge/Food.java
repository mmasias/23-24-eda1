import java.util.Scanner;

public class Food implements DataProvider {

  private String name;
  private List<Nutrient> nutrients;
  private String preparationMethod;
  private String amount;
  private String brand;
  private String portionSize;
  private boolean isOpen = false;

  public Food(String name) {
    this.name = name;
    this.nutrients = new List<Nutrient>();
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
    System.out.println("1. Add nutrients");
    System.out.println("2. Add preparation method");
    System.out.println("3. Add amount");
    System.out.println("4. Add brand");
    System.out.println("5. Add portion size");
    System.out.println("6. Show information");
    System.out.println("0. Return");
    System.out.println("--------------------");
    System.out.println();
    System.out.print("Select an option: ");
  }

  private void manageInput(int input) {
    switch (input) {
      case 1:
        this.addNutrients();
        break;
      case 2:
        this.addPreparationMethod();
        break;
      case 3:
        this.addAmount();
        break;
      case 4:
        this.addBrand();
        break;
      case 5:
        this.addPortionSize();
        break;
      case 6:
        this.clearTerminal();
        this.showInformation();
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

  private void addNutrients() {
    String input;
    do {
      System.out.print("Enter nutrient: ");
      input = new Scanner(System.in).nextLine();
      if (!input.equals("0")) {
        if (!input.equals("")) {
          this.nutrients.add(new Node<Nutrient>(new Nutrient(input), this.nutrients.getSize() + 1));
        }
      }
    } while (!input.equals("0"));
  }

  private void addPreparationMethod() {
    System.out.print("Enter preparation method: ");
    this.preparationMethod = new Scanner(System.in).nextLine();
  }

  private void addAmount() {
    System.out.print("Enter amount: ");
    this.amount = new Scanner(System.in).nextLine();
  }

  private void addBrand() {
    System.out.print("Enter brand: ");
    this.brand = new Scanner(System.in).nextLine();
  }

  private void addPortionSize() {
    System.out.print("Enter portion size: ");
    this.portionSize = new Scanner(System.in).nextLine();
  }

  private void showInformation() {
    System.out.println("                " + this.getName());
    if (this.preparationMethod != null)
      System.out.println("                    Preparation method: " + this.preparationMethod);
    if (this.amount != null)
      System.out.println("                    Amount: " + this.amount);
    if (this.brand != null)
      System.out.println("                    Brand: " + this.brand);
    if (this.portionSize != null)
      System.out.println("                    Portion size: " + this.portionSize);
    this.printList();
  }

  private void printList() {
    if (!this.nutrients.isEmpty()) {
      System.out.println("                    Nutrients: ");
      this.nutrients.printAll();
    }
  }

  private void invalidOption() {
    System.out.println("Invalid option");
    new Scanner(System.in).nextLine();
  }

  @Override
  public void printData() {
    this.showInformation();
  }
}

import java.util.Scanner;

public class World {

  private boolean isOpen = true;
  private Client client;

  public static void main(String[] args) {
    World world = new World();
    world.start();
  }

  public void open() {
    this.isOpen = true;
  }

  public void close() {
    this.isOpen = false;
  }

  private void start() {
    int input;

    do {
      this.printMenu();
      input = new Scanner(System.in).nextInt();
      manageInput(input);
    } while (input != 0);
  }

  private void printMenu() {
    if (this.isOpen) {
      this.clearTerminal();
      this.printWelcome();
      this.printOptions();
    }
  }

  private void clearTerminal() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private void printWelcome() {
    if (this.existingClient()) {
      System.out.println();
      System.out.println("--------------------");
      System.out.println("Welcome " + this.client.getName());
    }
  }

  private void printOptions() {
    System.out.println("--------------------");
    System.out.println("Menu:");
    System.out.println("1. Register as new client");
    System.out.println("2. Create new survey");
    System.out.println("3. Open survey");
    System.out.println("4. Show results");
    System.out.println("0. Exit");
    System.out.println("--------------------");
    System.out.println();
    System.out.print("Choose an option: ");
  }

  private void manageInput(int input) {
    switch (input) {
      case 1:
        this.registerAsClient();
        break;
      case 2:
        this.manageSurveyCreation();
        break;
      case 3:
        this.openSurvey();
        break;
      case 4:
        this.showResults();
        break;
      case 0:
        break;
      default:
        this.invalidOption();
        break;
    }
  }

  private void registerAsClient() {
    System.out.print("Input your name: ");
    String name = new Scanner(System.in).nextLine();
    if (name.equals("")) {
      System.out.println("Name can't be empty");
      new Scanner(System.in).nextLine();
      return;
    }
    this.client = new Client(name);
  }

  private void manageSurveyCreation() {
    if (!this.existingClient()) {
      System.out.println();
      System.out.println("Can't create a survey without registering first");
      new Scanner(System.in).nextLine();
    } else {
      if (this.client.getSurvey() != null) {
        System.out.println();
        System.out.println("Are you sure you want to create a new survey? (y/n)");
        String input = new Scanner(System.in).nextLine();
        if (input.equals("y")) {
          this.close();
          this.client.createSurvey();
          this.client.openSurvey();
          this.open();
        } else {
          return;
        }
      } else {
        this.close();
        this.client.createSurvey();
        this.client.openSurvey();
        this.open();
      }
    }
  }

  private void openSurvey() {
    if (!this.existingClient()) {
      System.out.println();
      System.out.println("Can't open a survey without registering and creating it first");
      new Scanner(System.in).nextLine();
    } else {
      if (this.client.getSurvey() == null) {
        System.out.println("Can't open a survey without creating one first");
        new Scanner(System.in).nextLine();
      } else {
        this.close();
        this.client.openSurvey();
        this.open();
      }
    }
  }

  private void showResults() {
    if (this.existingClient() && this.client.getSurvey() != null) {
      this.close();
      this.clearTerminal();
      System.out.println("Client: " + this.client.getName());
      this.client.showSurvey();
      this.open();
    } else {
      System.out.println();
      System.out.println("Can't show results without creating a survey first");
      new Scanner(System.in).nextLine();
    }
  }

  private void invalidOption() {
    System.out.println("Invalid option");
    new Scanner(System.in).nextLine();
  }

  private boolean existingClient() {
    if (this.client != null) {
      return true;
    } else {
      return false;
    }
  }
}

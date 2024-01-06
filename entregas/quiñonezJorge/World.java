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
      this.printMenu();
      input = new Scanner(System.in).nextInt();
      manageInput(input);
    } while (input != 0);
  }

  private void printMenu() {
    if (this.mainMenu) {
      this.printWelcome();
      this.printOptions();
    }
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
    System.out.println("3. Show survey");
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
    this.client = new Client(name);
  }

  private void manageSurveyCreation() {
    if (!this.existingClient()) {
      System.out.println();
      System.out.println("Can't create a survey without registering first");
      new Scanner(System.in).nextLine();
    } else {
      this.mainMenu = false;
      this.client.createSurvey();
      this.client.displaySurvey();
      this.mainMenu = true;
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
        this.mainMenu = false;
        this.client.displaySurvey();
        this.mainMenu = true;
      }
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

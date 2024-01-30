import java.util.Scanner;

public class EatingTime implements Data {
    private String name;
    private List<FoodManage> food = null;
    private boolean attending = false;
    public EatingTime(String name) {
        this.name = name;
        this.food = new List<FoodManage>();
    }
    public void attending(){
        this.attending = true;
        int option;
        do {
            this.printMenu();
            option = new Scanner(System.in).nextInt();
            this.manageInput(option);
        } while (option != 0);
    }

    private void previousMenu() {
        this.attending = false;
    }

    private void printOptions() {
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        System.out.println("| Seleccione una accion ([1] para agregar comida / [2] para mostrar la comida / [0] para ir al menu anterior) |");
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        System.out.print(" ");
    }
    private void insertFood() {
        String foodInput;
        do {
            System.out.println("+------------------+");
            System.out.println("| Comida ingerida: ");
            foodInput = new Scanner(System.in).nextLine();
            if (!foodInput.equals("0")) {
                if (!foodInput.equals("")) {
                    this.food.insert(new Node<FoodManage>(new FoodManage(foodInput)));
                }
            }
        } while (!foodInput.equals("0"));
    }

    private void listFood() {
        this.printList();
        new Scanner(System.in).nextLine();
    }
    private void printList() {
        if (!this.food.isEmpty()) {
            this.food.display();
            System.out.println("+-----------------------------------------+");

        }
    }

    private void optionNotFound() {
        System.out.println("+-----------------------------------------+");
        System.out.println("| Por favor seleccionar una opcion valida |");
        System.out.println("+-----------------------------------------+");
        System.out.println(" ");
        new Scanner(System.in).nextLine();
    }

    private void manageInput(int input) {
        switch (input) {
            case 1:
                this.insertFood();
                break;
            case 2:
                this.listFood();
                break;
            case 0:
                this.previousMenu();
                break;
            default:
                this.optionNotFound();
                break;
        }
    }

    private void printMenu() {
        if (this.attending) {
            System.out.println(this.name);
            this.printOptions();
        }
    }

    @Override
    public void printData() {
        System.out.println("            " + this.name);
        this.printList();
    }
}


import utils.List;
import utils.Tree;
import utils.TreeNode;
import utils.TreeObject;

import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.Shortcut.print;
public class Manager {
    static private Tree<TreeObject> tree;
    public static void main (String[] args){
        Client client = init();
        tree = new Tree<TreeObject>(new Survey("Dieta de "+ client.getName() + " " + client.getLastName()));
        FoodData foodData = new FoodData();
        welcome();
        initTree();
        while (true){
            int option = mainMenuDisplay();
            switch (option){
                case 1:
                    tree.printTree(true);
                    break;
                case 2:
                    addIntake();
                    break;
                case 3:
                    addFood(foodData);
                    break;
                case 4:
                    addFoodManually();
                    break;
                case 5:
                    deleteFood();
                    break;
                case 6:
                    print("Hasta luego " + client.getName() + " " + client.getLastName());
                    return;
                default:
                    print("Opción no válida");
            }
        }
    }

    static Client init(){
        String name, lastName;
        Scanner input = new Scanner(System.in);
        print("Introduce tu nombre: ");
        name = input.nextLine();
        print("Introduce tu apellido: ");
        lastName = input.nextLine();
        return new Client(name, lastName);
    }
    static void welcome() {
        System.out.println("# # # # # # # # # # # # # # # # # #");
        System.out.println("#            Bienvenido           #");
        System.out.println("# Puedes seleccionar opciones con #");
        System.out.println("#            los números          #");
        System.out.println("# # # # # # # # # # # # # # # # # #");
    }
    static int mainMenuDisplay() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "# ".repeat(17));
        System.out.println("# Elige una opción:             #");
        System.out.println("# 1. Ver dieta                  #");
        System.out.println("# 2. Añadir comida              #");
        System.out.println("# 3. Añadir alimento            #");
        System.out.println("# 4. Añadir alimento (manual)   #");
        System.out.println("# 5. Borrar alimento            #");
        System.out.println("# 6. Salir                      #");
        System.out.println("# ".repeat(17) + "\n");

        try {
            int option = input.nextInt();
            input.nextLine();
            return option;
        } catch (InputMismatchException e) {
            input.nextLine();
            print("Error: Debes ingresar un número entero.");
            return mainMenuDisplay();
        }
    }

    static void initTree(){
        for (int i = 0; i < 5; i++) {
            tree.addChildByParentIndex(new Day(String.valueOf(i+1)), 0);
        }
    }
    static void addIntake(){
        if (tree.getRoot().getChildren().peek().childrenSize() >= 5) {
            print("No puedes añadir más comidas");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Nombre de la comida: ");
        String name = input.nextLine();
        System.out.print("Hora abitual: ");
        String time = input.nextLine();
        for(int i = 1; i <= 5; i++){
            Intake newIntake = new Intake(name, time);
            tree.addChildByParentData(newIntake, String.valueOf(i));
        }
    }
    static void addFood(FoodData foodData){
        Scanner input = new Scanner(System.in);
        foodData.listFood();
        System.out.print("Introduce el indice: ");
        int index = input.nextInt();
        Food foodToAdd = foodData.getFoodByIndex(index);
        askDayAndIntake(foodToAdd);
    }

    static void addFoodManually(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nombre del alimento: ");
        String name = input.nextLine();
        System.out.print("Calorias (aprox): ");
        int calories = input.nextInt();
        Food newFood = new Food(name, calories);
        askDayAndIntake(newFood);
    }

    static void askDayAndIntake(Food foodData){
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el dia: ");
        String day = input.nextLine();
        System.out.print("Introduce la comida: ");
        String intake = input.nextLine();
        tree.addFoodByParentsData(foodData, day, intake);
        updateCalories(day, intake);
    }

    static void deleteFood(){
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el dia: ");
        String day = input.nextLine();
        System.out.print("Introduce la comida: ");
        String intake = input.nextLine();
        System.out.print("Introduce el alimento: ");
        String food = input.nextLine();
        tree.deleteFoodByData(day, intake, food);
        updateCalories(day, intake);
    }

    static void updateCalories(String dayD, String intakeD) {
        TreeNode node = tree.getTreeNodeByTwoData(dayD, intakeD);
        if (node == null) {
            return;
        }
        Intake intake = (Intake) node.getData();
        int caloriesSum = 0;
        for (TreeNode childNode : (List<TreeNode>) node.getChildren()) {
            Food food = (Food) childNode.getData();
            caloriesSum += food.getCalories();
        }
        intake.setTotalCalories(caloriesSum);

        node = tree.getTreeNodeByData(dayD);
        if (node == null) {
            return;
        }
        Day day = (Day) node.getData();
        caloriesSum = 0;
        for (TreeNode childNode : (List<TreeNode>) node.getChildren()) {
            intake = (Intake) childNode.getData();
            caloriesSum += intake.getTotalCalories() ;
        }
        day.setTotalCalories(caloriesSum);
    }
}

package RetoListas;

import utils.List;
import utils.Tree;
import utils.TreeNode;
import utils.TreeObject;

import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.Shortcut.print;

public class ManagerListVersion {
    static private Survey tree;
    public static void main (String[] args){
        Client client = init();
        tree = new Survey("Dieta de "+ client.getName() + " " + client.getLastName());
        FoodData foodData = new FoodData();
        welcome();
        initTree();
        while (true){
            int option = mainMenuDisplay();
            switch (option){
                case 1:
                    printTree();
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
            tree.addDayChild(new Day(String.valueOf(i+1)), -1);
        }
    }
    static void printTree(){
        print(tree.toString());
        for (Day day:tree.getChildren()) {
            System.out.print(" ".repeat(4)+"└─--" + day.printDay());
            day.toString();
            System.out.println("");
            for (Intake intake:day.getChildren()) {
                System.out.print(" ".repeat(8)+"└─--" + intake.printIntake());
                System.out.println("");
                for (Food food:intake.getChildren()) {
                    System.out.print(" ".repeat(12)+"└─--" + food.printFood());
                    System.out.println("");
                }
            }
        }
    }
    static void addIntake(){
        if (tree.getChildren().peek().size() >= 5) {
            print("No puedes añadir más comidas");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Nombre de la comida: ");
        String name = input.nextLine();
        System.out.print("Hora abitual: ");
        String time = input.nextLine();
        for (Day day: tree.getChildren()) {
            day.addIntakeChild(new Intake(name, time));
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
        String dayString = input.nextLine();
        System.out.print("Introduce la comida: ");
        String intakeString = input.nextLine();
        for (Day day:tree.getChildren()) {
            if (day.toString().equals(dayString)){
                for (Intake intake:day.getChildren()) {
                    if (intake.toString().equals(intakeString)) {
                        intake.addChild(foodData);
                        break;
                    }
                }
            }
        }
        updateCalories(dayString, intakeString);
    }

    static void deleteFood(){
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el dia: ");
        String dayString = input.nextLine();
        System.out.print("Introduce la comida: ");
        String intakeString = input.nextLine();
        System.out.print("Introduce el alimento: ");
        String foodString = input.nextLine();
        for (Day day:tree.getChildren()) {
            if (day.toString().equals(dayString)){
                for (Intake intake:day.getChildren()) {
                    if (intake.toString().equals(intakeString)) {
                        int cont = 0;
                        for (Food food:intake.getChildren()) {
                            if(food.toString().equals(foodString)){
                                intake.deleteByIndex(cont);
                                break;
                            }
                            cont ++;
                        }
                    }
                }
            }
        }
        updateCalories(dayString, intakeString);
    }

    static void updateCalories(String dayD, String intakeD) {
        Day dayToUpdate = null;
        Intake intakeToUpdate = null;

        for (Day day : tree.getChildren()) {
            if (day.toString().equals(dayD)) {
                dayToUpdate = day;
                for (Intake intake : day.getChildren()) {
                    if (intake.toString().equals(intakeD)) {
                        intakeToUpdate = intake;
                        break;
                    }
                }
                break;
            }
        }

        if (dayToUpdate == null || intakeToUpdate == null) {
            print("Error: No se encontró el día o la comida especificada.");
            return;
        }

        int caloriesSum = 0;
        for (Food food : intakeToUpdate.getChildren()) {
            caloriesSum += food.getCalories();
        }
        intakeToUpdate.setTotalCalories(caloriesSum);

        caloriesSum = 0;
        for (Intake intake : dayToUpdate.getChildren()) {
            caloriesSum += intake.getTotalCalories();
        }
        dayToUpdate.setTotalCalories(caloriesSum);
    }

}

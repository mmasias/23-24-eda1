
import utils.Tree;

import java.util.Scanner;

import static utils.Shortcut.print;
public class Manager {
    static private Tree<Object> tree;
    public static void main (String[] args){
        Client client = init();
        tree = new Tree<Object>("Dieta de "+ client.getName() + " " + client.getLastName());
        FoodData foodData = new FoodData();
        welcome();
        initTree();
        while (true){
            int option = mainMenuDisplay(client.getName(), client.getLastName());
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
    static void welcome(){
        print("# ".repeat(20));
        print("# Bienvenido!!!!!");
        print("# Puedes seleccionar las opciones con los numeros");
        print("# ".repeat(20)+"\n");
    }
    static int mainMenuDisplay(String name, String surname) {
        Scanner input = new Scanner(System.in);
        print("\n"+"# ".repeat(14));
        print("# Elige una opción: ");
        print("# 1. Ver dieta");
        print("# 2. Añadir comida");
        print("# 3. Añadir alimento");
        print("# 4. Añadir alimento (manual)");
        print("# 5. Salir");
        print("# ".repeat(14)+"\n");

        int option = input.nextInt();
        input.nextLine();

        return option;
    }

    static void initTree(){
        for (int i = 0; i < 5; i++) {
            tree.addChildByParentIndex("Dia " + (i + 1), 0);
        }
    }
    static void addIntake(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nombre de la comida: ");
        String name = input.nextLine();
        System.out.print("Hora abitual: ");
        String time = input.nextLine();
        Intake newIntake = new Intake(name, time);
        tree.addChildByParentIndex(newIntake, 1);
    }
    static void addFood(FoodData foodData){
        foodData.listFood();
    }

    static void addFoodManually(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nombre del alimento: ");
        String name = input.nextLine();
        System.out.print("Calorias (aprox): ");
        int calories = input.nextInt();
        Food newFood = new Food(name, calories);
        tree.addChildByParentIndex(newFood, 2);
    }
}

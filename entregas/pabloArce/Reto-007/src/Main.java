import java.util.Scanner;

import static utils.Shortcut.print;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Intake intake = new Intake();
        while(true){
            print("Agregue un alimento a la ingesta");
            Food food = new Food(scanner.nextLine());
            intake.addFood(food);
            print("Desea agregar otro alimento? (s/n)");
            if(scanner.nextLine().equals("n")){
                break;
            }
        }
        intake.displayFoodList();
    }

}
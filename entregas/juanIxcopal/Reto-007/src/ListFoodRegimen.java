import java.util.ArrayList;
import java.util.List;

public class ListFoodRegimen {
    private FoodRegimenNode firstMeal = null;

    public void addMeal(String mealName) {
        FoodRegimenNode newMeal = new FoodRegimenNode(mealName);
        if (firstMeal == null) {
            firstMeal = newMeal;
        } else {
            FoodRegimenNode iterator = firstMeal;
            while (iterator.getNextRegimenNode() != null) {
                iterator = iterator.getNextRegimenNode();
            }
            iterator.setNextRegimenNode(newMeal);
        }
    }

    public void addFoodToMeal(String mealName, String food) {
        FoodRegimenNode iterator = firstMeal;
        while (iterator != null) {
            if (iterator.getFoodRegimen().equalsIgnoreCase(mealName)) {
                iterator.addFood(food);
                return;
            }
            iterator = iterator.getNextRegimenNode();
        }
        System.out.println("Meal not found: " + mealName);
    }

    public void listFoodRegimen() {
        FoodRegimenNode iterator = firstMeal;
        while (iterator != null) {
            System.out.print(iterator.getFoodRegimen() + " : ");
            String[] foods = iterator.listFoods();
            for (String food : foods) {
                System.out.print(food + ", ");
            }
            System.out.println();
            iterator = iterator.getNextRegimenNode();
        }
    }
}

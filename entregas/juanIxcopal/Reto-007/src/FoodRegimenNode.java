import java.util.ArrayList;
import java.util.List;

public class FoodRegimenNode {
    private String foodRegimen;
    private FoodConsumedNode firstFoodConsumed = null;
    private FoodRegimenNode nextFoodRegimen;

    public FoodRegimenNode(String foodRegimen) {
        this.foodRegimen = foodRegimen;
    }

    public String getFoodRegimen() {
        return foodRegimen;
    }

    public FoodRegimenNode getNextRegimen() {
        return nextFoodRegimen;
    }

    public void setNextRegimen(FoodRegimenNode nextFoodRegimen) {
        this.nextFoodRegimen = nextFoodRegimen;
    }

    public void addFood(String food) {
        FoodConsumedNode newFoodConsumed = new FoodConsumedNode(food);
        if (firstFoodConsumed == null) {
            firstFoodConsumed = newFoodConsumed;
        } else {
            FoodConsumedNode foodConsumedIterator = firstFoodConsumed;
            while (foodConsumedIterator.getNextFoodConsumed() != null) {
                foodConsumedIterator = foodConsumedIterator.getNextFoodConsumed();
            }
            foodConsumedIterator.setNextFoodConsumed(newFoodConsumed);
        }
    }

    public String[] listFoods() {
        List<String> foodsList = new ArrayList<>();
        FoodConsumedNode foodConsumedIterator = firstFoodConsumed;
        while (foodConsumedIterator != null) {
            foodsList.add(foodConsumedIterator.getFoodConsumed());
            foodConsumedIterator = foodConsumedIterator.getNextFoodConsumed();
        }
        return foodsList.toArray(new String[0]);
    }
}

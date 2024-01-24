import java.util.ArrayList;
import java.util.List;

public class FoodRegimenNode {
    private String foodRegimen;
    private FoodConsumedNode firstFood = null;
    private FoodRegimenNode next;

    public FoodRegimenNode(String foodRegimen) {
        this.foodRegimen = foodRegimen;
    }

    public String getFoodRegimen() {
        return foodRegimen;
    }

    public FoodRegimenNode getNextRegimenNode() {
        return next;
    }

    public void setNextRegimenNode(FoodRegimenNode next) {
        this.next = next;
    }

    public void addFood(String food) {
        FoodConsumedNode newFood = new FoodConsumedNode(food);
        if (firstFood == null) {
            firstFood = newFood;
        } else {
            FoodConsumedNode foodIterator = firstFood;
            while (foodIterator.getNextFoodConsumed() != null) {
                foodIterator = foodIterator.getNextFoodConsumed();
            }
            foodIterator.setNextFoodConsumed(newFood);
        }
    }

    public String[] listFoods() {
        List<String> foodsList = new ArrayList<>();
        FoodConsumedNode foodIterator = firstFood;
        while (foodIterator != null) {
            foodsList.add(foodIterator.getFoodConsumed());
            foodIterator = foodIterator.getNextFoodConsumed();
        }
        return foodsList.toArray(new String[0]);
    }
}

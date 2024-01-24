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

    public void setNextRegimen(FoodRegimenNode newFoodRegimen) {
        this.nextFoodRegimen = newFoodRegimen;
    }

    public void addFoodConsumed(String foodConsumed) {
        FoodConsumedNode newFoodConsumed = new FoodConsumedNode(foodConsumed);
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

    public String[] listRegimenFoods() {
        List<String> listRegimenFoods = new ArrayList<>();
        FoodConsumedNode foodConsumedIterator = firstFoodConsumed;
        while (foodConsumedIterator != null) {
            listRegimenFoods.add(foodConsumedIterator.getFoodConsumed());
            foodConsumedIterator = foodConsumedIterator.getNextFoodConsumed();
        }
        return listRegimenFoods.toArray(new String[0]);
    }
}

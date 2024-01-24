public class FoodConsumedNode {
    private String foodConsumed;
    private FoodConsumedNode nextFoodConsumed;

    public FoodConsumedNode(String foodConsumed) {
        this.foodConsumed = foodConsumed;
    }

    public String getFoodConsumed() {
        return foodConsumed;
    }

    public FoodConsumedNode getNextFoodConsumed() {
        return nextFoodConsumed;
    }

    public void setNextFoodConsumed(FoodConsumedNode newNextFoodConsumed) {
        this.nextFoodConsumed = newNextFoodConsumed;
    }
}

public class FoodConsumedNode {
    private String foodConsumed;
    private FoodConsumedNode next;

    public FoodConsumedNode(String foodConsumed) {
        this.foodConsumed = foodConsumed;
    }

    public String getFoodConsumed() {
        return foodConsumed;
    }

    public FoodConsumedNode getNextFoodConsumed() {
        return next;
    }

    public void setNextFoodConsumed(FoodConsumedNode next) {
        this.next = next;
    }
}

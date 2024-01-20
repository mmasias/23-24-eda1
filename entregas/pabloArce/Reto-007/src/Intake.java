import utils.List;

public class Intake {
    private List<Food> foodList;

    public Intake() {
        foodList = new List<Food>();
    }
    public void addFood(Food food) {
        foodList.insert(food, -1);
    }
    public void removeFood(int index) {
        foodList.remove(index);
    }
    public Object[] getFoodList() {
        return foodList.listData();
    }

    public void displayFoodList() {
        for(Object food : foodList.listData()){
            System.out.println(food.toString());
        }
    }
}

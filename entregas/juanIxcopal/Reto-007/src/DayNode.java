public class DayNode {
    private String day;
    private DayNode next;
    private ListFoodRegimen foodRegimen;

    public DayNode(String value) {
        this.setValueDay(value);
        this.foodRegimen = new ListFoodRegimen();
    }

    public String getDay() {
        return day;
    }

    public DayNode getNextDay() {
        return next;
    }

    public void setValueDay(String newValue) {
        this.day = newValue;
    }

    public void setNextDay(DayNode next) {
        this.next = next;
    }

    public void addMeal(String mealName){
        foodRegimen.addMeal(mealName);
    }

    public ListFoodRegimen getFoodRegimen() {
        return foodRegimen;
    }

    public String listMeals() {
        StringBuilder result = new StringBuilder();
        String[] meals = foodRegimen.listFoodRegimen();
        for (String meal : meals) {
            result.append(meal).append(", ");
        }
        return result.toString();
    }
}

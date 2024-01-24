public class DayNode {
    private String day;
    private DayNode nextDay;
    private ListFoodRegimen listFoodRegimen;

    public DayNode(String value) {
        this.setDay(value);
        this.listFoodRegimen = new ListFoodRegimen();
    }

    public String getDay() {
        return day;
    }

    public DayNode getNextDay() {
        return nextDay;
    }
    public ListFoodRegimen getFoodRegimen() {
        return listFoodRegimen;
    }

    public void setDay(String newDay) {
        this.day = newDay;
    }

    public void setNextDay(DayNode nextDay) {
        this.nextDay = nextDay;
    }

    public void addMeal(String mealName){
        listFoodRegimen.addFood(mealName);
    }

}

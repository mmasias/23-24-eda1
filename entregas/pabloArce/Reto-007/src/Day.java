import utils.TreeObject;

public class Day implements TreeObject {
    private String number;
    private int totalCalories;
    public Day(String number) {
        this.number = number;
        this.totalCalories = 0;
    }
    @Override public String toString() {
        return number;
    }
    @Override public Object getDetails(){
        return "Day " + number + (this.totalCalories != 0 ?  " - " + this.totalCalories + " kcal" : "");
    }

    public int getTotalCalories(){return totalCalories;}
    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }
}

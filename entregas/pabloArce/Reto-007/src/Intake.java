import utils.List;
import utils.TreeObject;

public class Intake implements TreeObject {
    private String name;
    private String time;
    private int totalCalories;
    public Intake(String name, String time) {
        this.name = name;
        this.time = time;
    }
    @Override
    public String toString() {
        return name;
    }
    public String getTime(){
        return time;
    }
    public int getTotalCalories(){return totalCalories;}
    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    @Override
    public Object getDetails() {
        return this.time + " " + this.name + " " + (this.totalCalories != 0 ? this.totalCalories + " kcal" : "");
    }
}

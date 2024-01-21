import utils.List;

public class Intake {
    private String name;
    private String time;
    private int totalCalories;
    public Intake(String name, String time) {
        this.name = name;
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
}

package RetoListas;

import RetoListas.utils.IDataStructure;
import RetoListas.utils.List;

public class Intake implements IDataStructure {
    private String name;
    private String time;
    private int totalCalories;
    private List<Food> foodList;
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
    public List<Food> getChildren(){
        return this.foodList;
    }
    public void addChild (Food food){
        this.foodList.insert(food, -1);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return foodList.size();
    }

    @Override
    public Object[] listData() {
        return foodList.listData();
    }
}

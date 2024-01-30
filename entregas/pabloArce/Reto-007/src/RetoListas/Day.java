package RetoListas;

import RetoListas.utils.IDataStructure;
import RetoListas.utils.List;

public class Day implements IDataStructure {
    private String number;
    private int totalCalories;
    private List<Intake> intakeList;

    public Day(String number) {
        this.number = number;
        this.totalCalories = 0;
        this.intakeList = new List<Intake>();
    }
    @Override public String toString() {
        return number;
    }

    public String printDay(){
        return "Day " + number + (this.totalCalories != 0 ?  " - " + this.totalCalories + " kcal" : "");
    }

    public int getTotalCalories(){return totalCalories;}
    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }
    public void addIntakeChild(Intake newIntake){
        this.intakeList.insert(newIntake, -1);
    }
    public List<Intake> getChildren(){
        return this.intakeList;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return intakeList.size();
    }

    @Override
    public Object[] listData() {
        return intakeList.listData();
    }
}

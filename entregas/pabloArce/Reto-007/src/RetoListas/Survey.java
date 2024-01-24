package RetoListas;

import RetoListas.utils.List;

public class Survey {
    private String name;
    private List<Day> dayList;
    public Survey(String name){
        this.name = name;
    }
    public List<Day> getChildren(){
        return dayList;
    }
    public void addDayChild(Day newDay, int index){
        this.dayList.insert(newDay, index);
    }
    @Override public String toString() {
        return name;
    }
}

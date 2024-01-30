package RetoListas;

import RetoListas.utils.IDataStructure;
import RetoListas.utils.List;

public class Survey implements IDataStructure {
    private String name;
    private List<Day> dayList;
    public Survey(String name){
        this.name = name;
        this.dayList = new List<Day>();
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

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object[] listData() {
        return new Object[0];
    }
}

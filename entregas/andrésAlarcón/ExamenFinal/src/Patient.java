import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private List<Day> days;

    public Patient(String name) {
        this.name = name;
        this.days = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addDay(int dayNumber, Day day) {
        days.add(day);
    }

    public Day getDay(int dayNumber) {
        return days.size() >= dayNumber ? days.get(dayNumber - 1) : null;
    }
}
public class Patient {
    String name;
    CustomDate dischargeDate;
    List<Day> days;

    public Patient(String name) {
        this.name = name;
        dischargeDate = new CustomDate((int) (Math.random()*30+1), (int) (Math.random()*12+1), 2023);
        days = new List<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(CustomDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    void addDay(Day day) {
        days.insert(day, -1);
    }


    void showData() {
    }
}

class Patient {
    private String name;
    private List days;

    public Patient(String name) {
        this.name = name;
        this.days = new List();
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
        return (Day) days.get(dayNumber - 1);
    }
}
public class Survey {
    private DayNode first = null;

    private int size = 0;

    public int size() {
        return this.size;
    }

    public void insertDay(String value) {
        DayNode newNode = new DayNode(value);
        if (this.first == null) {
            this.first = newNode ;
        } else {
            DayNode iterator = this.first;
            while (iterator.getNextDay() != null) {
                iterator = iterator.getNextDay();
            }
            iterator.setNextDay(newNode);
        }
        this.size ++;
    }

    public void addFoodRegimenToDay(String day, String foodRegimenName){
        DayNode iterator = first;
        while (iterator != null) {
            if (iterator.getDay().equalsIgnoreCase(day)) {
                iterator.addFoodRegimen(foodRegimenName);
                return;
            }
            iterator = iterator.getNextDay();
        }
        System.out.println("Día no encontrado: " + day);
    }

    public DayNode getDayNode(String day) {
        DayNode iterator = first;
        while (iterator != null) {
            if (iterator.getDay().equalsIgnoreCase(day)) {
                return iterator;
            }
            iterator = iterator.getNextDay();
        }
        System.out.println("Día no encontrado: " + day);
        return null;
    }

    public void listAllDaysWithFoodRegimenAndFood() {
        DayNode iterator = this.first;
        while (iterator != null) {
            System.out.println(iterator.getDay() + ":");

            iterator.getFoodRegimen().listFoodRegimen();

            iterator = iterator.getNextDay();
        }
    }
}

public class Week {
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

    public void addMealToDay(String day, String mealName){
        DayNode iterator = first;
        while (iterator != null) {
            if (iterator.getDay().equalsIgnoreCase(day)) {
                iterator.addMeal(mealName);
                return;
            }
            iterator = iterator.getNextDay();
        }
        System.out.println("Day not found: " + day);
    }

    public void listWeek() {
        DayNode iterator = first;
        while (iterator != null) {
            System.out.println(iterator.getDay());
            iterator.getFoodRegimen().listFoodRegimen();
            iterator = iterator.getNextDay();
        }
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



    public ListFoodRegimen getFoodRegimenForDay(String day) {
        DayNode iterator = first;
        while (iterator != null) {
            if (iterator.getDay().equalsIgnoreCase(day)) {
                return iterator.getFoodRegimen();
            }
            iterator = iterator.getNextDay();
        }
        System.out.println("Day not found: " + day);
        return null;
    }

    public String[] listDays() {
        String[] list = new String[this.size()];
        DayNode iterator = this.first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getDay();
            System.out.println(iterator.getDay());
            count++;
            iterator = iterator.getNextDay();
        }
        return list;
    }

}

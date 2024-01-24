public class Survey {
    private DayNode firstDay = null;
    private int size = 0;
    public int size() {
        return this.size;
    }

    public void insertDay(String newDay) {
        DayNode newDayNode = new DayNode(newDay);
        if (this.firstDay == null) {
            this.firstDay = newDayNode ;
        } else {
            DayNode dayNodeIterator = this.firstDay;
            while (dayNodeIterator.getNextDay() != null) {
                dayNodeIterator = dayNodeIterator.getNextDay();
            }
            dayNodeIterator.setNextDay(newDayNode);
        }
        this.size ++;
    }

    public void addFoodRegimenToDay(String day, String foodRegimenName){
        DayNode dayNodeIterator = firstDay;
        while (dayNodeIterator != null) {
            if (dayNodeIterator.getDay().equalsIgnoreCase(day)) {
                dayNodeIterator.addFoodRegimen(foodRegimenName);
                return;
            }
            dayNodeIterator = dayNodeIterator.getNextDay();
        }
        System.out.println("!!----- Día no encontrado: " + day + " -----!!");
    }

    public DayNode getSurveyDay(String surveyDay) {
        DayNode dayNodeIterator = firstDay;
        while (dayNodeIterator != null) {
            if (dayNodeIterator.getDay().equalsIgnoreCase(surveyDay)) {
                return dayNodeIterator;
            }
            dayNodeIterator = dayNodeIterator.getNextDay();
        }
        System.out.println("!!----- Encuesta del día " + surveyDay +" no encontrada -----!!");
        return null;
    }

    public void listAllDaysWithFoodRegimenAndFood() {
        DayNode dayNodeIterator = this.firstDay;
        while (dayNodeIterator != null) {
            System.out.println(dayNodeIterator.getDay() + ":");
            dayNodeIterator.getFoodRegimen().listFoodRegimen();
            dayNodeIterator = dayNodeIterator.getNextDay();
        }
    }
}

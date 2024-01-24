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
        System.out.println("Nombre del Paciente: " + name);
        dischargeDate.showData();
        Node<Day> currentDay = days.getFirst();

        // Lista de todos los nombres de ingestas que deberían mostrarse
        List<String> allIntakeNames = new List<>();
        allIntakeNames.insert("Desayuno", -1);
        allIntakeNames.insert("Media mañana", -1);
        allIntakeNames.insert("Almuerzo", -1);
        allIntakeNames.insert("Merienda", -1);
        allIntakeNames.insert("Cena", -1);

        while (currentDay != null) {
            Day day = currentDay.getData();
            System.out.println("  " + day.getName());

            Node<Intakes> currentIntake = day.getIntakes().getFirst();

            // Recorre la lista de nombres de ingestas utilizando índices
            for (int i = 0; i < allIntakeNames.size(); i++) {
                String intakeName = (String) allIntakeNames.listData()[i];
                boolean intakeFound = false;

                while (currentIntake != null) {
                    Intakes intakes = currentIntake.getData();
                    if (intakes.getName().equals(intakeName)) {
                        System.out.println("    " + intakes.getName());

                        Node<Food> currentFood = intakes.getFoods().getFirst();
                        while (currentFood != null) {
                            Food food = currentFood.getData();
                            System.out.println("      " + food.getName() + " (" + food.getKcal() + " kcal)");
                            currentFood = currentFood.getNext();
                        }
                        intakeFound = true;
                        break;
                    }
                    currentIntake = currentIntake.getNext();
                }

                // Si no se encontró la ingesta en el día, muestra un mensaje
                if (!intakeFound) {
                    System.out.println("    " + intakeName);
                }

                // Reinicia el puntero de ingestas para la próxima iteración
                currentIntake = day.getIntakes().getFirst();
            }
            currentDay = currentDay.getNext();
        }
    }
}


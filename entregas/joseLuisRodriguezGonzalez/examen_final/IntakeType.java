package entregas.joseLuisRodriguezGonzalez.examen_final;

class IntakeType {
    private String type;
    private Intakes intakes;

    public IntakeType(String type, Intakes intakes) {
        this.type = type;
        this.intakes = intakes;
    }

    public String getType() {
        return type;
    }

    public Intakes getIntakes() {
        return intakes;
    }

    public String toString() {
        return "Intake " + type + ": " + intakes.toString();
    }
   
}
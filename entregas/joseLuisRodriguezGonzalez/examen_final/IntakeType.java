package entregas.joseLuisRodriguezGonzalez.examen_final;

class IntakeType {
    private String type;
    private Intakes intakes;

    public IntakeType(String type, Intakes intakes) {
        this.type = type;
        this.intakes = intakes;
    }

    public String getTipo() {
        return type;
    }

    public Intakes getIngestas() {
        return intakes;
    }

    public String toString() {
        return "Intake " + type + ": " + intakes.toString();
    }
   
}
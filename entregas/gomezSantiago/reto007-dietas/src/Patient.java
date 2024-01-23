public class Patient {
    private String name;
    private Evaluation evaluation;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void createEvaluation() {
        this.evaluation = new Evaluation();
    }

    public void openEvaluation() {
        this.evaluation.attending();
    }

    public void showEvaluation() {
        System.out.println("Nombre del paciente: " + this.name);
        this.evaluation.showEvaluationDays();
    }
}

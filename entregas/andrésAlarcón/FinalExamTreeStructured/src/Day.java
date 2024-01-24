class Day {
    private List intakes;

    public Day() {
        this.intakes = new List();
    }

    public void addIntake(String intakeType, Intake intake) {
        intakes.add(intake);
    }

    public Intake getIntake(String intakeType) {
        for (int i = 0; i < intakes.size(); i++) {
            Intake intake = (Intake) intakes.get(i);
            if (intakeType.equalsIgnoreCase(intake.getIntakeType())) {
                return intake;
            }
        }
        return null;
    }
}
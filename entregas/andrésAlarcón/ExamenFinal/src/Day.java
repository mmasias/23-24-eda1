import java.util.ArrayList;
import java.util.List;

class Day {
    private List<Intake> intakes;

    public Day() {
        this.intakes = new ArrayList<>();
    }

    public void addIntake(String intakeType, Intake intake) {
        intakes.add(intake);
    }

    public Intake getIntake(String intakeType) {
        for (Intake intake : intakes) {
            // Intake types are case-insensitive
            if (intakeType.equalsIgnoreCase(intake.getIntakeType())) {
                return intake;
            }
        }
        return null;
    }
}
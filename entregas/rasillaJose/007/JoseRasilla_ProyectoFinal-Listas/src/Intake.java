import structure.ListNode;

public class Intake extends ListNode {

    public String intakeDescription = "";

    public Intake(String description) {
        super(false, "Intake");
        this.intakeDescription = description;
    }
    
}
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserNode {
    private String name;
    private LocalDate dischargeDate;
    private UserNode next;
    private Survey survey;

    public UserNode(String value){
        this.setValueUser(value);
        this.setDischargeDate(LocalDate.now());
        this.survey = new Survey();
    }

    public String getName(){
        return name;
    }

    public String getDischargeDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dischargeDate.format(formatter);
    }

    public UserNode getNextUser(){
        return next;
    }

    public void setValueUser(String newValue) {
        this.name = newValue;
    }

    public void setDischargeDate(LocalDate newDischargeDate){
        this.dischargeDate = newDischargeDate;
    }

    public void setNextUser(UserNode next){
        this.next = next;
    }

    public Survey getSurvey() {
        return survey;
    }
}

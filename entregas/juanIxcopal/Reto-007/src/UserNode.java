import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserNode {
    private String name;
    private LocalDate dischargeDate;
    private UserNode next;

    public UserNode(String value){
        this.setValueUser(value);
        this.setDischargeDate(LocalDate.now());
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
}

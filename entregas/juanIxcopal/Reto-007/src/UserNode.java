import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserNode {
    private String name;
    private LocalDate dischargeDate;
    private UserNode next;
    private Week week;

    public UserNode(String value){
        this.setValueUser(value);
        this.setDischargeDate(LocalDate.now());
        this.week = new Week();
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

    public Week getWeek() {
        return week;
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

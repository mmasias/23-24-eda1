import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    private String name;
    private LocalDate dischargeDate;
    private User next;


    public User(String value){
        this.setValue(value);
        this.setDischargeDate(LocalDate.now());
    }

    public String getName(){
        return name;
    }

    public String getDischargeDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dischargeDate.format(formatter);
    }

    public User getNext(){
        return next;
    }

    public void setValue(String newValue) {
        this.name = newValue;
    }

    public void setDischargeDate(LocalDate newDischargeDate){
        this.dischargeDate = newDischargeDate;
    }

    public void setNext(User next){
        this.next = next;
    }
}

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserNode {
    private String userName;
    private LocalDate dischargeDate;
    private UserNode nextUser;
    private Survey survey;

    public UserNode(String userName){
        this.setUserName(userName);
        this.setDischargeDate(LocalDate.now());
        this.survey = new Survey();
    }

    public String getUserName(){
        return userName;
    }

    public String getDischargeDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dischargeDate.format(formatter);
    }

    public UserNode getNextUser(){
        return nextUser;
    }

    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }

    public void setDischargeDate(LocalDate newDischargeDate){
        this.dischargeDate = newDischargeDate;
    }

    public void setNextUser(UserNode newNextUser){
        this.nextUser = newNextUser;
    }

    public Survey getSurvey() {
        return survey;
    }
}

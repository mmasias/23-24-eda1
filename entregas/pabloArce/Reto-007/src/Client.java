import utils.*;

public class Client {
    private String name;
    private String lastName;
    private List<Survey> surveyList;
    public Client(String name, String lastName) {
        setName(name);
        setLastName(lastName);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("lastName cannot be null");
        }
        this.lastName = lastName;
    }
}

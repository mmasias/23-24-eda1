public class Client {
    private String name;
    private Survey survey;

    public Client(String name) {
        this.name = name;
        this.survey = new Survey();
    }

    public Survey getSurvey(){
        return this.survey;
    }
    
    public String getName() {
        return name;
    }
}
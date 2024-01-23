public class Client {

 private String name;
 private Survey survey;

 public Client(String name) {
  this.name = name;
 }

 public String getName() {
  return name;
 }

 public Survey getSurvey() {
  return survey;
 }

 public void createSurvey() {
  this.survey = new Survey();
 }

 public void openSurvey() {
  this.survey.start();
 }

 public void showSurvey() {
  System.out.println("    Survey ");
  this.survey.showDays();
 }
}

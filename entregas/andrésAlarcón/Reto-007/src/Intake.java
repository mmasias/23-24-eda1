import java.util.ArrayList;
import java.util.List;

class Intake {
    private List<Food> foods;
    private String intakeType;

    public Intake(String intakeType) {
        this.foods = new ArrayList<>();
        this.intakeType = intakeType;
    }

    public String getIntakeType() {
        return intakeType;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public List<Food> getFoods() {
        return foods;
    }
}
import utils.TreeObject;

public class Food implements TreeObject {
    private String name;
    private int calories;
    public Food(String name, int calories) {
        setName(name);
        setCalories(calories);
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public Object getDetails() {
        return this.name + " " + this.calories + " kcal";
    }
    public int getCalories() {
        return calories;
    }
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
    }
    public void setCalories(int calories) {
        if (calories < 0) {
            throw new IllegalArgumentException("calories cannot be negative");
        }
        this.calories = calories;
    }

}

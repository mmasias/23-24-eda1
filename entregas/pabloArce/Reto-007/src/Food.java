public class Food {
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

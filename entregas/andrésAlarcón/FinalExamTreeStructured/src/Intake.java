class Intake {
    private List foods;
    private String intakeType;

    public Intake(String intakeType) {
        this.foods = new List();
        this.intakeType = intakeType;
    }

    public String getIntakeType() {
        return intakeType;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public List getFoods() {
        return foods;
    }
}
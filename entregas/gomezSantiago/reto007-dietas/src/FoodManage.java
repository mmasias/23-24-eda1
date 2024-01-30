public class FoodManage implements Data {
    private String foodName;

    public FoodManage(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    @Override
    public void printData() {
        System.out.println("                " + this.getFoodName());
    }
}

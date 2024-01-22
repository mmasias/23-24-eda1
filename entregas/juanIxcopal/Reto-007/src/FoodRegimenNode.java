public class FoodRegimenNode {
    private String foodRegimen;
    private FoodRegimenNode next;

    public FoodRegimenNode(String value) {
        this.setValue(value);
    }

    public String getFoodRegimen() {
        return foodRegimen;
    }

    public void setValue(String newValue) {
        this.foodRegimen = newValue;
    }

    public FoodRegimenNode getNext() {
        return next;
    }

    public void setNext(FoodRegimenNode next) {
        this.next = next;
    }
}

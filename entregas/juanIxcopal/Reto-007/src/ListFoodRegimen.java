public class ListFoodRegimen {
    private FoodRegimenNode firstMeal = null;

    public void addFood(String mealName) {
        FoodRegimenNode newMeal = new FoodRegimenNode(mealName);
        if (firstMeal == null) {
            firstMeal = newMeal;
        } else {
            FoodRegimenNode iterator = firstMeal;
            while (iterator.getNextRegimen() != null) {
                iterator = iterator.getNextRegimen();
            }
            iterator.setNextRegimen(newMeal);
        }
    }

    public void addFoodToMeal(String mealName, String food) {
        FoodRegimenNode iterator = firstMeal;
        while (iterator != null) {
            if (iterator.getFoodRegimen().equalsIgnoreCase(mealName)) {
                iterator.addFood(food);
                return;
            }
            iterator = iterator.getNextRegimen();
        }
        System.out.println("Régimen de comida no encontrada: " + mealName);
    }

    public String[] listFoodRegimen() {
        FoodRegimenNode iterator = firstMeal;
        while (iterator != null) {
            System.out.println("\t" + iterator.getFoodRegimen());
            String[] foods = iterator.listFoods();
            for (String food : foods) {
                System.out.println("\t" + "\t" + food);
            }
            iterator = iterator.getNextRegimen();
        }
        return new String[0];
    }
}

public class ListFoodRegimen {
    private FoodRegimenNode firstFoodRegimen = null;

    public void addFoodRegimenToList(String foodRegimenName) {
        FoodRegimenNode newFoodRegimen = new FoodRegimenNode(foodRegimenName);
        if (firstFoodRegimen == null) {
            firstFoodRegimen = newFoodRegimen;
        } else {
            FoodRegimenNode foodRegimenIterator = firstFoodRegimen;
            while (foodRegimenIterator.getNextRegimen() != null) {
                foodRegimenIterator = foodRegimenIterator.getNextRegimen();
            }
            foodRegimenIterator.setNextRegimen(newFoodRegimen);
        }
    }

    public void addFoodConsumedToFoodRemigen(String foodRegimen, String foodConsumed) {
        FoodRegimenNode foodRegimenIterator = firstFoodRegimen;
        while (foodRegimenIterator != null) {
            if (foodRegimenIterator.getFoodRegimen().equalsIgnoreCase(foodRegimen)) {
                foodRegimenIterator.addFoodConsumed(foodConsumed);
                return;
            }
            foodRegimenIterator = foodRegimenIterator.getNextRegimen();
        }
        System.out.println("Régimen de comida no encontrada: " + foodRegimen);
    }

    public String[] listFoodRegimen() {
        FoodRegimenNode foodRegimenIterator = firstFoodRegimen;
        while (foodRegimenIterator != null) {
            System.out.println("\t" + foodRegimenIterator.getFoodRegimen());
            String[] regimenFoods = foodRegimenIterator.listRegimenFoods();
            for (String food : regimenFoods) {
                System.out.println("\t" + "\t" + food);
            }
            foodRegimenIterator = foodRegimenIterator.getNextRegimen();
        }
        return new String[0];
    }
}

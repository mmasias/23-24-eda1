//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Week weekOne= new Week();

        weekOne.insertDay("Lunes");
        weekOne.insertDay("Martes");
        weekOne.insertDay("Miercoles");
        weekOne.insertDay("Jueves");
        weekOne.insertDay("Viernes");

        weekOne.listDays();*/

        /*ListUsers users = new ListUsers();

        users.insertUser("Juan");
        users.insertUser("René");

        users.listAllUsers();*/


        // Crear un régimen de comida
        ListFoodRegimen foodRegimen = new ListFoodRegimen();

        // Añadir comidas al régimen
        foodRegimen.addMeal("Desayuno");
        foodRegimen.addMeal("Media Mañana");
        foodRegimen.addMeal("Almuerzo");
        foodRegimen.addMeal("Merienda");
        foodRegimen.addMeal("Cena");

        // Añadir alimentos a diferentes comidas
        foodRegimen.addFoodToMeal("Desayuno", "Huevos");
        foodRegimen.addFoodToMeal("Desayuno", "Pan integral");
        foodRegimen.addFoodToMeal("Almuerzo", "Ensalada");
        foodRegimen.addFoodToMeal("Cena", "Pescado");
        foodRegimen.addFoodToMeal("Media Mañana", "Batido de fresa");

        // Listar el régimen de comida
        foodRegimen.listFoodRegimen();

    }
}
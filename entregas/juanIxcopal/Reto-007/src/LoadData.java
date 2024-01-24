public class LoadData {
    public void loadPresetData(Survey survey){
        // Insertar días de la semana
        survey.insertDay("Lunes");
        survey.insertDay("Martes");
        survey.insertDay("Miercoles");
        survey.insertDay("Jueves");
        survey.insertDay("Viernes");

        // Añadir comidas a diferentes días de la semana
        survey.addFoodRegimenToDay("Lunes", "Desayuno");
        survey.addFoodRegimenToDay("Lunes", "Media Mañana");
        survey.addFoodRegimenToDay("Lunes", "Almuerzo");
        survey.addFoodRegimenToDay("Lunes", "Merienda");
        survey.addFoodRegimenToDay("Lunes", "Cena");

        survey.addFoodRegimenToDay("Martes", "Desayuno");
        survey.addFoodRegimenToDay("Martes", "Media Mañana");
        survey.addFoodRegimenToDay("Martes", "Almuerzo");
        survey.addFoodRegimenToDay("Martes", "Merienda");
        survey.addFoodRegimenToDay("Martes", "Cena");

        survey.addFoodRegimenToDay("Miercoles", "Desayuno");
        survey.addFoodRegimenToDay("Miercoles", "Media Mañana");
        survey.addFoodRegimenToDay("Miercoles", "Almuerzo");
        survey.addFoodRegimenToDay("Miercoles", "Merienda");
        survey.addFoodRegimenToDay("Miercoles", "Cena");

        survey.addFoodRegimenToDay("Jueves", "Desayuno");
        survey.addFoodRegimenToDay("Jueves", "Media Mañana");
        survey.addFoodRegimenToDay("Jueves", "Almuerzo");
        survey.addFoodRegimenToDay("Jueves", "Merienda");
        survey.addFoodRegimenToDay("Jueves", "Cena");

        survey.addFoodRegimenToDay("Viernes", "Desayuno");
        survey.addFoodRegimenToDay("Viernes", "Media Mañana");
        survey.addFoodRegimenToDay("Viernes", "Almuerzo");
        survey.addFoodRegimenToDay("Viernes", "Merienda");
        survey.addFoodRegimenToDay("Viernes", "Cena");
    }
}

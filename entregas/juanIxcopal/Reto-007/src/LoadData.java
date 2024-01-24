public class LoadData {
    public void loadPresetData(Survey survey){
        // Insertar días de la semana
        survey.insertDay("Lunes");
        survey.insertDay("Martes");
        survey.insertDay("Miercoles");
        survey.insertDay("Jueves");
        survey.insertDay("Viernes");

        // Añadir comidas a diferentes días de la semana
        survey.addMealToDay("Lunes", "Desayuno");
        survey.addMealToDay("Lunes", "Media Mañana");
        survey.addMealToDay("Lunes", "Almuerzo");
        survey.addMealToDay("Lunes", "Merienda");
        survey.addMealToDay("Lunes", "Cena");

        survey.addMealToDay("Martes", "Desayuno");
        survey.addMealToDay("Martes", "Media Mañana");
        survey.addMealToDay("Martes", "Almuerzo");
        survey.addMealToDay("Martes", "Merienda");
        survey.addMealToDay("Martes", "Cena");

        survey.addMealToDay("Miercoles", "Desayuno");
        survey.addMealToDay("Miercoles", "Media Mañana");
        survey.addMealToDay("Miercoles", "Almuerzo");
        survey.addMealToDay("Miercoles", "Merienda");
        survey.addMealToDay("Miercoles", "Cena");

        survey.addMealToDay("Jueves", "Desayuno");
        survey.addMealToDay("Jueves", "Media Mañana");
        survey.addMealToDay("Jueves", "Almuerzo");
        survey.addMealToDay("Jueves", "Merienda");
        survey.addMealToDay("Jueves", "Cena");

        survey.addMealToDay("Viernes", "Desayuno");
        survey.addMealToDay("Viernes", "Media Mañana");
        survey.addMealToDay("Viernes", "Almuerzo");
        survey.addMealToDay("Viernes", "Merienda");
        survey.addMealToDay("Viernes", "Cena");
    }
}

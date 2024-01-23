import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Week week = new Week();

        // Insertar días de la semana
        week.insertDay("Lunes");
        week.insertDay("Martes");
        week.insertDay("Miercoles");
        week.insertDay("Jueves");
        week.insertDay("Viernes");

        // Añadir comidas a diferentes días de la semana
        week.addMealToDay("Lunes", "Desayuno");
        week.addMealToDay("Lunes", "Media Mañana");
        week.addMealToDay("Lunes", "Almuerzo");
        week.addMealToDay("Lunes", "Merienda");
        week.addMealToDay("Lunes", "Cena");

        week.addMealToDay("Martes", "Desayuno");
        week.addMealToDay("Martes", "Media Mañana");
        week.addMealToDay("Martes", "Almuerzo");
        week.addMealToDay("Martes", "Merienda");
        week.addMealToDay("Martes", "Cena");

        week.addMealToDay("Miercoles", "Desayuno");
        week.addMealToDay("Miercoles", "Media Mañana");
        week.addMealToDay("Miercoles", "Almuerzo");
        week.addMealToDay("Miercoles", "Merienda");
        week.addMealToDay("Miercoles", "Cena");

        week.addMealToDay("Jueves", "Desayuno");
        week.addMealToDay("Jueves", "Media Mañana");
        week.addMealToDay("Jueves", "Almuerzo");
        week.addMealToDay("Jueves", "Merienda");
        week.addMealToDay("Jueves", "Cena");

        week.addMealToDay("Viernes", "Desayuno");
        week.addMealToDay("Viernes", "Media Mañana");
        week.addMealToDay("Viernes", "Almuerzo");
        week.addMealToDay("Viernes", "Merienda");
        week.addMealToDay("Viernes", "Cena");

        Scanner scanner = new Scanner(System.in);

        // Insertar días de la semana y añadir comidas y alimentos
        // (Código anterior, como en tu ejemplo)

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ver días de la semana");
            System.out.println("2. Ver régimen de comida de un día");
            System.out.println("3. Ver comidas y alimentos de un día");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    System.out.println("Días de la semana:");
                    week.listDays();
                    break;
                case 2:
                    System.out.println("Ingrese el día para ver su régimen de comida:");
                    String dia = scanner.nextLine();
                    week.getFoodRegimenForDay(dia).listFoodRegimen();
                    break;
                case 3:
                    System.out.println("Ingrese el día para ver y añadir comidas (o 'return' para volver):");
                    String diaComidas = scanner.nextLine();

                    if (diaComidas.equalsIgnoreCase("return")) {
                        break;
                    }

                    DayNode dayNode = week.getDayNode(diaComidas);
                    if (dayNode != null) {
                        System.out.println(dayNode.getDay() + ":");

                        // Mostrar las comidas actuales del día
                        dayNode.getFoodRegimen().listFoodRegimen();

                        // Añadir comidas al régimen de comida del día
                        System.out.println("Ingrese la categoría de la comida (Desayuno, Almuerzo, Cena, etc.) (o 'return' para volver):");
                        String categoria = scanner.nextLine();

                        while (!categoria.equalsIgnoreCase("return")) {
                            System.out.println("Ingrese la comida que desea añadir (o 'return' para volver):");
                            String nuevaComida = scanner.nextLine();
                            if (nuevaComida.equalsIgnoreCase("return")) {
                                break;
                            }
                            dayNode.getFoodRegimen().addFoodToMeal(categoria, nuevaComida);
                            System.out.println("Comida añadida con éxito.");

                        }

                        // Mostrar el régimen de comida actualizado
                        dayNode.getFoodRegimen().listFoodRegimen();
                    } else {
                        System.out.println("Día no encontrado.");
                    }
                    break;


                case 4:
                    continuar = false;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        // Cerrar el scanner al salir
        scanner.close();
    }
}

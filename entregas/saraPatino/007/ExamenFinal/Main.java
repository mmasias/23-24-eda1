package ExamenFinal;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<String> pacientes = new List<>();

        while (true) {
            String paciente = name();
            pacientes.insert(paciente, -1);

            System.out.println(paciente);
            int selectedDay = selectDay();

            String dia = getDayNodeOrCreateNew(pacientes, selectedDay);
            if (dia != null) {
                setIngesta(dia, scanner);
            }
        }
    }

    public static String name() {
        System.out.println("Ingresa tu nombre");
        return scanner.nextLine();
    }

    public static int selectDay() {
        while (true) {
            System.out.println("Seleccione día de 1 a 5 (-1 para mostrar información / -2 para salir): ");
            int selectedDay = scanner.nextInt();

            if (selectedDay == -2) {
                System.out.println("Saliendo del programa...");
                System.exit(0);
            } else if (selectedDay == -1) {
                // Agrega aquí la lógica para mostrar información de pacientes
                System.out.println("Mostrar información de pacientes");
            } else if (selectedDay > 5 || selectedDay < 1) {
                System.out.println("Número no disponible");
            } else {
                return selectedDay;
            }
        }
    }

    public static void setIngesta(String dia, Scanner scanner) {
        while (true) {
            System.out.println(
                    "Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menu anterior)");
            int selectedMeal = scanner.nextInt();
            if (selectedMeal == -1) {
                break;
            }

            scanner.nextLine(); // Limpiar el buffer del scanner

            String mealName = getMealName(selectedMeal);
            String ingesta = getMealNodeOrCreateNew(dia, mealName);

            if (ingesta != null) {
                addFoods(ingesta, scanner);
            }
        }
    }

    public static void addFoods(String ingesta, Scanner scanner) {
        while (true) {
            System.out.println("Ingrese un alimento (-1 para terminar / -2 para listar alimentos ingresados): ");
            String food = scanner.nextLine();

            if (food.equals("-1")) {
                break;
            } else if (food.equals("-2")) {
                // Agrega aquí la lógica para listar alimentos ingresados
                System.out.println("Listar alimentos ingresados");
            } else {
                // Agrega aquí la lógica para agregar alimentos a la ingesta
                System.out.println("Agregar alimento a la ingesta: " + food);
            }
        }
    }

    public static String getDayNodeOrCreateNew(List<String> pacientes, int selectedDay) {
        for (String paciente : pacientes.listData()) {
            if (paciente.startsWith("Dia " + selectedDay)) {
                return paciente;
            }
        }

        String newDia = "Dia " + selectedDay;
        pacientes.insert(newDia, -1);
        return newDia;
    }

    public static String getMealNodeOrCreateNew(String dia, String mealName) {
        // Puedes mejorar esta lógica según tus necesidades
        return dia + " - " + mealName;
    }

    public static String getMealName(int selectedMeal) {
        switch (selectedMeal) {
            case 1:
                return "Desayuno";
            case 2:
                return "Media mañana";
            case 3:
                return "Almuerzo";
            case 4:
                return "Merienda";
            case 5:
                return "Cena";
            default:
                return "";
        }
    }
}
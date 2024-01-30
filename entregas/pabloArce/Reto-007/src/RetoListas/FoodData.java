package RetoListas;

import RetoListas.utils.List;

import static utils.Shortcut.print;

public class FoodData {
    private List<Food> foodList;

    public FoodData(){
        foodList = new List<Food>();
        initFood();
    }
    private void initFood() {
        String[] foodNames = {"Fresas", "Piña", "Mango", "Pasta", "Atún", "Repollo", "Maníes",
                "Leche", "Granola", "Sandwich de Pavo", "Quinoa", "Uvas", "Cerezas",
                "Batata", "Miel", "Queso Cottage", "Kiwi", "Tomate", "Durazno",
                "Wrap de Lechuga", "Moras", "Yogur Griego", "Nueces", "Coliflor",
                "Espárragos", "Semillas de Calabaza", "Garbanzos", "Sushi", "Aguacate",
                "Pera", "Sandía", "Plátano", "Coco", "Pimiento", "Huevo Cocido",
                "Tofu", "Almendras", "Melocotón", "Cebolla", "Pepino", "Papaya",
                "Ciruelas", "Aceitunas", "Calabacín", "Remolacha", "Arándanos", "Caqui",
                "Helado", "Melón", "Pistachos", "Zanahoria", "Pepinillos", "Alcachofas",
                "Hummus", "Frijoles Negros", "Calabaza", "Avena", "Sopa de Verduras",
                "Langosta", "Ternera", "Pollo", "Salchichas", "Pargo", "Bacalao",
                "Pan Integral", "Pan de Ajo", "Galletas Integrales", "Crema de Cacahuate",
                "Champiñones", "Arroz Integral", "Panqueques", "Cangrejo", "Salmón",
                "Mantequilla de Almendra", "Higos", "Caña de Azúcar", "Espinacas", "Habas",
                "Guayaba", "Pomelos", "Patatas Fritas", "Pollo a la Parrilla", "Peras",
                "Brócoli", "Helado de Vainilla", "Palomitas de Maíz", "Tostadas", "Guisantes",
                "Rúcula", "Tofu a la Parrilla", "Mantequilla de Maní", "Lentejas", "Hamburguesa Vegetariana",
                "Risotto", "Pastel de Chocolate", "Pan de Centeno", "Tiramisú", "Alcachofas a la Parrilla",
                "Ensalada de Frutas", "Sopa de Lentejas", "Tacos", "Salsa de Tomate", "Sopa de Pollo",
                "Macarrones con Queso", "Sándwich de Pollo", "Hamburguesa con Queso", "Té Verde", "Café"};

        int[] foodCalories = {32, 50, 60, 131, 144, 25, 567, 42, 407, 320, 120, 69, 50, 86, 304,
                220, 61, 18, 59, 110, 43, 32, 59, 654, 27, 20, 559, 164, 164, 45,
                160, 30, 89, 354, 24, 68, 144, 574, 59, 42, 98, 59, 42, 74, 46, 19,
                42, 30, 68, 125, 17, 69, 50, 85, 235, 164, 120, 154, 98, 76, 185,
                215, 60, 78, 92, 87, 68, 83, 106, 143, 190, 72, 91, 110, 28, 145,
                78, 65, 120, 95, 230, 195, 105, 130, 48, 80, 120, 72, 150, 110, 95,
                160, 180, 215, 130, 94, 120, 150, 70, 110, 180, 240, 120, 140, 90};

        for (int i = 0; i < foodCalories.length; i++) {
            Food food = new Food(foodNames[i], foodCalories[i]);
            foodList.insert(food, -1);
        }
    }

    public void listFood() {
        int index = 0;
        for (Food foodItem : foodList) {
            System.out.println(index + 1 +". " + foodItem);
            index++;
        }
        print("");
    }

    public Food getFoodByIndex(int index) {
        int cont = 1;
        for (Food food : foodList) {
            if (cont == index) {
                return food;
            }
            cont++;
        }
        return null;
    }

    public List<Food> exportFoodData() {
        return foodList;
    }
}

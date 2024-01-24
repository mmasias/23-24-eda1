

import java.util.Scanner;

public class Menu {
    static List<Node<Patient>> pacientes = new List<>();
    static List<Food> alimentos = new List<>();
    static Scanner numeros = new Scanner(System.in);
    static Scanner textos = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = showMenu();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion Invalida");
                    break;
            }
        } while (opcion != 5);
    }

    private static int showMenu() {

        System.out.println("\n---DIETAS---");
        System.out.println("1 - Añadir Dietas");
        System.out.println("2 - Mostrar Dietas");
        System.out.println("3 - Buscar Paciente");
        System.out.println("4 - Eliminar Paciente");
        System.out.println("5 - Salir");
        System.out.print("\nElige Opcion: ");
        return numeros.nextInt();
    }

    public static void showFood(){
        for(int i=0;i<alimentos.size();i++){
            System.out.println(alimentos.get(i).getName()+" ("+alimentos.get(i).getKcal()+" kcal)");
        }
    }







    private static String obtenerNombreIngesta(int ingesta) {
        switch (ingesta) {
            case 1: return "Desayuno";
            case 2: return "Media mañana";
            case 3: return "Almuerzo";
            case 4: return "Merienda";
            case 5: return "Cena";
            default: return "Invalido";
        }
    }




    private static void agregarAlimentosAIngesta() {
        String alimento;
        do {
            System.out.println("Ingrese un alimento (-1 para terminar / -2 para listar alimentos ingresados):");
            alimento = textos.nextLine();

            if (!alimento.equals("-1") && !alimento.equals("-2")) {
                System.out.print("Ingrese las kcal para " + alimento + ": ");
                int kcal = numeros.nextInt();
                alimentos.insert(new Food(alimento, kcal),-1);
            } else if (alimento.equals("-2")) {
                showFood();
            }
        } while (!alimento.equals("-1"));
    }
}

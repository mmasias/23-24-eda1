import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static ArrayList<Food> alimentos = new ArrayList<Food>();
    static ArrayList<TreeNode> diets = new ArrayList<TreeNode>();
    static int posicion=-1;

    static Scanner numeros = new Scanner(System.in);
    static Scanner textos = new Scanner(System.in);

    static int opcion = 0;  //Opcion bucle menu
    static String alimento = null;


    public static void main(String[] args) {


        do {

            int opcionSeleccionada = showMenu();



            if (opcionSeleccionada == 1) {
                System.out.print("Paciente: ");
                String pacienteBuscado = textos.nextLine();

                if (findPatient(pacienteBuscado)) {
                    System.out.println("\nEl paciente ya existe.");
                } else {
                    System.out.print("Seleccione día: ");
                    int dia = numeros.nextInt(); // Convierte el String a int

                    while (true) {
                        System.out.print("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena): ");
                        int ingesta = numeros.nextInt();
                        String ingestaNombre = obtenerNombreIngesta(ingesta);
                        if (ingestaNombre.equals("Invalido")) {
                            System.out.println("Ingesta no válida.");
                            continue;
                        }

                        System.out.println("Agregando alimentos para " + ingestaNombre + " del día " + dia);
                        alimentos.clear(); // Limpiar la lista de alimentos para nueva ingesta

                        agregarAlimentosAIngesta();

                        addDiet(pacienteBuscado, dia, ingesta); // Agregar la ingesta al paciente y día seleccionados

                        break;


                    }
                }

            }  else if (opcionSeleccionada == 2) {

                if (diets.size() == 0) {
                    System.out.println("No hay menus guardados");
                } else {

                    for (int x = 0; x < diets.size(); x++) {
                        diets.get(x).printTree(true);
                    }

                }

            } else if (opcionSeleccionada == 3) {

                if (diets.isEmpty()) {
                    System.out.println("No hay ningun paciente registrado");
                } else {
                    System.out.print("Introduce nombre del Paciente: ");
                    String pacienteBuscado = textos.nextLine();
                    if (findPatient(pacienteBuscado)) {
                        TreeNode dieta = diets.get(posicion);
                        dieta.printTree(true);
                    } else {
                        System.out.println("\nPaciente no encontrado");
                    }


                }

            } else if(opcionSeleccionada == 4){

                if (diets.isEmpty()){
                    System.out.println("No hay ninguna paciente registrado");
                }else{
                    showNames();
                    System.out.print("\nQue paciente deseas eliminar?: ");
                    String nombreEliminar= textos.nextLine();

                    if (findPatient(nombreEliminar)) {
                        diets.remove(posicion);
                    }
                }


            }else if (opcionSeleccionada == 5) {

                System.out.println("Saliendo...");


            } else {
                System.out.println("Opcion Invalida");
            }



        }while(opcion!= 5);


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

    public static int showMenu(){
        System.out.println("\n---DIETAS---");
        System.out.println("1 - Añadir Dietas");
        System.out.println("2 - Mostrar Dietas");
        System.out.println("3 - Buscar Paciente");
        System.out.println("4 - Eliminar Paciente");
        System.out.println("5 - Salir");
        System.out.print("\nElige Opcion: ");
        opcion = numeros.nextInt();
        System.out.println();

        return opcion;
    }
    public static void showFood(){
        for(int i=0;i<alimentos.size();i++){
            System.out.println(alimentos.get(i).getName()+" ("+alimentos.get(i).getKcal()+" kcal)");
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
                alimentos.add(new Food(alimento, kcal));
            } else if (alimento.equals("-2")) {
                showFood();
            }
        } while (!alimento.equals("-1"));
    }
    public static void showNames(){


        for (int i=0;i<diets.size();i++){
            TreeNode dieta = diets.get(i);
            if (dieta.getValue() instanceof Patient) {
                Patient paciente = (Patient) dieta.getValue();
                System.out.println("- "+paciente.name);
            }
        }

    }

    public static boolean findPatient(String nombre){

        boolean pacienteEncontrado = false;

        for (int i = 0; i < diets.size(); i++) {
            TreeNode dieta = diets.get(i);

            if (dieta.getValue() instanceof Patient) {
                Patient paciente = (Patient) dieta.getValue();

                if (paciente.getName().equalsIgnoreCase(nombre)) {
                    posicion=i;

                    return true;
                }
            }
        }

        return false;


    }

}







}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListUsers listUsers = new ListUsers();
        Survey survey = new Survey();
        LoadDaysAndFoodRegimen loadDaysWithTheMealRegimen = new LoadDaysAndFoodRegimen();
        loadDaysWithTheMealRegimen.loadPresetData(survey);

        Scanner scanner = new Scanner(System.in);

        boolean continue = true;

        while (continue) {
            printLine();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Consultar Encuestas");
            System.out.println("2. Crear Usuario");
            System.out.println("3. Listar Todos los Usuarios");
            System.out.println("4. Salir");
            printLine();

            System.out.print(": ");
            int opcionMenuPrincipal = scanner.nextInt();
            scanner.nextLine();


            switch (opcionMenuPrincipal) {
                case 1:
                    boolean menuEncuestas = true;

                    while (menuEncuestas) {
                        printLine();
                        System.out.println("Seleccione una opción:");
                        System.out.println("1. Consultar encuesta de un usuario");
                        System.out.println("2. Volver al Menú Principal");
                        printLine();

                        System.out.print(": ");
                        int opcionMenuEncuestas = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionMenuEncuestas) {
                            case 1:
                                System.out.println("Ingrese el nombre del usuario para consultar la encuesta:");
                                String nombreUsuario = scanner.nextLine();
                                UserNode usuario = listUsers.getUserNode(nombreUsuario);

                                if (usuario != null) {
                                    boolean continuarEncuesta = true;
                                    while (continuarEncuesta) {
                                        printLine();
                                        System.out.println("Seleccione una opción:");
                                        System.out.println("1. Mostrar encuesta del usuario");
                                        System.out.println("2. Agregar comida a la encuesta");
                                        System.out.println("3. Volver al menú anterior");
                                        printLine();

                                        System.out.print(": ");
                                        int opcionEncuesta = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (opcionEncuesta) {
                                            case 1:
                                                System.out.println("Encuesta de " + nombreUsuario + ":");
                                                survey.listAllDaysWithFoodRegimenAndFood();
                                                break;
                                            case 2:
                                                System.out.println("Agregar comida a la encuesta de " + nombreUsuario + ":");
                                                System.out.println("Ingrese el día:");
                                                String surveyDay = scanner.nextLine();

                                                DayNode dayNodePrueba = survey.getSurveyDay(surveyDay);

                                                if(dayNodePrueba != null){
                                                    System.out.println(dayNodePrueba.getDay() + ":");

                                                    dayNodePrueba.getFoodRegimen().listFoodRegimen();

                                                    System.out.println("Ingrese la categoría de la comida (Desayuno, Almuerzo, Cena, etc.) (o 'return' para volver):");
                                                    String foodRegimen = scanner.nextLine();

                                                    while (!foodRegimen.equalsIgnoreCase("return")) {
                                                        System.out.println("Ingrese la comida que desea añadir (o 'return' para volver):");
                                                        String newFoodConsumed = scanner.nextLine();
                                                        if (newFoodConsumed.equalsIgnoreCase("return")) {
                                                            break;
                                                        }
                                                        dayNodePrueba.getFoodRegimen().addFoodConsumedToFoodRemigen(foodRegimen, newFoodConsumed);
                                                        System.out.println("Comida añadida con éxito.");

                                                    }

                                                    dayNodePrueba.getFoodRegimen().listFoodRegimen();
                                                }else {
                                                    System.out.println("Día no encontrado.");
                                                }
                                                break;
                                            case 3:
                                                continuarEncuesta = false;
                                                break;
                                            default:
                                                System.out.println("Opción no válida. Inténtelo de nuevo.");
                                        }
                                    }
                                } else {
                                    System.out.println("Usuario no encontrado.");
                                }
                                break;
                            case 2:
                                menuEncuestas = false;
                                break;
                            default:
                                System.out.println("Opción no válida. Inténtelo de nuevo.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del nuevo usuario:");
                    String nuevoUsuario = scanner.nextLine();
                    listUsers.insertUser(nuevoUsuario);
                    System.out.println("Usuario creado con éxito.");
                    break;
                case 3:
                    System.out.println("Todos los usuarios:");
                    listUsers.listAllUsers();
                    break;
                case 4:
                    continue = false;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        scanner.close();
    }

    public static void printLine(){
        System.out.println("---------------------------------------------------------");
    }
}

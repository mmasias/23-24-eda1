import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListUsers listUsers = new ListUsers();
        Survey survey = new Survey();
        LoadDaysAndFoodRegimen loadDaysWithTheMealRegimen = new LoadDaysAndFoodRegimen();
        loadDaysWithTheMealRegimen.loadPresetData(survey);

        Scanner scanner = new Scanner(System.in);

        boolean continueProgram = true;

        while (continueProgram) {
            printLine();
            System.out.println("Seleccione una opción:");
            System.out.println("1. Consultar Encuestas");
            System.out.println("2. Crear Usuario");
            System.out.println("3. Listar Todos los Usuarios");
            System.out.println("4. Salir");
            printLine();

            System.out.print(": ");
            int mainMenuOption = scanner.nextInt();
            scanner.nextLine();


            switch (mainMenuOption) {
                case 1:
                    boolean surveyMenu = true;

                    while (surveyMenu) {
                        printLine();
                        System.out.println("Seleccione una opción:");
                        System.out.println("1. Consultar encuesta de un usuario");
                        System.out.println("2. Volver al Menú Principal");
                        printLine();

                        System.out.print(": ");
                        int surveyMenuOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (surveyMenuOption) {
                            case 1:
                                System.out.println("Ingrese el nombre del usuario para consultar la encuesta:");
                                String userName = scanner.nextLine();
                                UserNode user = listUsers.getUserNode(userName);

                                if (user != null) {
                                    boolean continueSurvey = true;
                                    while (continueSurvey) {
                                        printLine();
                                        System.out.println("Seleccione una opción:");
                                        System.out.println("1. Mostrar encuesta del usuario");
                                        System.out.println("2. Agregar comida a la encuesta");
                                        System.out.println("3. Volver al menú anterior");
                                        printLine();

                                        System.out.print(": ");
                                        int optionSurvey = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (optionSurvey) {
                                            case 1:
                                                System.out.println("Encuesta de " + userName + ":");
                                                survey.listAllDaysWithFoodRegimenAndFood();
                                                break;
                                            case 2:
                                                System.out.println("Agregar comida a la encuesta de " + userName);
                                                survey.listAllSurveyDays();
                                                System.out.println("Ingrese el día:");
                                                String inputSurveyDay = scanner.nextLine();

                                                DayNode surveyDay = survey.getSurveyDay(inputSurveyDay);

                                                if(surveyDay != null){
                                                    System.out.println(surveyDay.getDay() + ":");

                                                    surveyDay.getFoodRegimen().listFoodRegimen();

                                                    System.out.println("Ingrese el régimen de la comida (Desayuno, Almuerzo, Cena, etc.) (o 'return' para volver):");
                                                    String foodRegimen = scanner.nextLine();

                                                    while (!foodRegimen.equalsIgnoreCase("return")) {
                                                        System.out.println("Ingrese la comida que desea añadir (o 'return' para volver):");
                                                        String newFoodConsumed = scanner.nextLine();
                                                        if (newFoodConsumed.equalsIgnoreCase("return")) {
                                                            break;
                                                        }
                                                        surveyDay.getFoodRegimen().addFoodConsumedToFoodRemigen(foodRegimen, newFoodConsumed);
                                                        System.out.println("!!***** Comida añadida con éxito *****!!");
                                                    }

                                                    surveyDay.getFoodRegimen().listFoodRegimen();
                                                }else {
                                                    System.out.println("!!----- Día no encontrado -----!!");
                                                }
                                                break;
                                            case 3:
                                                continueSurvey = false;
                                                break;
                                            default:
                                                System.out.println("!!----- Opción no válida. Inténtelo de nuevo -----!!");
                                        }
                                    }
                                } else {
                                    System.out.println("!!----- Usuario no encontrado -----!!");
                                }
                                break;
                            case 2:
                                surveyMenu = false;
                                break;
                            default:
                                System.out.println("!!----- Opción no válida. Inténtelo de nuevo -----!!");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del nuevo usuario:");
                    String newUser = scanner.nextLine();
                    listUsers.insertUser(newUser);
                    System.out.println("!!***** Usuario creado con éxito *****!!");
                    break;
                case 3:
                    System.out.println("Todos los usuarios:");
                    listUsers.listAllUsers();
                    break;
                case 4:
                    continueProgram = false;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("!!----- Opción no válida. Inténtelo de nuevo -----!!");
            }
        }

        scanner.close();
    }

    public static void printLine(){
        System.out.println("---------------------------------------------------------");
    }
}

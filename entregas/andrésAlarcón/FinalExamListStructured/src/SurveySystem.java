import java.util.Scanner;

class SurveySystem {
    private Patient patient;
    private Scanner scanner;

    public SurveySystem() {
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        System.out.print("Enter the patient's name: ");
        this.patient = new Patient(scanner.nextLine());

        int option;
        do {
            System.out.println("Select an option:");
            System.out.println("1. Fill out survey for a day");
            System.out.println("2. Display current structure");
            System.out.println("3. Exit");
            System.out.print("Option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    fillOutSurvey();
                    break;
                case 2:
                    displayStructure();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 3);
    }

    private void fillOutSurvey() {
        System.out.print("Enter the day number (1-5): ");
        int dayNumber = scanner.nextInt();
        scanner.nextLine();

        if (dayNumber < 1 || dayNumber > 5) {
            System.out.println("Invalid day number. It must be between 1 and 5.");
            return;
        }

        List day = null;
        if (dayNumber <= patient.surveyData.size()) {
            day = (List) patient.surveyData.get(dayNumber - 1);
        }
        if (day == null) {
            day = new List();
            patient.surveyData.add(dayNumber - 1, day);
        }

        String anotherIntake;
        do {
            List intakeTypes = getIntakeTypes();
            System.out.println("Select the type of intake:");
            for (int i = 0; i < intakeTypes.size(); i++) {
                System.out.println((i + 1) + ". " + intakeTypes.get(i));
            }
            System.out.print("Option: ");
            int intakeTypeOption = scanner.nextInt();
            scanner.nextLine(); // Consume the newline after nextInt()

            if (intakeTypeOption < 1 || intakeTypeOption > intakeTypes.size()) {
                System.out.println("Invalid option. Please try again.");
                return;
            }

            String intakeType = (String) intakeTypes.get(intakeTypeOption - 1);
            fillIntake(day, intakeType);

            System.out.print("Do you want to fill out another intake type for the same day? (yes/no): ");
            anotherIntake = scanner.nextLine();
        } while (anotherIntake.equalsIgnoreCase("yes"));

        System.out.println("Survey for day " + dayNumber + " completed.");
    }

    private void fillIntake(List day, String intakeType) {
        List intake = new List();
        intake.add(intakeType);
        day.add(intake);

        System.out.println("Enter foods for " + intakeType + " (enter '-1' to finish): ");
        String foodName;
        while (true) {
            System.out.print("Food: ");
            foodName = scanner.nextLine();

            if (foodName.equals("-1")) {
                break;
            }

            intake.add(foodName);
        }
    }

    private void displayStructure() {
        System.out.println("Current structure:");
        System.out.println("Patient: " + patient.name);
        for (int i = 1; i <= 5; i++) {
            if (i <= patient.surveyData.size()) {
                List currentDay = (List) patient.surveyData.get(i - 1);
                if (currentDay != null) {
                    System.out.println("    Survey Day " + i);
                    for (Object obj : getIntakeTypes()) {
                        String intakeType = (String) obj;
                        if (getIntakeTypes().indexOf(intakeType) < currentDay.size()) {
                            List currentIntake = (List) currentDay.get(getIntakeTypes().indexOf(intakeType));
                            if (currentIntake != null) {
                                System.out.println("        " + intakeType);
                                for (int j = 1; j < currentIntake.size(); j++) {
                                    String food = (String) currentIntake.get(j);
                                    System.out.println("            " + food);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private List getIntakeTypes() {
        List intakeTypes = new List();
        intakeTypes.add("Breakfast");
        intakeTypes.add("Mid-morning");
        intakeTypes.add("Lunch");
        intakeTypes.add("Snack");
        intakeTypes.add("Dinner");
        return intakeTypes;
    }
}
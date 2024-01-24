import java.util.Scanner;

public class Clinic {
    private boolean startMenu = true;
    private Patient patient = null;

    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        clinic.Start();
    }

    public void Start() {
        int input;
        do {
            this.printStartMenu();
            input = new Scanner(System.in).nextInt();
            inputManage(input);
        } while (input != 0);
    }

    private void printStartMenu() {
        if (this.startMenu) {
            this.printInitMessage();
            this.displayOptions();
        }
    }

    private void printInitMessage() {
        if (this.registeredPatient()) {
            System.out.println();
            System.out.println("+------------------------------------+");
            System.out.println("| Paciente: " + this.patient.getName() + " |");
        }
    }

    private void displayOptions() {
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| Seleccione una opcion: ( 1 [Registrar Paciente] / 2 [Crear evaluacion] / 3 [Ver resultados de la evaluacion] /  0 [Salir]) |");
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println(" ");
    }

    private void registerNewPatient() {
        System.out.println("+----------------------+");
        System.out.println("| Nombre del paciente: ");
        System.out.println("+----------------------+");
        String name = new Scanner(System.in).nextLine();
        if (name.equals("")) {
            System.out.println("+-------------------------------------+");
            System.out.println("| Por favor ingresar un nombre valido |");
            System.out.println("+-------------------------------------+");
            new Scanner(System.in).nextLine();
            return;
        }
        this.patient = new Patient(name);
    }

    private void createNewEvaluation() {
        if (!this.registeredPatient()) {
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("| No se puede crear una evaluacion sin un paciente registrado |");
            System.out.println("+-------------------------------------------------------------+");
            new Scanner(System.in).nextLine();
        } else {
            this.startMenu = false;
            this.patient.createEvaluation();
            this.patient.openEvaluation();
            this.startMenu = true;
        }
    }

    private void viewEvaluation() {
        if (!this.registeredPatient()) {
            System.out.println("+---------------------------------------------------------------------------------------+");
            System.out.println("| No se puede ver una evaluacion sin un paciente registrado y sin una evaluacion creada |");
            System.out.println("+---------------------------------------------------------------------------------------+");
            new Scanner(System.in).nextLine();
        } else {
            if (this.patient.getEvaluation() == null) {
                System.out.println("+----------------------------------------------------------+");
                System.out.println("| No se puede ver una evaluacion sin una evaluacion creada |");
                System.out.println("+----------------------------------------------------------+");
                new Scanner(System.in).nextLine();
            } else {
                this.startMenu = false;
                this.patient.showEvaluation();
                this.startMenu = true;
            }
        }
    }

    private void optionNotFound() {
        System.out.println("+-----------------------------------------+");
        System.out.println("| Por favor seleccionar una opcion valida |");
        System.out.println("+-----------------------------------------+");
        System.out.println(" ");
        new Scanner(System.in).nextLine();
    }

    private void inputManage(int input) {
        switch (input) {
            case 1:
                this.registerNewPatient();
                break;
            case 2:
                this.createNewEvaluation();
                break;
            case 3:
                this.viewEvaluation();
                break;
            case 0:
                break;
            default:
                this.optionNotFound();
                break;
        }
    }

    private boolean registeredPatient() {
        if (this.patient != null) {
            return true;
        } else {
            return false;
        }
    }
}

import java.util.Scanner;

public class Evaluation {
    private boolean attending = false;
    private TreeManage<DayManage> week = null;

    public Evaluation() {
        this.week = new TreeManage<DayManage>();
    }

    public void attending(){
        this.attending = true;
        int option;
        do {
            this.display();
            option = new Scanner(System.in).nextInt();
            this.manageInput(option);
        } while (option != 0);
    }

    public void close() {
        this.attending = false;
    }

    private void display() {
        if (this.attending) {
            this.printIndex();
            this.printOptions();
        }
    }

    private void printIndex() {
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| Deberá de ir seleccionando el día en el cual quiere agregar una comida.                                                      |");
        System.out.println("| En cada día hay diferentes tiempos de comida en los cuales deberá seleccionar uno para agregar la comida que ingirió ese día |");
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println(" ");
    }

    private void printOptions() {
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("| Seleccione un día (entre Dia [1] - Dia [5]) para agregar la comida en ese día |");
        System.out.println("| Seleccione [0] para regresar / [6] para mostrar los días completos            |");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println(" ");
    }

    private void manageInput(int input) {
        DayManage dayManage = null;
        switch (input) {
            case 1:
                dayManage = new DayManage("Dia 1");
                break;
            case 2:
                dayManage = new DayManage("Dia 2");
                break;
            case 3:
                dayManage = new DayManage("Dia 3");
                break;
            case 4:
                dayManage = new DayManage("Dia 4");
                break;
            case 5:
                dayManage = new DayManage("Dia 5");
                break;
            case 6:
                this.showEvaluationDays();
                break;
            case 0:
                this.close();
                break;
            default:
                this.optionNotFound();
                break;
        }
        if (dayManage != null && week != null) {
            this.insertDay(dayManage, input);
        }
    }

    private void insertDay(DayManage day, int count) {
        Node<DayManage> node = new Node<DayManage>(day, count);
        if (!this.week.own(node)) {
            this.week.add(node);
            this.displayDay(count);
        } else {
            this.displayDay(count);
        }
    }

    private void displayDay(int count) {
        DayManage dayManage = this.week.get(count);
        this.attending = false;
        dayManage.attending();
        this.attending = true;
    }

    public void showEvaluationDays() {
        System.out.println("+------------------------+");
        System.out.println("|        Paciente        |");
        System.out.println("+------------------------+");
        this.week.outputSequentially(this.week.getSource());
        new Scanner(System.in).nextLine();
    }

    private void optionNotFound() {
        System.out.println("+-----------------------------------------+");
        System.out.println("| Por favor seleccionar una opcion valida |");
        System.out.println("+-----------------------------------------+");
        System.out.println(" ");
        new Scanner(System.in).nextLine();
    }
}

import java.util.Scanner;

public class DayManage implements Data {
    private String name;
    private TreeManage<EatingTime> eatingTime = null;
    private boolean attending = false;

    public DayManage(String name) {
        this.name = name;
        this.eatingTime = new TreeManage<EatingTime>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attending(){
        this.attending = true;
        int option;
        do {
            this.printMenu();
            option = new Scanner(System.in).nextInt();
            this.manageInput(option);
        } while (option != 0);
    }

    public void previousMenu() {
        this.attending = false;
    }

    private void printOptions() {
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| Seleccione un tiempo de comida (1 [Desayuno] / 2 [Media Mañana] / 3 [Almuerzo] / 4 [Merienda] / 5 [Cena] / 9 [Listar tiempos de Comida] / 0 para ir al menu anterior) |");
        System.out.println("+---------------------------------------------------------------------------------------------*-------------------------------------------------------------------------+");
        System.out.print(" ");
    }

    private void manageInput(int input) {
        EatingTime eatingTime = null;
        switch (input) {
            case 1:
                eatingTime = new EatingTime("Desayuno");
                break;
            case 2:
                eatingTime = new EatingTime("Media Mañana");
                break;
            case 3:
                eatingTime = new EatingTime("Almuerzo");
                break;
            case 4:
                eatingTime = new EatingTime("Merienda");
                break;
            case 5:
                eatingTime = new EatingTime("Cena");
                break;
            case 9:
                this.listEatingTime();
                break;
            case 0:
                this.previousMenu();
                break;
            default:
                this.optionNotFound();
                break;
        }
        if (eatingTime != null) {
            this.createEatingTime(eatingTime, input);
        }
    }

    private void createEatingTime (EatingTime eatingTime, int count) {
        Node<EatingTime> node = new Node<EatingTime>(eatingTime, count);
        if (!this.eatingTime.own(node)) {
            this.eatingTime.add(node);
            this.currentEatingTime(count);
        } else {
            this.currentEatingTime(count);
        }
    }

    public void currentEatingTime (int count) {
        EatingTime eatingTime = this.eatingTime.get(count);
        this.attending = false;
        eatingTime.attending();
        this.attending = true;
    }

    public void listEatingTime() {
        this.eatingTime.outputSequentially(this.eatingTime.getSource());
        new Scanner(System.in).nextLine();
    }

    private void optionNotFound() {
        System.out.println("+-----------------------------------------+");
        System.out.println("| Por favor seleccionar una opcion valida |");
        System.out.println("+-----------------------------------------+");
        System.out.println(" ");
        new Scanner(System.in).nextLine();
    }

    private void printMenu() {
        if (this.attending) {
            System.out.println(this.name);
            this.printOptions();
        }
    }

    @Override
    public void printData() {
        System.out.println("        " + this.name);
        this.eatingTime.outputSequentially(this.eatingTime.getSource());
    }
}

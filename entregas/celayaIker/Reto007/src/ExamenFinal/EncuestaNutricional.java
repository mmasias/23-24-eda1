package ExamenFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EncuestaNutricional {
    List<String> nodos = new ArrayList<>();
    Comida comida = new Comida();

    public void añadirNodo(String dato) {
        nodos.add(dato);
    }

    public void creaEncuestaNutricional() {
        System.out.println("EncuestaNutricional sobre alimentación");
        System.out.println("Indique su nombre o el del paciente");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Se procede a realizar la EncuestaNutricional para " + nombre);
        añadirNodo("EncuestaNutricional");
        rellenadias();
        sc.close();
    }

    public void rellenadias() {
        System.out.println("Indique qué día va ha añadir (1-5)");
        Scanner sc = new Scanner(System.in);
        int dia = sc.nextInt();
        comida.dia = dia;
        switch (dia) {
            case 1:
                System.out.println("Seleccione ingesta: 1 (Comida) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú Anterior)");
                int ingesta = sc.nextInt();
                switch (ingesta) {
                    case 1:
                        comida.creaComida();
                        break;
                    case 2:
                        comida.creamedia();
                        break;
                    case 3:
                        comida.creaalmu();
                        break;
                    case 4:
                        comida.creamerienda();
                        break;
                    case 5:
                        comida.creacena();
                        break;
                    case -1:
                        System.out.println("Menú anterior");
                        creaEncuestaNutricional();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        rellenadias();
                        break;
                }
                break;
            case 2:
                System.out.println("Seleccione ingesta: 1 (Comida) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú Anterior)");
                int ingesta2 = sc.nextInt();
                switch (ingesta2) {
                    case 1:
                        comida.creaComida();
                        break;
                    case 2:
                        comida.creamedia();
                        break;
                    case 3:
                        comida.creaalmu();
                        break;
                    case 4:
                        comida.creamerienda();
                        break;
                    case 5:
                        comida.creacena();
                        break;
                    case -1:
                        System.out.println("Menú anterior");
                        creaEncuestaNutricional();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        rellenadias();
                        break;
                }
                break;
            case 3:
            System.out.println("Seleccione ingesta: 1 (Comida) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú Anterior)");
            int ingesta3 = sc.nextInt();
            switch (ingesta3) {
                case 1:
                    comida.creaComida();
                    break;
                case 2:
                    comida.creamedia();
                    break;
                case 3:
                    comida.creaalmu();
                    break;
                case 4:
                    comida.creamerienda();
                    break;
                case 5:
                    comida.creacena();
                    break;
                case -1:
                    System.out.println("Menú anterior");
                    creaEncuestaNutricional();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    rellenadias();
                    break;
            }
                break;
            case 4:
            System.out.println("Seleccione ingesta: 1 (Comida) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú Anterior)");
            int ingesta4 = sc.nextInt();
            switch (ingesta4) {
                case 1:
                    comida.creaComida();
                    break;
                case 2:
                    comida.creamedia();
                    break;
                case 3:
                    comida.creaalmu();
                    break;
                case 4:
                    comida.creamerienda();
                    break;
                case 5:
                    comida.creacena();
                    break;
                case -1:
                    System.out.println("Menú anterior");
                    creaEncuestaNutricional();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    rellenadias();
                    break;
            }
                break;
            case 5:
            System.out.println("Seleccione ingesta: 1 (Comida) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menú Anterior)");
            int ingesta5 = sc.nextInt();
            switch (ingesta5) {
                case 1:
                    comida.creaComida();
                    break;
                case 2:
                    comida.creamedia();
                    break;
                case 3:
                    comida.creaalmu();
                    break;
                case 4:
                    comida.creamerienda();
                    break;
                case 5:
                    comida.creacena();
                    break;
                case -1:
                    System.out.println("Menú anterior");
                    creaEncuestaNutricional();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    rellenadias();
                    break;
            }
                break;
            default:
                System.out.println("Día no válido");
                rellenadias();
                break;
        }
    }
    
}

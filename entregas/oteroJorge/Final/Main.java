import java.util.Scanner;

import core.*;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Bienvenido al sistema de encuesta");
        System.out.println("Ingrese el nombre del paciente: ");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();

        Paciente paciente = new Paciente(nombre ,"02/02/2024", 1.80, 80);
        Encuesta encuesta = new Encuesta("02/02/2024");
        boolean exit = false;
        System.out.println();

        options(paciente, encuesta, exit);

        System.out.println("Gracias por usar el sistema de encuesta");
    }








    static int getInt() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }

    static String getAlimento() {
        Scanner scanner = new Scanner(System.in);
        String alimento = scanner.nextLine();
        return alimento;
    }
    static void printMenu() {
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Ingresar alimento");
        System.out.println("2. Mostrar arbol");
        System.out.println("3. Recibir resultados de la encuesta");
        System.out.println("4. Rellenar tabla con datos imaginarios");
        System.out.println("5. Tipo de alimento mas consumido");
        System.out.println("6. Solo alimentos Altos en azúcar");
        System.out.println("7. Salir");
    }
    static void printDia(){
        System.out.println("Seleccione dia: 1 / 2 / 3 / 4 / 5");
    }

    static void printIngesta(){
        System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Almuerzo) / 3 (Comida) / 4 (Merienda) / 5 (Cena) / -1 (Menu)");
    }
    static void ingreseAlimento(){
        System.out.println("Ingrese el alimento: ");
    }
    static void opcionInvalida(){
        System.out.println("Opcion invalida");
    }

    static void options(Paciente paciente, Encuesta encuesta, boolean exit){
        do {
            printMenu();
            int eleccion;
            switch (getInt()) {
                case 1:
                    printDia();
                    switch (getInt()) {
                        case 1:
                            do {
                                printIngesta();
                                eleccion = getInt();
                                switch (eleccion) {
                                    case 1:
                                        ingreseAlimento();
                                        paciente.getDia1().getDesayuno().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 2:
                                        ingreseAlimento();
                                        paciente.getDia1().getAlmuerzo().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 3:
                                        ingreseAlimento();
                                        paciente.getDia1().getComida().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 4:
                                        ingreseAlimento();
                                        paciente.getDia1().getMerienda().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 5:
                                        ingreseAlimento();
                                        paciente.getDia1().getCena().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case -1:
                                        break;
                                    default:
                                        opcionInvalida();
                                        break;
                                }
                            } while (eleccion != -1);
                            break;
        
                        case 2:
                            do {
                                printIngesta();
                                eleccion = getInt();
                                switch (eleccion) {
                                    case 1:
                                        ingreseAlimento();
                                        paciente.getDia2().getDesayuno().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 2:
                                        ingreseAlimento();
                                        paciente.getDia2().getAlmuerzo().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 3:
                                        ingreseAlimento();
                                        paciente.getDia2().getComida().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 4:
                                        ingreseAlimento();
                                        paciente.getDia2().getMerienda().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 5:
                                        ingreseAlimento();
                                        paciente.getDia2().getCena().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case -1:
                                        break;
                                    default:
                                        opcionInvalida();
                                        break;
                                }
                            } while (eleccion != -1);
                            break;
        
                        case 3:
                            do {
                                printIngesta();
                                eleccion = getInt();
                                switch (eleccion) {
                                    case 1:
                                        ingreseAlimento();
                                        paciente.getDia3().getDesayuno().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 2:
                                        ingreseAlimento();
                                        paciente.getDia3().getAlmuerzo().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 3:
                                        ingreseAlimento();
                                        paciente.getDia3().getComida().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 4:
                                        ingreseAlimento();
                                        paciente.getDia3().getMerienda().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 5:
                                        ingreseAlimento();
                                        paciente.getDia3().getCena().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case -1:
                                        break;
                                    default:
                                        opcionInvalida();
                                        break;
                                }
                            } while (eleccion != -1);
                            break;
        
                        case 4:
                            do {
                                printIngesta();
                                eleccion = getInt();
                                switch (eleccion) {
                                    case 1:
                                        ingreseAlimento();
                                        paciente.getDia4().getDesayuno().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 2:
                                        ingreseAlimento();
                                        paciente.getDia4().getAlmuerzo().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 3:
                                        ingreseAlimento();
                                        paciente.getDia4().getComida().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 4:
                                        ingreseAlimento();
                                        paciente.getDia4().getMerienda().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 5:
                                        ingreseAlimento();
                                        paciente.getDia4().getCena().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case -1:
                                        break;
                                    default:
                                        opcionInvalida();
                                        break;
                                }
                            } while (eleccion != -1);
                            break;
        
                        case 5:
                            do {
                                printIngesta();
                                eleccion = getInt();
                                switch (eleccion) {
                                    case 1:
                                        ingreseAlimento();
                                        paciente.getDia5().getDesayuno().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 2:
                                        ingreseAlimento();
                                        paciente.getDia5().getAlmuerzo().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 3:
                                        ingreseAlimento();
                                        paciente.getDia5().getComida().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 4:
                                        ingreseAlimento();
                                        paciente.getDia5().getMerienda().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case 5:
                                        ingreseAlimento();
                                        paciente.getDia5().getCena().addAlimento(new Alimento(getAlimento()));
                                        break;
                                    case -1:
                                        break;
                                    default:
                                        opcionInvalida();
                                        break;
                                }
                            } while (eleccion != -1);
                            break;
        
                        default:
                            break;
                    }
                    break;
        
                case 2:
                    encuesta.mostrarArbol(paciente);
                    System.out.println();
                    break;

                case 3:
                    encuesta.recibirResultados(paciente);
                    System.out.println();
                    break;

                case 4:
                    encuesta.rellenarEncuesta(paciente);
                    System.out.println();
                    break;

                case 5:
                    encuesta.tipoAlimentoMasConsumido(paciente);
                    System.out.println();
                    break;

                case 6:
                    encuesta.soloAltoEnAzucar(paciente);
                    System.out.println();
                    break;

                case 7:
                    exit = true;
                    break;

                default:
                    opcionInvalida();
                    System.out.println();
                    break;
            }
        } while (!exit);
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Encuesta {

    Arbol arbol = new Arbol("Encuesta");
    nodo nodo = new nodo("Encuesta", null);

    List<nodo> lista = new ArrayList<nodo>();
    Desayuno desayuno = new Desayuno();

    nodo raiz=new nodo("Encuesta",null);
    nodo dia1=new nodo("dia1",raiz);
    nodo dia2=new nodo("dia2",raiz);
    nodo dia3=new nodo("dia3",raiz);
    nodo dia4=new nodo("dia4",raiz);
    nodo dia5=new nodo("dia5",raiz);
    nodo desa=new nodo("desayuno",dia1);
    nodo media=new nodo("almuerzo",dia1);
    nodo almu=new nodo("almuerzo",dia1);
    nodo merienda=new nodo("merienda",dia1);
    nodo cena=new nodo("cena",dia1);

    public Encuesta() {
        lista.add(nodo);
    }

    public void añadirNodo(String dato, nodo padre){
        nodo hijo = new nodo(dato, padre);
        lista.add(hijo);
    }
    public void añadirNodo(nodo nodo){
        lista.add(nodo);
    }

    public void creaEncuesta() {
        System.out.println("Encuesta sobre alimentacion");
        System.out.println("Indique su nombre o el del paciente");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Se procede a realizar la encuesta para " + nombre);
        arbol.creaRaiz("Encuesta");
        añadirNodo("Encuesta", null);
        rellenadias();
        sc.close();
    }
    public void rellenadias(){
        System.out.println("Indique que dia va ha añadir (1-5)");
        Scanner sc = new Scanner(System.in);
        int dia = sc.nextInt();
        arbol.setDias(dia);
        switch (dia) {
            case 1:
                System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)/-1 (Menu Anterior)");
                int ingesta = sc.nextInt();
                switch (ingesta) {
                    case 1:
                        desayuno.creaDesayuno();
                        arbol.añaderama(desayuno.getLista(), dia1);
                        break;
                    case 2:
                        desayuno.creamedia();
                        arbol.añaderama(desayuno.getLista(), dia1);
                        break;
                    case 3:
                        desayuno.creaalmu();
                        arbol.añaderama(desayuno.getLista(), dia1);
                        break;
                    case 4:
                        desayuno.creamerienda();
                        arbol.añaderama(desayuno.getLista(), dia1);
                        break;
                    case 5:
                        desayuno.creacena();
                        arbol.añaderama(desayuno.getLista(), dia1);
                        break;
                    case -1:
                        System.out.println("Menu anterior");
                        creaEncuesta();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        rellenadias();
                        break;



                }
            case 2:
                System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)/-1 (Menu Anterior)");
                int ingesta2 = sc.nextInt();
                switch (ingesta2) {
                    case 1:
                        desayuno.creaDesayuno();
                        arbol.añaderama(desayuno.getLista(), dia2);
                        break;
                    case 2:
                        desayuno.creamedia();
                        arbol.añaderama(desayuno.getLista(), dia2);
                        break;
                    case 3:
                        desayuno.creaalmu();
                        arbol.añaderama(desayuno.getLista(), dia2);
                        break;
                    case 4:
                        desayuno.creamerienda();
                        arbol.añaderama(desayuno.getLista(), dia2);
                        break;
                    case 5:
                        desayuno.creacena();
                        arbol.añaderama(desayuno.getLista(), dia2);
                        break;
                    case -1:
                        System.out.println("Menu anterior");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;



                }
            case 3:
                System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)/-1 (Menu Anterior)");
                int ingesta3 = sc.nextInt();
                switch (ingesta3) {
                    case 1:
                        desayuno.creaDesayuno();
                        arbol.añaderama(desayuno.getLista(), dia3);
                        break;
                    case 2:
                        desayuno.creamedia();
                        arbol.añaderama(desayuno.getLista(), dia3);
                        break;
                    case 3:
                        desayuno.creaalmu();
                        arbol.añaderama(desayuno.getLista(), dia3);
                        break;
                    case 4:
                        desayuno.creamerienda();
                        arbol.añaderama(desayuno.getLista(), dia3);
                        break;
                    case 5:
                        desayuno.creacena();
                        arbol.añaderama(desayuno.getLista(), dia3);
                        break;
                    case -1:
                        System.out.println("Menu anterior");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;



                }
            case 4:
                System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)/-1 (Menu Anterior)");
                int ingesta4 = sc.nextInt();
                switch (ingesta4) {
                    case 1:
                        desayuno.creaDesayuno();
                        arbol.añaderama(desayuno.getLista(), dia4);
                        break;
                    case 2:
                        desayuno.creamedia();
                        arbol.añaderama(desayuno.getLista(), dia4);
                        break;
                    case 3:
                        desayuno.creaalmu();
                        arbol.añaderama(desayuno.getLista(), dia4);
                        break;
                    case 4:
                        desayuno.creamerienda();
                        arbol.añaderama(desayuno.getLista(), dia4);
                        break;
                    case 5:
                        desayuno.creacena();
                        arbol.añaderama(desayuno.getLista(), dia4);
                        break;
                    case -1:
                        System.out.println("Menu anterior");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;



                }
            case 5:
                System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena)/-1 (Menu Anterior)");
                int ingesta5 = sc.nextInt();
                switch (ingesta5) {
                    case 1:
                        desayuno.creaDesayuno();
                        arbol.añaderama(desayuno.getLista(), dia5);
                        break;
                    case 2:
                        desayuno.creamedia();
                        arbol.añaderama(desayuno.getLista(), dia5);
                        break;
                    case 3:
                        desayuno.creaalmu();
                        arbol.añaderama(desayuno.getLista(), dia5);
                        break;
                    case 4:
                        desayuno.creamerienda();
                        arbol.añaderama(desayuno.getLista(), dia5);
                        break;
                    case 5:
                        desayuno.creacena();
                        arbol.añaderama(desayuno.getLista(), dia5);
                        break;
                    case -1:
                        System.out.println("Menu anterior");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;



                }
            default:
                System.out.println("Opcion no valida");
                break;

        }
    }


}

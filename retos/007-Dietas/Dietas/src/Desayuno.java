import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Desayuno {
    String alimentos;
    List<String> lista = new ArrayList<String>();
    Arbol arbol = new Arbol();
    Encuesta encuesta = new Encuesta();

    public Desayuno(String alimentos) {
        this.alimentos = alimentos;
        this.lista = new ArrayList<String>();
    }
    public Desayuno() {
        this.alimentos = alimentos;
    }

    public void añadirAlimento(String alimento){
        lista.add(alimento);
    }
    public void mostrarAlimentos(){
        System.out.println("Alimentos del desayuno: ");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
    public String getLista() {
        return lista.toString();
    }

    public void creaDesayuno(){
        lista = new ArrayList<String>();
        System.out.println("Ingrese un alimento del Desayuno del dia "+arbol.getDia()+" (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (alimentos != "-1"){
            alimentos = sc.nextLine();
            if (alimentos == "-2"){
                mostrarAlimentos();
                creaDesayuno();
            }
            else {
                añadirAlimento(alimentos);
                creaDesayuno();
            }
        }

    }
    public void creamedia(){
        lista = new ArrayList<String>();
        System.out.println("Ingrese un alimento de la media mañana del día "+arbol.getDia()+" (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (alimentos != "-1"){
            alimentos = sc.nextLine();
            if (alimentos == "-2"){
                mostrarAlimentos();
                creamedia();
            }
            else {
                añadirAlimento(alimentos);
                creamedia();
            }
        }
        encuesta.rellenadias();


    }
    public void creaalmu(){
        lista = new ArrayList<String>();
        System.out.println("Ingrese un alimento del almuerzo del día "+arbol.getDia()+" (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (alimentos != "-1"){
            alimentos = sc.nextLine();
            if (alimentos == "-2"){
                mostrarAlimentos();
                creaalmu();
            }
            else {
                añadirAlimento(alimentos);
                creaalmu();
            }
        }
        encuesta.rellenadias();


    }

    public void creamerienda(){
        lista = new ArrayList<String>();
        System.out.println("Ingrese un alimento de la merienda del día "+arbol.getDia()+" (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (alimentos != "-1"){
            alimentos = sc.nextLine();
            if (alimentos == "-2"){
                mostrarAlimentos();
                creamerienda();
            }
            else {
                añadirAlimento(alimentos);
                creamerienda();
            }
        }
        encuesta.rellenadias();


    }

    public void creacena(){
        lista = new ArrayList<String>();
        System.out.println("Ingrese un alimento de la cena del día "+arbol.getDia()+" (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (alimentos != "-1"){
            alimentos = sc.nextLine();
            if (alimentos == "-2"){
                mostrarAlimentos();
                creacena();
            }
            else {
                añadirAlimento(alimentos);
                creacena();
            }
        }
        encuesta.rellenadias();


    }


}

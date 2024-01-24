import java.util.List;
import java.util.Scanner;
public class Arbol {

    nodo raiz=new nodo("Encuesta",null);


    Encuesta encuesta = new Encuesta();
    Arbol arbol = new Arbol("Encuesta");

    String dato;
    Desayuno desayuno = new Desayuno();
    nodo nodo = new nodo(dato, null);

    int dias;



    public Arbol(String dato) {
        this.dato = dato;
        this.raiz = new nodo(dato, null);
    }
    public Arbol() {
        this.dato = dato;
    }

    public void añaderama(String dato, nodo padre){
        nodo hijo = new nodo(dato, padre);

    }
    public void ramanodo(List<String> lista, nodo nodo){
        nodo = new nodo(lista, null);
    }
    public void creaRaiz(String dato){
        nodo raiz = new nodo(dato, null);
    }
    public int setDias(int dia) {
        this.dias = dia;
        return dia;
    }
    public int getDia() {
        return dias;
    }




}

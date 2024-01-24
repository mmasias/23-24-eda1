import java.util.List;
public class nodo {

    String dato = "";
    nodo padre;
    List<String> lista;

    public nodo(String dato, nodo padre) {
        this.dato = dato;
        this.padre = padre;
    }
    public nodo(String dato) {
        this.dato = dato;
        this.padre = null;
    }

    public nodo(List<String> dato, nodo padre) {
        this.lista = dato;
        this.padre = padre;
    }


    public void crearaiz(String dato){
        this.dato = dato;
        this.padre = null;
    }

    public void crearhijo(String dato, nodo padre){
        nodo hijo = new nodo(dato, padre);
    }



}

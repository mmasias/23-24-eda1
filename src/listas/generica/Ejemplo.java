package listas.generica;

public class Ejemplo {
    public static void main(String[] args) {
        
        ListG<String> l = new ListG<String>();

        l.InsertIni("Juanito");
        l.InsertEnd("Pepito");
        l.InsertEnd("Anita");
        l.InsertIni("Luisito");


        Object[] larray = l.ListAll();
        System.out.println(larray[0]);

    }
}

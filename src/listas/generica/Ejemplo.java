package listas.generica;

public class Ejemplo {
    public static void main(String[] args) {
        
        ListG<Integer> l = new ListG<Integer>();
        l.InsertIni(1);
        l.InsertEnd(2);
        l.InsertEnd(5);
        l.InsertIni(3);

        Integer[] iarray = l.ListAll(Integer.class);

        System.out.println(iarray[0]);

        Integer[] iarray2 = l.ListAll();

        System.out.println(iarray2[0]);

    }
}

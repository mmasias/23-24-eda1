package listas.basica;

class Ejemplo {
    public static void main(String[] args) {

        List l = new List();

        l.InsertIni("1");
        l.InsertEnd("2");
        l.InsertEnd("5");
        l.InsertIni("3");

        String[] larray = l.ListAll();

        System.out.println(larray[0]);

    }
}

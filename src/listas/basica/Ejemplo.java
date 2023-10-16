package listas.basica;

class Ejemplo {
    public static void main(String[] args) {

        List l = new List();

        l.insertar("1");
        l.insertar("2");
        l.insertar("5");
        l.insertar("3");

        String[] larray = l.ListAll();

        System.out.println(larray[0]);

    }
}

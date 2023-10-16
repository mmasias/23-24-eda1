package listas.basica;

class Ejemplo {
    public static void main(String[] args) {

        List l = new List();

        System.out.println(l.isEmpty());

        l.insert("Juanito");
        l.insert("Pepito");
        l.insert("Anita");
        l.insert("Luisito");

        System.out.println("Tamaño: " + l.size());
        l.delete();
        System.out.println("Tamaño: " + l.size());

        l.delete();
        System.out.println("Tamaño: " + l.size());

        String[] larray = l.listAll();
        System.out.println("Primer elemento:" + larray[0]);

    }
}

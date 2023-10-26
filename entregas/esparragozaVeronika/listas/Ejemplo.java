package listas;

class Ejemplo {
    public static void main(String[] args) {


        List nephews = new List();
        viewLine(nephews);

        System.out.println("Esta vacia? " + nephews.isEmpty());
        nephews.insertEnd("Juanito");
        nephews.insertEnd("Pepito");
        nephews.insertEnd("Anita");
        System.out.println("Esta vacia? " + nephews.isEmpty());

        viewLine(nephews);

        nephews.insertEnd("Luisito");

        System.out.println("Tamaño: " + nephews.size());

        nephews.deleteBack();
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);

        nephews.insertFront("Veronika");

        viewLine(nephews);

        nephews.deleteFront();
        viewLine(nephews);

        nephews.insertAtIndex(9, "Pancho");
        viewLine(nephews);

        nephews.insertAtIndex(4, "Patricia");
        viewLine(nephews);

        nephews.insertAtIndex(-4, "Violeta");
        viewLine(nephews);

        nephews.insertAtIndex(0, "Harry");
        viewLine(nephews);

    }

    static void viewLine(List filaDeSobrinos) {
        String[] larray = filaDeSobrinos.listAll();

        System.out.println("LA FILA" + "-".repeat(18));
        for (String sobrino : larray) {
            System.out.println(sobrino);
        }
        System.out.println("-".repeat(25));
    }
}
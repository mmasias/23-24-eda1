

class Ejemplo {
    public static void main(String[] args) {

        List nephews = new List();

        viewLine(nephews);
        System.out.println("Esta vacia? " + nephews.isEmpty());

        nephews.insert("Juanito",true,false,false);
        nephews.insert("Pepito",true,false,false);
        nephews.insert("Anita",true,false,false);

        System.out.println("Esta vacia? " + nephews.isEmpty());

        viewLine(nephews);

        nephews.insert("Luisito",true,true,false);

        System.out.println("Tamaño: " + nephews.size());

        nephews.delete(true);
        System.out.println("Tamaño: " + nephews.size());

        viewLine(nephews);
    }

    static void viewLine(List filaDeSobrinos) {

        String[] larray = filaDeSobrinos.listAll();
        System.out.println("LA FILA" + "-".repeat(18));
        for (String sobrino : larray){
            System.out.println(sobrino);
        }
        System.out.println("-".repeat(25));
    }
}

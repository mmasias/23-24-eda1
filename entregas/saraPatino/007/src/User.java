package src;

import java.util.Scanner;

public class User {
    private String name;
    private int day;
    private String ingesta;
    Scanner scanner = new Scanner(System.in);

    public User() {

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setDay(){
        System.out.println("Seleccione Día");
        int seleccion = scanner.nextInt();
        if (!(seleccion <6 && seleccion > 0)){
            System.out.println("Esa no es una opción, tiene que ser un día de 1 a 5");
            setDay();
        }
        this.day = seleccion;
    }

    public int getDay(){
        return day;
    }

    public String getIngesta(){
        return ingesta;
    }

    public void setIngesta(){
        System.out.println("Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menu anterior)");
        int seleccion = scanner.nextInt();

        if(seleccion == 1) {
            ingesta = "Desayuno";
        } else if (seleccion ==2){
            ingesta = "Media mañana";
        } else if (seleccion == 3) {
            ingesta = "Almuerzo";
        } else if (seleccion == 4) {
            ingesta = "Merienda";
        } else if (seleccion == 5) {
            ingesta = "Cena";
        } else if (seleccion == -1) {
            setDay();
        }
    }
}

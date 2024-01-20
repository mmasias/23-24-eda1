
import java.util.Scanner;

import static utils.Shortcut.print;
public class Manager {
    public static void main (String[] args){
        Client client = init();
        welcome();
        mainMenu(client.getName(), client.getLastName());
    }

    static Client init(){
        String name, lastName;
        Scanner input = new Scanner(System.in);
        print("Introduce tu nombre: ");
        name = input.nextLine();
        print("Introduce tu apellido: ");
        lastName = input.nextLine();
        return new Client(name, lastName);
    }
    static void welcome(){
        print("# ".repeat(20));
        print("Bienvenido!!!!!");
        print("Puedes seleccionar las opciones con los numeros");
        print("# ".repeat(20));
    }
    static int mainMenu(String name, String surname) {
        Scanner input = new Scanner(System.in);
        print("Ficha de " + name + " " + surname);
        print("Elige una opción: ");
        print("1. Ver dieta");
        print("2. Añadir comida");
        print("3. Salir");

        int option = input.nextInt();
        input.nextLine();

        return option;
    }
}

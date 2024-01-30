import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Encuesta encuesta = new Encuesta("01/01/2020");
        Paciente paciente = new Paciente(getString(nombrePaciente()), "01/01/2020");
        boolean exit = false;
        paciente.insertarDia();
        encuesta.mostrarArbol(paciente);
        System.out.println();

        insertarAlimentos(paciente, exit);
        
        encuesta.mostrarArbol(paciente);
        System.out.println("Fin del programa");


    }

    static void insertarAlimentos(Paciente paciente,boolean exit){
        
        do{
            System.out.println("Insertando alimentos");
            paciente.getDias().get(getInt(mensajeDia())-1).getIngestas().get(getInt(mensajeIngesta())-1).addAlimento(new Alimento(getString(nombreAlimento())));
            System.out.println();
            if(getInt(mensajeSalir()) == 1){
                exit = true;
            }else{
                exit = false;
            }
        }while(exit == false);
    }


    static int getInt(String mensaje){
        System.out.println(mensaje);
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }

    static String getString(String mensaje){
        System.out.println(mensaje);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    static String nombrePaciente(){
        return "Ingrese el nombre del paciente";
    }

    static String nombreAlimento(){
        return "Ingrese el nombre del alimento";
    }

    static String mensajeDia(){
        return "Ingrese el dia: 1/2/3/4/5";
    }

    static String mensajeIngesta(){
        return "Ingrese la ingesta: 1. Desayuno 2. Almuerzo 3. Comida 4. Merienda 5. Cena";
    }

    static String mensajeSalir(){
        return "Desea salir? 1. Si 2. No";
    }
    
}

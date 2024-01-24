import java.time.LocalDate;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner datos = new Scanner (System.in);
        int numeroDia = 0;

        System.out.println("Nombre del paciente: ");
        String nombrePaciente = datos.nextLine();

        LocalDate fechaAlta = Fechas.obtenerFecha("Fecha de alta (DD-MM-YYYY): ");
        LocalDate fechaEncuesta = Fechas.obtenerFecha("Fecha de encuesta (DD-MM-YYYY): ");
        
        System.out.println("Bienvenido a la encuesta");
        System.out.println("Paciente: " + nombrePaciente + ".");

        EncuestaNut encuesta = new EncuestaNut(nombrePaciente);
    }
}

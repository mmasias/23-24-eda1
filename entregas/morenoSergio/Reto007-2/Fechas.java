import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fechas {
    public static LocalDate obtenerFecha(String mensaje){
        Scanner datos = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD-MM-YYYY");

        System.out.println(mensaje);
        String fechaInput = datos.nextLine();
        return LocalDate.parse(fechaInput, formatter);
    }
    
}

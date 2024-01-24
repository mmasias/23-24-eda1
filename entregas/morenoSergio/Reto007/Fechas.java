import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Fechas {

    public static LocalDate obtenerFecha(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println(mensaje);
        String fechaInput = scanner.nextLine();
        return LocalDate.parse(fechaInput, formatter);
    }
}

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ImprimirFechas {

    public static void imprimirFechas(LocalDate fechaAlta, LocalDate fechaEncuesta) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Fecha de alta del paciente: " + fechaAlta.format(formatter));
        System.out.println("Fecha de toma de la encuesta: " + fechaEncuesta.format(formatter));
    }
}

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Encuesta {
    private LocalDate fechaEncuesta;
    private LocalTime horaEncuesta;
    private List<Dia> dias;

    public Encuesta(LocalDate fechaEncuesta) {
        this.fechaEncuesta = fechaEncuesta;
        this.dias = new ArrayList<>();
    }

    public void agregarDia(Dia dia) {
        dias.add(dia);
    }

    public Dia buscarDia(int numeroDia) {
        for (Dia dia : dias) {
            if (dia.getNumeroDia() == numeroDia) {
                return dia;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encuesta realizada el ").append(fechaEncuesta)
                .append(" a las ").append(horaEncuesta).append("\n");

        // Agregar información de todos los días, incluso si no hay datos ingresados
        for (int i = 1; i <= 7; i++) {
            Dia dia = buscarDia(i);
            sb.append("    Día ").append(i).append(": ");
            if (dia != null) {
                sb.append("\n").append(dia.toString());
            } else {
                sb.append("No se ingresaron datos para este día.\n");
            }
        }

        return sb.toString();
    }

    public LocalDate getFechaEncuesta() {
        return fechaEncuesta;
    }

    public void setFechaEncuesta(LocalDate fechaEncuesta) {
        this.fechaEncuesta = fechaEncuesta;
    }

    public LocalTime getHoraEncuesta() {
        return horaEncuesta;
    }

    public void setHoraEncuesta(LocalTime horaEncuesta) {
        this.horaEncuesta = horaEncuesta;
    }

    public List<Dia> getDias() {
        return dias;
    }
}

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Encuesta {
    private Paciente paciente;
    private List<Dia> dias;
    private LocalTime horaEncuesta;
    private LocalDate fechaEncuesta;

    public Encuesta(Paciente paciente, LocalTime horaEncuesta, LocalDate fechaEncuesta) {
        this.paciente = paciente;
        this.horaEncuesta = horaEncuesta;
        this.fechaEncuesta = fechaEncuesta;
        this.dias = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encuesta realizada el ").append(fechaEncuesta)
                .append(" a las ").append(horaEncuesta).append("\n");

        for (Dia dia : dias) {
            sb.append(dia.toString());
        }
        return sb.toString();
    }
    public void agregarDia(Dia dia) {
        dias.add(dia);
    }

    public List<Dia> getDias() {
        return dias;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getFechaEncuesta() {
        return fechaEncuesta;
    }

    public LocalTime getHoraEncuesta() {
        return horaEncuesta;
    }
}

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Ingesta {
    private String tipoComida;
    private LocalTime horario;
    private List<Alimento> alimentos;

    public Ingesta(String tipoComida, LocalTime horario) {
        this.tipoComida = tipoComida;
        this.horario = horario;
        this.alimentos = new ArrayList<>();
    }

    public void agregarAlimento(Alimento alimento) {
        alimentos.add(alimento);
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public String listarAlimentos() {
        StringBuilder sb = new StringBuilder();
        for (Alimento alimento : alimentos) {
            sb.append("                ").append(alimento.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("            ").append(tipoComida);
        if (horario != null) {
            sb.append(" a las ").append(horario.format(DateTimeFormatter.ofPattern("HH:mm"))); // Formatea la hora
        }
        sb.append("\n").append(listarAlimentos()).append("\n");
        return sb.toString();
    }
}


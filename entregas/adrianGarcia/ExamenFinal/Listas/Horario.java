import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Horario {
    private List<Evento> eventos;

    public Horario() {
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);

    }

    public Evento buscarEvento(LocalTime hora) {
        for (Evento evento : eventos) {
            if (evento.getHora().equals(hora)) {
                return evento;
            }
        }
        return null;
    }

    public void recorrerEventos(Consumer<Evento> accion) {
        for (Evento evento : eventos) {
            accion.accept(evento);
        }
    }
}

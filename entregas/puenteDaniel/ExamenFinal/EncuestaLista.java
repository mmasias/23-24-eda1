import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EncuestaLista {
    private List<Encuesta> encuestas;

    public EncuestaLista() {
        encuestas = new ArrayList<>();
    }

    public void agregarEncuesta(LocalDate fecha) {
        Encuesta encuesta = new Encuesta(fecha);
        encuestas.add(encuesta);
    }

    public void eliminarEncuesta(LocalDate fecha) {
        Encuesta encuestaAEliminar = null;
        for (Encuesta encuesta : encuestas) {
            if (encuesta.getFecha().equals(fecha)) {
                encuestaAEliminar = encuesta;
                break;
            }
        }
        if (encuestaAEliminar != null) {
            encuestas.remove(encuestaAEliminar);
        }
    }

    public Encuesta buscarEncuesta(LocalDate fecha) {
        for (Encuesta encuesta : encuestas) {
            if (encuesta.getFecha().equals(fecha)) {
                return encuesta;
            }
        }
        return null;
    }

    public List<Encuesta> obtenerTodasLasEncuestas() {
        return encuestas;
    }

    public static void main(String[] args) {
        EncuestaLista listaEncuestas = new EncuestaLista();

        LocalDate fecha1 = LocalDate.of(2022, 1, 15);
        LocalDate fecha2 = LocalDate.of(2022, 2, 20);
        LocalDate fecha3 = LocalDate.of(2022, 3, 25);

        listaEncuestas.agregarEncuesta(fecha1);
        listaEncuestas.agregarEncuesta(fecha2);
        listaEncuestas.agregarEncuesta(fecha3);

        // Buscar una encuesta por fecha
        LocalDate fechaBuscada = LocalDate.of(2022, 2, 20);
        Encuesta encuestaEncontrada = listaEncuestas.buscarEncuesta(fechaBuscada);

        if (encuestaEncontrada != null) {
            System.out.println(encuestaEncontrada.getInformacion());
        } else {
            System.out.println("Encuesta no encontrada para la fecha: " + fechaBuscada);
        }

        // Obtener todas las encuestas
        List<Encuesta> todasLasEncuestas = listaEncuestas.obtenerTodasLasEncuestas();
        for (Encuesta encuesta : todasLasEncuestas) {
            System.out.println(encuesta.getInformacion());
        }
    }
}
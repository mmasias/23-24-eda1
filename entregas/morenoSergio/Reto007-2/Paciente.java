import java.time.LocalDate;
import java.util.Comparator;

public class Paciente {
    private String nombre;
    private LocalDate fechaAlta;
    private DatosArbol<Encuesta> encuestas;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.encuestas = new DatosArbol<>(Comparator.comparing(Encuesta::getFechaEncuesta));
    }

    public void setFechaAlta(LocalDate fecha) {
        this.fechaAlta = fecha;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void agregarEncuesta(Encuesta encuesta) {
        encuestas.insertar(encuesta);
    }

    public Encuesta buscarEncuesta(LocalDate fecha) {
        return encuestas.buscar(new Encuesta(fecha));
    }

    public DatosArbol<Encuesta> getEncuestas() {
        return encuestas;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente: ").append(nombre).append("\n");
        sb.append("Fecha de alta: ").append(fechaAlta).append("\n");
        encuestas.recorrerInOrden(e -> sb.append(e.toString()).append("\n"));
        return sb.toString();
    }
}


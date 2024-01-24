import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente implements DatosArbol {
    private LocalDate fechaDeAlta;
    private String nombre;
    private List<LocalDate> fechas;
    private List<Encuesta> encuestas;

    public Paciente(String nombre, LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
        this.nombre = nombre;
        this.fechas = new ArrayList<>();
        this.encuestas = new ArrayList<>();
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<LocalDate> getFechas() {
        return this.fechas;
    }

    public void addFecha(LocalDate fecha) {
        this.fechas.add(fecha);
    }

    @Override
    public String getInformacion() {
        return "Nombre: " + nombre + "  ||  Fecha de alta: " + fechaDeAlta;
    }

    public void addEncuesta(Encuesta encuesta) {
        this.encuestas.add(encuesta);
    }

    public Encuesta[] getEncuestas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEncuestas'");
    }
}

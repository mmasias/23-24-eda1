import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente implements DatosArbol{
    private LocalDate fechaDeAlta;
    private String nombre;
    private List<Paciente> pacientes;

    public Paciente(String nombre, LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
        this.nombre = nombre;
        this.pacientes = new ArrayList<>();
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

    public List<Paciente> getPacientes() {
        return this.pacientes;
    }

    public void addPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }

    @Override
    public String getInformacion() {
        return "Nombre: "+ nombre + "  ||  Fecha de alta: " + fechaDeAlta;
    }
}
import java.time.LocalDate;

public class Paciente {
    private String nombre;
    private LocalDate fechaDeAlta;
    private Encuesta encuesta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Paciente(String nombre, LocalDate fechaDeAlta) {
        this.nombre = nombre;
        this.fechaDeAlta = fechaDeAlta;
        this.encuesta= new Encuesta();
    }

    public Paciente(){
        this.encuesta= new Encuesta();
    }

    
    public String getInfo() {
        return "Fecha y nombre del paciente: " + this.nombre + " " + this.fechaDeAlta.toString();
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }
}

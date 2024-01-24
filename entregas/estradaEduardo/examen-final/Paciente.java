import java.time.LocalDateTime;

public class Paciente {
  private String nombre;
  private LocalDateTime fechaAlta;
  private Encuesta encuesta;

  public Paciente(String nombre) {
    this.nombre = nombre;
    this.fechaAlta = LocalDateTime.now();
    this.encuesta = new Encuesta();
  }

  public String getNombre() {
    return nombre;
  }

  public LocalDateTime getFechaAlta() {
    return fechaAlta;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setFechaAlta(LocalDateTime fechaAlta) {
    this.fechaAlta = fechaAlta;
  }

  public Encuesta getEncuesta() {
    return encuesta;
  }

}

import java.time.LocalDateTime;

public class Encuesta {
  private LocalDateTime fechaToma;
  private Lista<Dia> dias;
  final private int diasMaximos = 5;

  public Encuesta() {
    this.fechaToma = LocalDateTime.now();
    this.dias = new Lista<>();
    for (int i = 1; i <= diasMaximos; i++) {
      this.dias.add(new Dia(i));
    }

  }

  public LocalDateTime getFechaToma() {
    return fechaToma;
  }

  public void setFechaToma(LocalDateTime fechaToma) {
    this.fechaToma = fechaToma;
  }

  public Dia obtenerDia(int indice) {
    return dias.get(indice);
  }

  public void listarDias() {
    for (int i = 0; i < dias.size(); i++) {
      System.out.println("Día " + (i + 1));
    }
  }
}

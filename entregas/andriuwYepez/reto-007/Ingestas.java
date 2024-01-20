import java.util.ArrayList;
import java.util.List;

public class Ingestas {
    private int numeroIngesta;
    private List<Alimentos> alimentos;
    private String fecha;  // Agregamos la fecha a la clase Ingestas

    public Ingestas(int numeroIngesta, String fecha) {
        this.numeroIngesta = numeroIngesta;
        this.fecha = fecha;
        this.alimentos = new ArrayList<>();
    }

    public void agregarAlimento(Alimentos alimento) {
        alimentos.add(alimento);
    }

    public int getNumeroIngesta() {
        return numeroIngesta;
    }

    public List<Alimentos> getAlimentos() {
        return alimentos;
    }

    public String getFecha() {
        return fecha;
    }
}

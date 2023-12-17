import java.util.HashMap;
import java.util.Map;

public class Paciente {
    String nombre;
    Map<Integer, Dia> dias;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.dias = new HashMap<>();
    }

    public void agregarDia(int numeroDia, Dia dia) {
        dias.put(numeroDia, dia);
    }

    public Dia obtenerDia(int numeroDia) {
        return dias.get(numeroDia);
    }
}

import java.util.ArrayList;
import java.util.List;

public class Encuesta {
    private List<Dia> dias = new ArrayList<>();

    public List<Dia> getDias() {
        return dias;
    }

    public void agregarDia(Dia dia) {
        dias.add(dia);
    }
}

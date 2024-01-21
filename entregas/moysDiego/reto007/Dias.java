import java.util.HashMap;
import java.util.Map;

public class Dias {
    private Map<String, Ingestas> ingestas;

    public Dias() {
        this.ingestas = new HashMap<>();
        // Inicializar las ingestas con tipos válidos
        for (String tipoIngesta : getTiposIngestaValidos()) {
            ingestas.put(tipoIngesta, new Ingestas());
        }
    }

    public void agregarAlimento(Alimentos alimento, String tipoIngesta) {

        ingestas.computeIfAbsent(tipoIngesta, k -> new Ingestas()).agregarAlimento(alimento);
    }

    public void mostrarIngestas() {
        for (Map.Entry<String, Ingestas> entry : ingestas.entrySet()) {
            System.out.println("        " + "Ingesta " + entry.getKey() + ":");
            entry.getValue().mostrarAlimentos();
        }
    }

    private static String[] getTiposIngestaValidos() {
        return new String[]{"Desayuno", "Media Mañana", "Almuerzo", "Merienda", "Cena"};
    }
}

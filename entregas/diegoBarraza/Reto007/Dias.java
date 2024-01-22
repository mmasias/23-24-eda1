package Reto007;

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
        if (esTipoIngestaValido(tipoIngesta)) {
            ingestas.get(tipoIngesta).agregarAlimento(alimento);
        } else {
            System.out.println("Error: Tipo de ingesta no válido.");
        }
    }

    public void mostrarIngestasEnOrden() {
        // Mostrar las ingestas en el orden deseado
        mostrarIngesta("Desayuno");
        mostrarIngesta("Media Mañana");
        mostrarIngesta("Almuerzo");
        mostrarIngesta("Merienda");
        mostrarIngesta("Cena");
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

    private void mostrarIngesta(String tipoIngesta) {
        System.out.println("        " + "Ingesta " + tipoIngesta + ":");
        ingestas.get(tipoIngesta).mostrarAlimentos();
    }

    private boolean esTipoIngestaValido(String tipoIngesta) {
        String[] tiposValidos = getTiposIngestaValidos();
        for (String tipoValido : tiposValidos) {
            if (tipoValido.equalsIgnoreCase(tipoIngesta)) {
                return true;
            }
        }
        return false;
    }
}

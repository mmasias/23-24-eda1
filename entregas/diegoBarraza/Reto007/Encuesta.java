package Reto007;

import java.util.HashMap;
import java.util.Map;

public class Encuesta {
    private Map<Integer, Dias> dias;

    public Encuesta() {
        this.dias = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            dias.put(i, new Dias());
        }
    }

    public void agregarAlimento(Alimentos alimento, int dia, String tipoIngesta) {
        Dias diaSeleccionado = dias.get(dia);

        if (diaSeleccionado == null) {
            System.out.println("Error: Día no válido.");
            return;
        }

        diaSeleccionado.agregarAlimento(alimento, tipoIngesta);
    }

    public void mostrarDias() {
        for (Map.Entry<Integer, Dias> entry : dias.entrySet()) {
            System.out.println("    Día " + entry.getKey() + ":");
            entry.getValue().mostrarIngestasEnOrden();
        }
    }
}

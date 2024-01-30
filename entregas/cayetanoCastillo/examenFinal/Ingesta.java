package ProyectoFinal;

import java.util.ArrayList;
import java.util.List;

public class Ingesta {
    private int tipoIngesta;
    private List<Alimento> alimentos;

    public Ingesta(int tipoIngesta) {
        this.tipoIngesta = tipoIngesta;
        this.alimentos = new ArrayList<>();
    }

    public void agregarAlimento(Alimento alimento) {
        for (Alimento existente : alimentos) {
            if (existente.getNombre().equalsIgnoreCase(alimento.getNombre())) {
                return;
            }
        }
        alimentos.add(alimento);
    }

    public Alimento buscarAlimento(String nombreAlimento) {
        for (Alimento alimento : alimentos) {
            if (alimento.getNombre().equalsIgnoreCase(nombreAlimento)) {
                return alimento;
            }
        }
        return null;
    }

    public int getTipoIngesta() {
        return tipoIngesta;
    }

    public void setTipoIngesta(int tipoIngesta) {
        this.tipoIngesta = tipoIngesta;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

}
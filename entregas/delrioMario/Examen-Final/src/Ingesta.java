import java.util.ArrayList;
import java.util.List;

public class Ingesta implements Comparable<Ingesta>, DatosArbol {
    private static final String Informacion = null;
    private Horario horario;
    private List<Alimento> alimentos;

    public Ingesta(Horario horario) {
        this.horario = horario;
        this.alimentos = new ArrayList<>();
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void insertarAlimento(Alimento alimento) {
        this.alimentos.add(alimento);
    }

    @Override
    public int compareTo(Ingesta o) {
        if (this.horario.getCodigo() < o.horario.getCodigo()) {
            return 1;
        } else if (this.horario.getCodigo() > o.horario.getCodigo()) {
            return -1;
        } else {
            return 0;
        }
    }

    public String getInfo() {
        String texto = this.getHorario().getDescription() + ": ";
        for (int i = 0; i < alimentos.size(); i++) {
            Alimento al = alimentos.get(i);
            texto += "\n" + al.getNombre() + " (" + al.getGramos() + " gr.) | ";
            
        }
        return texto.substring(0, texto.length() - 2);
    }

    public void vaciar() {
        this.alimentos.clear();
    }
}



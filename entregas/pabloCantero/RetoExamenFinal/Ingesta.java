package RetoExamenFinal;
import java.util.ArrayList;
import java.util.List;

public class Ingesta implements Comparable<Ingesta>, DatosLista{
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

    public void insertarAlimento(Alimento alimento){
        this.alimentos.add(0, alimento);
    }

    @Override
    public int compareTo(Ingesta o){
        if(this.horario.getCodigo()<o.horario.getCodigo()){
            return 1;
        }else if (this.horario.getCodigo()>o.horario.getCodigo()){
            return -1;
        }else{
            return 0;
        }
    }

    public String getInformacion(){
        StringBuilder texto = new StringBuilder("\t" + horario.getDescription());
    
        for (Alimento alimento : alimentos) {
            texto.append(alimento.toString());
        }
        
        return texto.toString();
    }
    public void vaciar (){
        this.alimentos.clear();
    }
}



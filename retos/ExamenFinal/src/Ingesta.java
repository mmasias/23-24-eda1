import java.util.ArrayList;
import java.util.List;

public class Ingesta implements Comparable<Ingesta>, DatosArbol {
    private List<Alimento> alimentos;

    public Ingesta(Horario horario) {
        this.alimentos = new ArrayList<>();
    }

    public void addAlimento(Alimento alimento) {
        this.alimentos.add(alimento);
    }

    @Override
    public int compareTo(Ingesta o) {
        // Implementa la comparación si es necesario
        return 0;
    }

    @Override
    public String getInformacion() {
        String texto = "Ingesta: ";
        for (int i = 0; i < alimentos.size(); i++) {
            Alimento alimento = alimentos.get(i);
            texto += alimento.getNombre() + "(" + alimento.getGramos() + "g), ";
            if (Informacion.getDatos(alimento.getNombre()) != null) {
                int caloria = Informacion.getDatos(alimento.getNombre()).getCalorias();
                int grasa = Informacion.getDatos(alimento.getNombre()).getGrasas();
                int proteina = Informacion.getDatos(alimento.getNombre()).getProteinas();
                int azucar = Informacion.getDatos(alimento.getNombre()).getAzucar();

                texto += "Calorias: " + (caloria * alimento.getGramos()) / 100 + " Grasas: "
                        + (grasa * alimento.getGramos()) / 100 + " Proteinas: "
                        + (proteina * alimento.getGramos()) / 100 + " Azucar: " + (azucar * alimento.getGramos());
            } else {
                texto += "Faltan valores nutricionales. ";
            }
        }
        return texto.substring(0, texto.length() - 2);
    }

    public List<Paciente> getAlimentos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAlimentos'");
    }
}

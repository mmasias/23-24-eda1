package clases;

import Coleciones.GenericList;
import Coleciones.IDataStructure;

public class Ingesta implements Comparable<Ingesta>, IDataStructure {
    private Horario horario;
    private GenericList<Alimento> alimentos;

    public Ingesta(Horario horario) {
        this.horario = horario;
        this.alimentos = new GenericList<Alimento>(null);
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public GenericList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void insertarAlimento(Alimento alimento) {
        this.alimentos.insertOrdered(alimento);
    }

    @Override
    public int compareTo(Ingesta o) {
        if (this.getHorario().getNumero() < o.horario.getNumero())
            return -1;
        else if (this.getHorario().getNumero() > o.horario.getNumero())
            return 1;

        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String getInformacion() {
        String texto = this.getHorario().getNombre() + ": ";
        for (Alimento alimento : this.getAlimentos()) {
            texto += alimento.getNombre() + "(" + alimento.getMg() + "mg), ";
            if(InformacionNutricional.getDatos(alimento.getNombre())!=null){
                int caloria= InformacionNutricional.getDatos(alimento.getNombre()).getCalorias();
                double grasa= InformacionNutricional.getDatos(alimento.getNombre()).getGrasas();
                double proteina= InformacionNutricional.getDatos(alimento.getNombre()).getProteinas();
                double azucar=InformacionNutricional.getDatos(alimento.getNombre()).getAzucar();

                texto+="Calorias: " + (caloria*alimento.getMg())/100 + " Grasas: " +(grasa*alimento.getMg())/100 + " Proteinas: " +(proteina*alimento.getMg())/100 +" Azucar: "+(azucar*alimento.getMg())/100 ;
            }else{
                texto+="faltan valores nutricionales";
            }



        }
        return texto.substring(0, texto.length() - 2);
    }
    public double totalCalorias() {
        int total = 0;
        GenericList<Alimento> alimentos = this.getAlimentos();
        try {
            for (Alimento alimento : alimentos) {
                int caloria = InformacionNutricional.getDatos(alimento.getNombre()).getCalorias();
                total += caloria >= 0 ? caloria * alimento.getMg() / 100 : 0;
            }
        } catch (NullPointerException e) {
            return 0;
        }
        return total;
    }

    public int totalTipo(String nombreTipo) {
        int cantidad = 0;
        for (Alimento alimento : this.getAlimentos()) {

            if (alimento != null) {

                String nombreAlimento = alimento.getNombre();

                if (nombreAlimento != null) {

                    ValoresNutricionales infoNutricional = InformacionNutricional.getDatos(nombreAlimento);

                    if (infoNutricional != null) {

                        String tipo = infoNutricional.getTipo();


                        if (tipo != null && nombreTipo.equalsIgnoreCase(tipo)) {
                            cantidad++;
                        }
                    }
                }
            }
        }
        return cantidad;
    }

    public double totalAzucar() {
        double total = 0;
        GenericList<Alimento> alimentos = this.getAlimentos();

        try {
            for (Alimento alimento : alimentos) {
                ValoresNutricionales infoNutricional = InformacionNutricional.getDatos(alimento.getNombre());
                if (infoNutricional != null) {
                    double azucar = infoNutricional.getAzucar();
                    total += azucar >= 0 ? azucar * alimento.getMg() / 100 : 0;
                } else {

                    System.err.println("azucar para " + alimento.getNombre() + " es null");
                }
            }
        } catch (NullPointerException e) {

            return 0;
        }

        return total;
    }

    public double totalProteinas() {
        double total = 0;
        GenericList<Alimento> alimentos = this.getAlimentos();

        try {
            for (Alimento alimento : alimentos) {
                ValoresNutricionales infoNutricional = InformacionNutricional.getDatos(alimento.getNombre());
                if (infoNutricional != null) {
                    double proteina = infoNutricional.getProteinas();
                    total += proteina >= 0 ? proteina * alimento.getMg() / 100 : 0;
                } else {

                    System.err.println("proteinas para " + alimento.getNombre() + " es null");
                }
            }
        } catch (NullPointerException e) {

            return 0;
        }

        return total;
    }

    public double totalGrasas() {
        double total = 0;
        GenericList<Alimento> alimentos = this.getAlimentos();

        try {
            for (Alimento alimento : alimentos) {
                ValoresNutricionales infoNutricional = InformacionNutricional.getDatos(alimento.getNombre());
                if (infoNutricional != null) {
                    double grasa = infoNutricional.getGrasas();
                    total += grasa >= 0 ? grasa * alimento.getMg() / 100 : 0;
                } else {

                    System.err.println("grasas para " + alimento.getNombre() + " es null");
                }
            }
        } catch (NullPointerException e) {

            return 0;
        }

        return total;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object[] listAll() {
        return new Object[0];
    }

}

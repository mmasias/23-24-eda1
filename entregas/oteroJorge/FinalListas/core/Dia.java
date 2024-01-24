import generica.GenericList;

public class Dia {

    private String dia;
    private GenericList<Ingesta> ingestas;

    public Dia(int dia) {
        this.dia = "Dia " + dia;
        this.ingestas = new GenericList<Ingesta>();
    }

    public String getDia() {
        return dia;
    }

    public void addIngesta(Ingesta ingesta) {
        this.ingestas.insertEnd(ingesta);
    }
    
}

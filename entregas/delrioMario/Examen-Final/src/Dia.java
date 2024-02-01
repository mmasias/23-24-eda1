public class Dia implements Comparable<Dia>{
    private int dia;
    private GenericList<Ingesta> ingestas;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Dia(int dia) {
        this.dia = dia;
        this.ingestas = new GenericList<>();
    }

  
    public String getInfo() {
        return "El dia de la encuesta es: " + this.dia;
    }

    @Override
    public int compareTo(Dia o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    public GenericList<Ingesta> getIngestas() {
        return ingestas;
    }

    public void setIngestas(GenericList<Ingesta> ingestas) {
        this.ingestas = ingestas;
    }

    public void insertarIngesta(Ingesta ing){
        this.ingestas.insertEnd(ing);
    }

}

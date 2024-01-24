import utils.generica.GenericList;
import utils.generica.GenericNode;

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

    public GenericList<Ingesta> getIngestas() {
        return ingestas;
    }

    public void imprimirIngestas() {
        GenericNode<Ingesta> iterator = this.ingestas.getFirst();

        while (iterator != null) {
            System.out.println("     " + iterator.getValue().getNombre());
            iterator.getValue().imprimirAlimentos();

            iterator = iterator.getNext();
        }
    }

    public void insertarIngesta(){
        this.ingestas.insertEnd(new Ingesta("Desayuno"));
        this.ingestas.insertEnd(new Ingesta("Almuerzo"));
        this.ingestas.insertEnd(new Ingesta("Comida"));
        this.ingestas.insertEnd(new Ingesta("Merienda"));
        this.ingestas.insertEnd(new Ingesta("Cena"));
    }
    
}

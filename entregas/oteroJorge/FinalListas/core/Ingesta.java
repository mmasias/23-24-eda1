import utils.generica.*;

public class Ingesta {

    private String ingesta;
    private GenericList<Alimento> alimentos;

    public Ingesta(String ingesta) {
        this.ingesta = ingesta;
        this.alimentos = new GenericList<Alimento>();
    }

    public String getNombre() {
        return ingesta;
    }

    public void imprimirAlimentos() {
        GenericNode<Alimento> iterator = this.alimentos.getFirst();
    
        while (iterator != null) {
            System.out.println("      " + iterator.getValue().getNombre());
            iterator = iterator.getNext();
        }
    }

    public void addAlimento(Alimento alimento) {
        this.alimentos.insertEnd(alimento);
    }
    
}

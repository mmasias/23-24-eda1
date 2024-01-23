package Reto007;

public class Dias {
    private int diaIndex;
    private Tree<IngestaTipo> ingestasTree;

    public Dias(int diaIndex) {
        this.diaIndex = diaIndex;
        this.ingestasTree = new Tree<>();
        for (String tipoIngesta : getTiposIngestaValidos()) {
            ingestasTree.insert(new Node<>(new IngestaTipo(tipoIngesta, new Ingestas()), tipoIngesta.hashCode()));
        }
    }

    public void agregarAlimento(Alimentos alimento, String tipoIngesta) {
        Node<IngestaTipo> ingestaTipoNode = ingestasTree.find(tipoIngesta.hashCode());
        if (ingestaTipoNode != null) {
            ingestaTipoNode.getData().getIngestas().agregarAlimento(alimento);
        } else {
            System.out.println("Error: Tipo de ingesta no válido.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Día " + diaIndex + ":\n");
        ingestasTree.printInOrder(sb);
        return sb.toString();
    }

    private static String[] getTiposIngestaValidos() {
        return new String[]{"Desayuno", "Media Mañana", "Almuerzo", "Merienda", "Cena"};
    }
}

class IngestaTipo {
    private String tipo;
    private Ingestas ingestas;

    public IngestaTipo(String tipo, Ingestas ingestas) {
        this.tipo = tipo;
        this.ingestas = ingestas;
    }

    public String getTipo() {
        return tipo;
    }

    public Ingestas getIngestas() {
        return ingestas;
    }

    public String toString() {
        return "Ingesta " + tipo + ": " + ingestas.toString();
    }
}

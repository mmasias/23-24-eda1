package ProyectoFinal;

public class DiaAlimentacion {
    private int numeroDia;
    private List<Ingesta> ingestas;

    public DiaAlimentacion(int numeroDia) {
        this.numeroDia = numeroDia;
        this.ingestas = new List<>();
    }

    public void agregarIngesta(Ingesta ingesta) {
        this.ingestas.add(ingesta);
    }

    public Ingesta buscarIngesta(int tipoIngesta) {
        Node<Ingesta> current = this.ingestas.getHead();
        while (current != null) {
            if (current.getData().getTipoIngesta() == tipoIngesta) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public int getNumeroDia() {
        return numeroDia;
    }

    public void setNumeroDia(int numeroDia) {
        this.numeroDia = numeroDia;
    }

    public List<Ingesta> getIngestas() {
        return ingestas;
    }

}

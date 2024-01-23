package Reto007;

public class Ingestas {
    private List<Alimentos> alimentos;

    public Ingestas() {
        this.alimentos = new List<>();
    }

    public void agregarAlimento(Alimentos alimento) {
        alimentos.add(alimento);
    }

    public void mostrarAlimentos() {
        Node<Alimentos> current = alimentos.getHead();
        while (current != null) {
            System.out.println("             - " + current.getData().getNombre());
            current = current.getNext();
        }
    }
}

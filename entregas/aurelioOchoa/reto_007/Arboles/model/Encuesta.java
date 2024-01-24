package Arboles.model;

public class Encuesta {
    public Dia root;

    public Encuesta() {
        this.root = null;
    }

    public void agregarDia(Dia dia) {
        this.root = agregarDiaRec(this.root, dia);
    }

    private Dia agregarDiaRec(Dia root, Dia dia) {
        if (root == null) {
            root = dia;
            return root;
        }

        // Implementa la lógica para agregar días si es necesario
        // Puedes utilizar algún criterio para decidir la posición del nuevo día en el árbol

        return root;
    }
}

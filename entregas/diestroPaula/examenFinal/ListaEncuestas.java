public class ListaEncuestas {
    private NodoEncuesta cabeza;

    public void agregarEncuesta(Encuesta encuesta) {
        NodoEncuesta nuevoNodo = new NodoEncuesta(encuesta);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
    }

    public NodoEncuesta getCabeza() {
        return cabeza;
    }
}
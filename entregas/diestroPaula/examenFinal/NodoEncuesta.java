public class NodoEncuesta {
    private Encuesta encuesta;
    private NodoEncuesta siguiente;

    public NodoEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
        this.siguiente = null;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public NodoEncuesta getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEncuesta siguiente) {
        this.siguiente = siguiente;
    }
}
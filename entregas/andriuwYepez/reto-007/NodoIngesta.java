public class NodoIngesta {
    private Ingestas ingesta;
    private NodoIngesta izquierda;
    private NodoIngesta derecha;

    public NodoIngesta(Ingestas ingesta) {
        this.ingesta = ingesta;
        this.izquierda = null;
        this.derecha = null;
    }

    public Ingestas getIngesta() {
        return ingesta;
    }

    public NodoIngesta getIzquierda() {
        return izquierda;
    }

    public NodoIngesta getDerecha() {
        return derecha;
    }

    public void setIzquierda(NodoIngesta izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(NodoIngesta derecha) {
        this.derecha = derecha;
    }
}

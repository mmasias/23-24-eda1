public class NodoFamilia<T> {

    private T dato;
    private NodoFamilia<T> hijoIzquierdo;
    private NodoFamilia<T> hijoDerecho;

    public NodoFamilia(T dato) {
        this.dato = dato;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoFamilia<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoFamilia<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoFamilia<T> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoFamilia<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
}
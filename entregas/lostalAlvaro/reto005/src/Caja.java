public class Caja {
    private int tiempoAtencion;

    public Caja() {
        this.tiempoAtencion = 0;
    }

    public boolean estaLibre() {
        return tiempoAtencion == 0;
    }

    public void atenderCliente(Cliente cliente) {
        tiempoAtencion = cliente.getPacks();
    }

    public void disminuirTiempo() {
        if (tiempoAtencion > 0) {
            tiempoAtencion--;
        }
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }
}

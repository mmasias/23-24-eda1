import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CentroComercial {
    private List<Cliente> cola;
    private List<Caja> cajas;

    public CentroComercial() {
        this.cola = new ArrayList<>();
        this.cajas = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            cajas.add(new Caja());
        }
    }

    public void simularMinuto(int minuto) {
        int probLlegada = new Random().nextInt(10) + 1;
        if (probLlegada <= 6) {
            cola.add(new Cliente());
        }

        for (Caja caja : cajas) {
            if (caja.estaLibre() && !cola.isEmpty()) {
                Cliente cliente = cola.remove(0);
                caja.atenderCliente(cliente);
            }
            caja.disminuirTiempo();
        }

        System.out.println("MINUTO " + minuto);
        if (probLlegada <= 6) {
            System.out.println("Llega 1 persona - En Cola: " + cola.size());
        } else {
            System.out.println("No llega nadie  - En Cola: " + cola.size());
        }
        for (int i = 0; i < cajas.size(); i++) {
            System.out.println("Caja" + (i + 1) + ": [" + cajas.get(i).getTiempoAtencion() + "]");
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

    public static void main(String[] args) {
        CentroComercial centroComercial = new CentroComercial();

        for (int minuto = 1; minuto <= 720; minuto++) {
            centroComercial.simularMinuto(minuto);
        }
    }
}

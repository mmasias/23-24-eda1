package ccf;

import java.util.ArrayList;

public class Carrefour {
    private static final int cantidadCajas = 4;
    private static final int horaInicioJornada = 9;
    private static final int horaFinalJornada = 21;
    private Tiempo reloj;
    private Cola colaDeEspera;
    private ArrayList<Caja> cajas;

    private int minutosSinCola = 0;
    private int personasEnColaAlFinalizar = 0;
    private int personasAtendidas = 0;
    private int itemsVendidos = 0;

    public Carrefour() {
        reloj = new Tiempo(horaInicioJornada, 0);
        colaDeEspera = new Cola();
        cajas = new ArrayList<>();
        for (int i = 0; i < cantidadCajas; i++) {
            cajas.add(new Caja(i + 1, true));
        }
    }

    public void ejecutarSimulacion() {
        while (reloj.getHora() >= horaInicioJornada && reloj.getHora() < horaFinalJornada) {
            System.out.println("--------".repeat(10));
            System.out.print(reloj.getHora() + ":" + String.format("%02d", reloj.getMinuto()) + " - ");
            for (Caja caja : cajas) {
                System.out.print("Caja " + caja.getIdCaja() + " [" + caja.getItemsEnCaja() + "] | ");
            }
            System.out.println("Fila: " + colaDeEspera.size() + " personas");
            System.out.println("--------".repeat(10));
            colaDeEspera.nuevoCliente();
            asignarClientesACajas();
            reloj.subeTiempo();
        }

        for (Caja caja : cajas) {
            personasAtendidas += caja.getPersonasAtendidas();
            itemsVendidos += caja.getItemsVendidosCaja();
        }
        personasEnColaAlFinalizar = colaDeEspera.size();
        reporteFinal();
        }

    private void asignarClientesACajas() {
        for (Caja caja : cajas) {
            if (!caja.estaLibre()) {
                caja.avanzarItems();
            }
            if (caja.estaLibre()) {
                if (!colaDeEspera.isEmpty()) {
                    Persona cliente = colaDeEspera.eliminarCliente();
                    caja.atenderCliente(cliente);
                }
            }
        }

        if (colaDeEspera.size() > 15 && cajas.size() < 5) {
            int cajaId = cajas.size() + 1;
            cajas.add(new Caja(cajaId, true));
            Persona cliente = colaDeEspera.eliminarCliente();
            cajas.get(cajas.size() - 1).atenderCliente(cliente);
            System.out.println("Se ha abierto la Caja " + cajaId + " para atender a un cliente con " + cliente.getPackItem() + " items.");
        }

        if (colaDeEspera.size() < 15 && cajas.size() > cantidadCajas) {
            int cajaId = cajas.size();
            cajas.remove(cajas.size() - 1);
            System.out.println("Se ha cerrado la Caja " + cajaId + " debido a la baja demanda.");
        }

        if (colaDeEspera.isEmpty()) {
            minutosSinCola++;
        }
    }
    public void reporteFinal(){
        System.out.println("El centro comercial ha cerrado.");
        for (Caja caja : cajas) {
            System.out.println("Caja " + caja.getIdCaja() + " tenía " + caja.getItemsEnCaja() + " items al cerrar.");
        }
        System.out.println("Minutos sin nadie en cola: " + minutosSinCola);
        System.out.println("Personas en cola al finalizar el día: " + personasEnColaAlFinalizar);
        System.out.println("Personas atendidas durante el día: " + personasAtendidas);
        System.out.println("Items vendidos en el día: " + itemsVendidos);

    }
}

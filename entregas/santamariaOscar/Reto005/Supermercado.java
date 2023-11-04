import java.util.LinkedList;
import java.util.Scanner;

public class Supermercado {
    private LinkedList<Object> cola;
    private LinkedList<Caja> cajas;
    private int minutosSinCola = 0;
    private int clientesAt = 0;
    private int productosVendidos = 0;

    public static void main(String[] args) {
        Supermercado cccf = new Supermercado();
        cccf.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int ultimaHora = 12;
        boolean superAbierto = configurarCajas(scanner);

        if (superAbierto) {
            for (int hora = 0; hora <= ultimaHora; hora++) {
                mostrarTextoHora(hora);
                for (int minuto = 1; minuto <= 60; minuto++) {
                    actualizarCajas();
                    actualizarClientesEnCola();
                    mostrarEstado(minuto);
                }
                if (hora == ultimaHora) {
                    mostrarResumen();
                }
            }
        } else {
            System.out.println("El supermercado ha permanecido cerrado.");
        }
        scanner.close();
    }

    private boolean configurarCajas(Scanner scanner) {
        LinkedList<Caja> cajas = new LinkedList<>();
        for (int i = 1; i <= 4; i++) {
            System.out.print("Desea abrir la caja " + i + " (1 = Si, Otro = No): ");
            boolean cajaAbierta = (scanner.nextInt() == 1);
            cajas.add(new Caja(i, cajaAbierta));
        }
        boolean superAbierto = false;
        for (Caja caja : cajas) {
            if (caja.abierta) {
                superAbierto = true;
                break;
            }
        }

        if (!superAbierto) {
            System.out.print("No hay ninguna caja abierta. ¿Desea cerrar el supermercado? (1 = Si, Otro = No): ");
            superAbierto = (scanner.nextInt() != 1);
        }

        if (superAbierto) {
            this.cajas = cajas;
            this.cola = new LinkedList<>();
        }
        return superAbierto;
    }

    private void mostrarTextoHora(int hora) {
        String horaTexto = (hora == 0) ? "Apertura de tienda" : "Hora " + (9 + hora) + ":00";
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println(horaTexto);
        System.out.println("-----------------------------------------------------------------------------");
    }

    private void actualizarCajas() {
        for (Caja caja : cajas) {
            if (caja.abierta && caja.productos > 0) {
                caja.productos--;
                productosVendidos++;
                if (caja.productos <= 0) {
                    caja.productos = 0;
                   clientesAt++;
                }
            }
        }
    }

    private void actualizarClientesEnCola() {
        double porcentajeNuevo = 0;
        if (Math.random() <= porcentajeNuevo) {
            cola.add(new Cliente((int) (Math.random() * 10) + 5));
        }
        for (Caja caja : cajas) {
            if (cola.size() > 0 && caja.abierta && caja.productos <= 0) {
                Cliente cliente =(Cliente) cola.poll();
                caja.productos = cliente.productos;
            }
        }
    }

    private void mostrarEstado(int minuto) {
        System.out.println("MINUTO " + minuto);
        System.out.println("Clientes en cola: " + cola.size());
        for (Caja caja : cajas) {
            System.out.println("Caja " + caja.id + ": " + (caja.abierta ? caja.productos : "Cerrada"));
        }
        System.out.println("-----------------------------------------------------------------------------");
        if (cola.isEmpty()) {
            minutosSinCola++;
        }
    }

    private void mostrarResumen() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Resumen cierre de tienda");
        System.out.println("Clientes atendidos: " + clientesAt);
        System.out.println("Productos vendidos: " + productosVendidos);
        System.out.println("Clientes sin atender en la cola: " + cola.size());
        System.out.println("Minutos sin cola: " + minutosSinCola);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("CIERRE DE TIENDA");
        System.out.println("-----------------------------------------------------------------------------");
    }
}

public class Alimento {
    private String nombre;
    private double cantidad; // Cantidad en gramos

    public Alimento(String nombre, double cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }
}

package Reto007;

public class Cliente {
    private String nombre;
    private Encuesta encuesta;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.encuesta = new Encuesta();
    }

    public void agregarAlimento(Alimentos alimento, int dia, String tipoIngesta) {
        encuesta.agregarAlimento(alimento, dia, tipoIngesta);
    }

    public void mostrarDieta() {
        System.out.println("Dieta de " + nombre + ":");
        encuesta.mostrarDias();
    }
}

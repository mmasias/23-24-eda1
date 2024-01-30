public class Alimento {

    private String nombre;
    private int calorias;

    public Alimento(String nombre, int calorias) {
        this.nombre = nombre;
        this.calorias = calorias;
    }

    public Alimento(String nombre) {
        this.nombre = nombre;
        this.calorias = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCalorias() {
        return calorias;
    }
    
}

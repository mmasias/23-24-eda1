package clases;

public class Alimento implements Comparable<Alimento> {
    private String nombre;
    private int mg;

    public Alimento(String nombre, int mg) {
        this.nombre = nombre;
        this.mg = mg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMg() {
        return mg;
    }

    public void setMg(int mg) {
        this.mg = mg;
    }

    @Override
    public int compareTo(Alimento o) {

        return this.getNombre().compareTo(o.getNombre());
    }

}

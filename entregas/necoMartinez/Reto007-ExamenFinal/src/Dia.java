package src;

public class Dia implements Comparable<Dia> {
    private int fecha;

    public Dia(int fecha) {
        this.fecha = fecha;
    }

    public int getFecha() {
        return fecha;
    }

    @Override
    public int compareTo(Dia o) {
        return Integer.compare(this.fecha, o.fecha);
    }

    @Override
    public String toString() {
        return "Dia: " + this.fecha;
    }
}

package ccf;

public class Persona extends Node{
    final int minCantidadItems = 5;
    final int maxCantidadItems = 15;
    int packItem;

    public Persona() {
        super(null);
        int cantidadItem = (int) (Math.random() * (maxCantidadItems - minCantidadItems)) + minCantidadItems;
        this.packItem = cantidadItem;
    }
    public int getPackItem() {
        return packItem;
    }
}
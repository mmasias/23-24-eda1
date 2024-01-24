package Arboles.model;

public class Dia {
    public Ingesta desayuno, mediaManana ,almuerzo ,merienda ,cena;
    public Dia siguiente;

    public Dia() {
        this.desayuno = this.mediaManana = this.almuerzo = this.merienda = this.cena = null;
        this.siguiente = null;
    }
}


package clases;

public enum Horario {
    DESAYUNO(1, "Desayuno"),
    MEDIA_MAÑANA(2, "Media-Manana"),
    ALMUERZO(3, "Almuerzo"),
    MERIENDA(4, "Merienda"),
    CENA(5, "Cena");

    private final int numero;
    private final String nombre;

    Horario(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

}

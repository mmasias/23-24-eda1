package core;

public class Alimento {

    private String nombre;
    private double calorias;
    private double proteinas;
    private double grasas;
    private double carbohidratos;
    private double vitaminas;
    private double minerales;
    private String tipo;

    public Alimento(String nombre, double calorias, double proteinas, double grasas, double carbohidratos, double vitaminas, double minerales, String tipo) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.carbohidratos = carbohidratos;
        this.vitaminas = vitaminas;
        this.minerales = minerales;
        this.tipo = tipo;
    }

    public Alimento(String nombre) {
        this.nombre = nombre;
        this.calorias = numeroAleatorio(100, 0);
        this.proteinas = numeroAleatorio(100, 0);
        this.grasas = numeroAleatorio(100, 0);
        this.carbohidratos = numeroAleatorio(100, 0);
        this.vitaminas = numeroAleatorio(100, 0);
        this.minerales = numeroAleatorio(100, 0);
        asignarTipo();
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public double getGrasas() {
        return grasas;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public double getVitaminas() {
        return vitaminas;
    }

    public double getMinerales() {
        return minerales;
    }

    private double numeroAleatorio(int valorMax, int valorMin) {
        return Math.random() * (valorMax - valorMin) + valorMin;
    }

    private int numeroIntAleatorio(int valorMax, int valorMin) {
        return (int) Math.random() * (valorMax - valorMin) + valorMin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private void asignarTipo(){
        switch (numeroIntAleatorio(3, 0)) {
            case 0:
                setTipo("Fruta/Verdura");
                break;
            case 1:
                setTipo("Alto en azucar");
                break;

            case 2:
                setTipo("Grasas Saturadas");
                break;

            case 3:
                setTipo("Sano");
                break;
        }
    }

}


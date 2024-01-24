package clases;

public class ValoresNutricionales implements Comparable<ValoresNutricionales> {
    public int calorias;
    public double azucar;
    public double proteinas;
    public double grasas;
    public String tipo;

    public ValoresNutricionales(int calorias, double azucar, double proteinas, double grasas, String tipo) {
        this.calorias = calorias;
        this.azucar = azucar;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.tipo = tipo;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public double getAzucar() {
        return azucar;
    }

    public void setAzucar(int azucar) {
        this.azucar = azucar;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(int grasas) {
        this.grasas = grasas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int compareTo(ValoresNutricionales o) {
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        CentroComercial centroComercial = new CentroComercial();

        for (int minuto = 1; minuto <= 10; minuto++) {
            centroComercial.simularMinuto(minuto);
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       int filas = 15;
       int columnas = 10;
       String[][] matriz = new String[filas][columnas];
         inicializarMatriz(matriz);
            imprimirMatriz(matriz);
    }
    public static void inicializarMatriz(String[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <matriz[i].length ; j++) {
                matriz[i][j] = " ";
            }
        }
    }
    public static void imprimirMatriz(String[][] matriz) {
        int maxCeldaLength = 7;

        System.out.print("   ");
        for (char c = 'A'; c <= 'J'; c++) {
            System.out.print("| " + c + "       ");
        }
        System.out.println("|");

        System.out.print("   ");
        for (int i = 0; i < 10; i++) {
            System.out.print("+---------");
        }
        System.out.println("+");

        for (int i = 0; i < matriz.length; i++) {

            String numeroFila = String.format("%2d", i + 1);

            System.out.print(numeroFila + " |");
            for (int j = 0; j < 10; j++) {
                String contenido = "";
                if (j < matriz[i].length) {
                    contenido = matriz[i][j];
                }

                if (contenido.length() > maxCeldaLength) {
                    contenido = contenido.substring(0, maxCeldaLength);
                }
                System.out.print("       " + contenido + " |");
            }
            System.out.println();
        }
    }

}

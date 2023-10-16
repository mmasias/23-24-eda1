class EjemploMugre{

    public static void main(String[] args){

        String[] linea = {"aa", "bb", "cc", "dd"};
        // System.out.println(linea[3]);

        String[][] matriz = {
            linea, 
            {"aa", "bb", "cc", "dd"}, 
            linea,
            linea,
            linea
        };
        System.out.println(linea);
        
        matriz[0][0] = "JA!";
        
        System.out.println(linea);

        for (int fila=0;fila<matriz.length;fila++){
            for (int columna=0; columna<matriz[fila].length; columna++){
                System.out.print(matriz[fila][columna] + " : ");
            }
            System.out.println();
        }

    }

}
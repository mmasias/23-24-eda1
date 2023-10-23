package main;

public class Usuario {
    protected int[] usuario = {1,1};
    private static final int[][] MOVIMIENTOS = {
            {0, 0},
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}};
    private static final int ARRIBA = 1;
    private static final int ABAJO = 2;
    private static final int IZQUIERDA = 3;
    private static final int DERECHA = 4;
    private static final int INGRESO=5;
    private static final int FIN=6;

    public Usuario(int[] usuario) {
        this.usuario = usuario;
    }

    private static int capturaMovimiento() {
        public static char preguntaChar() {

            Scanner entrada = new Scanner(System.in);
            return entrada.next().charAt(0);
        }
        String [] finalDeHoja={"    +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+"};
        String[] []cabezera={
                {"     A       B       C       D       E       F       G       H       I       J"},
                {"    +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+"},
        };
        switch (preguntaChar()) {
            case 's', 'S':
                return ABAJO;
            case 'w', 'W':
                return ARRIBA;
            case 'a', 'A':
                return IZQUIERDA;
            case 'd', 'D':
                return DERECHA;
            case 'e','E':
                return INGRESO;
            case 'q','Q':
                return FIN;

        }
        return 0;
    }
    static void mueve(int[] usuario, int movimiento) {

        int nuevaFila = usuario[FILA] + MOVIMIENTOS[movimiento][FILA];
        int nuevaColumna = usuario[COLUMNA] + MOVIMIENTOS[movimiento][COLUMNA];



        usuario[FILA] = nuevaFila;
        usuario[COLUMNA] = nuevaColumna;



    }
    private static void definePosicion(int[] usuario) {

        switch (capturaMovimiento()) {
            case ARRIBA:
                mueve(usuario, ARRIBA);
                break;
            case ABAJO:
                mueve(usuario, ABAJO);
                break;
            case IZQUIERDA:
                mueve(usuario, IZQUIERDA);
                break;
            case DERECHA:
                mueve(usuario, DERECHA);
                break;
        }
    }
}

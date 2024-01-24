package entregas.garciaLydia.examenFinal;

import java.util.ArrayList;
import java.util.List;

public class Dia {
    private int numero;
    private TreeNode ingestas;

    public Dia(int numero) {
        this.numero = numero;
        this.ingestas = new TreeNode("Root");
    }

    public int getNumero() {
        return numero;
    }


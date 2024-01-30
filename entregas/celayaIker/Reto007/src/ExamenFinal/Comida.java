package ExamenFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comida {
    String alimentos;
    List<String> lista = new ArrayList<>();
    int dia;

    public void añadirAlimento(String alimento) {
        lista.add(alimento);
    }

    public void mostrarAlimentos() {
        System.out.println("Alimentos del Comida: ");
        for (String alimento : lista) {
            System.out.println(alimento);
        }
    }

    public String getLista() {
        return lista.toString();
    }

    public void creaDesayuno() {
        lista.clear();
        System.out.println("Ingrese un alimento del Comida del día " + dia + " (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (!alimentos.equals("-1")) {
            if (alimentos.equals("-2")) {
                mostrarAlimentos();
            } else {
                añadirAlimento(alimentos);
            }
            alimentos = sc.nextLine();
        }
    }

    public void creaMedia() {
        lista.clear();
        System.out.println("Ingrese un alimento de media mañana del día " + dia + " (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (!alimentos.equals("-1")) {
            if (alimentos.equals("-2")) {
                mostrarAlimentos();
            } else {
                añadirAlimento(alimentos);
            }
            alimentos = sc.nextLine();
        }
    }

    public void creaAlmuerzo() {
        lista.clear();
        System.out.println("Ingrese un alimento del almuerzo del día " + dia + " (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (!alimentos.equals("-1")) {
            if (alimentos.equals("-2")) {
                mostrarAlimentos();
            } else {
                añadirAlimento(alimentos);
            }
            alimentos = sc.nextLine();
        }
    }

    public void creaMerienda() {
        lista.clear();
        System.out.println("Ingrese un alimento de la merienda del día " + dia + " (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (!alimentos.equals("-1")) {
            if (alimentos.equals("-2")) {
                mostrarAlimentos();
            } else {
                añadirAlimento(alimentos);
            }
            alimentos = sc.nextLine();
        }
    }

    public void creaCena() {
        lista.clear();
        System.out.println("Ingrese un alimento del Comida del día " + dia + " (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (!alimentos.equals("-1")) {
            if (alimentos.equals("-2")) {
                mostrarAlimentos();
            } else {
                añadirAlimento(alimentos);
            }
            alimentos = sc.nextLine();
        }
    }
    
}


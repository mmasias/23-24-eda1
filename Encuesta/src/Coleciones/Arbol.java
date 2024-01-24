package Coleciones;

import Coleciones.NodoArbol;
import clases.Alimento;
import clases.Ingesta;

public class Arbol<T extends IDataStructure> {
    private NodoArbol<T> raiz;

    public Arbol(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public void recorridoPreOrden(NodoArbol<T> nodo) {
        if (nodo != null) {
            System.out.println(nodo.getValor().getInformacion() + " ");
            for (NodoArbol<T> hijo : nodo.getHijos()) {
                recorridoPreOrden(hijo);
            }
        }
    }

    public void recorridoPostOrden(NodoArbol<T> nodo) {
        if (nodo != null) {
            for (NodoArbol<T> hijo : nodo.getHijos()) {
                recorridoPostOrden(hijo);
            }
            System.out.println(nodo.getValor().getInformacion() + " ");
        }
    }
public int totalCaloriasEnc(NodoArbol<T> nodo){
        if(nodo!=null){
            int total=0;
            if (nodo.getValor() instanceof Ingesta){
                Ingesta ingesta =(Ingesta) nodo.getValor();
                total+= ingesta.totalCalorias();
            }
            for (NodoArbol<T> hijo : nodo.getHijos()){
                total+= totalCaloriasEnc(hijo);
            }
            return total;
        } else {
            return 0;
        }
}
    public int totalTipoEnc(NodoArbol<T> nodo, String nombre){
        if(nodo!=null){
            int total=0;
            if (nodo.getValor() instanceof Ingesta){
                Ingesta ingesta =(Ingesta) nodo.getValor();

                total+= ingesta.totalTipo(nombre);
            }
            for (NodoArbol<T> hijo : nodo.getHijos()){
                total+= totalTipoEnc(hijo, nombre);
            }
            return total;
        } else {
            return 0;
        }
    }


    public int totalAzucarEnc(NodoArbol<T> nodo){
        if(nodo!=null){
            int total=0;
            if (nodo.getValor() instanceof Ingesta){
                Ingesta ingesta =(Ingesta) nodo.getValor();
                total+= ingesta.totalAzucar();
            }
            for (NodoArbol<T> hijo : nodo.getHijos()){
                total+= totalAzucarEnc(hijo);
            }
            return total;
        } else {
            return 0;
        }
    }
    public int totalProteinasEnc(NodoArbol<T> nodo){
        if(nodo!=null){
            int total=0;
            if (nodo.getValor() instanceof Ingesta){
                Ingesta ingesta =(Ingesta) nodo.getValor();
                total+= ingesta.totalProteinas();
            }
            for (NodoArbol<T> hijo : nodo.getHijos()){
                total+= totalProteinasEnc(hijo);
            }
            return total;
        } else {
            return 0;
        }
    }
    public int totalGrasasEnc(NodoArbol<T> nodo){
        if(nodo!=null){
            int total=0;
            if (nodo.getValor() instanceof Ingesta){
                Ingesta ingesta =(Ingesta) nodo.getValor();
                total+= ingesta.totalGrasas();
            }
            for (NodoArbol<T> hijo : nodo.getHijos()){
                total+= totalGrasasEnc(hijo);
            }
            return total;
        } else {
            return 0;
        }
    }
    public NodoArbol<T> buscar(T valor, NodoArbol<T> nodo) {
        if (nodo == null) {
            return null;
        }

        if (nodo.getValor().equals(valor)) {
            return nodo;
        }

        for (NodoArbol<T> hijo : nodo.getHijos()) {
            NodoArbol<T> resultado = buscar(valor, hijo);
            if (resultado != null) {
                return resultado;
            }
        }

        return null;
    }

}

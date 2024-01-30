package Coleciones;

import clases.Ingesta;

public interface IDataStructure<T> extends Comparable<IDataStructure> {
    int compareTo(Ingesta o);

    public boolean isEmpty();
    public String getInformacion();


    public int size();

    public Object[] listAll();
}

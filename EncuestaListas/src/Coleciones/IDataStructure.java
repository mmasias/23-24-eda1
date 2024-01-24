package Coleciones;

import clases.Ingesta;
import clases.Persona;

public interface IDataStructure<T> extends Comparable<IDataStructure> {
    int compareTo(Ingesta o);

    public boolean isEmpty();
    public String getInformacion();


    void insertarHijos(IDataStructure hijo);
    public int size();

    public Object[] listAll();

    void setValue(Persona persona);

    <T extends Comparable<T>> IDataStructure insertarHijos();
}

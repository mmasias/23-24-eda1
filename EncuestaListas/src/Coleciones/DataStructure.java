package Coleciones;

import Coleciones.GenericNode;
import Coleciones.IDataStructure;

public abstract class DataStructure<T> implements IDataStructure<T> {

    public GenericNode<T> first = null;

    @Override
    public abstract boolean isEmpty();

    @Override
    public abstract int size();

    @Override
    public abstract Object[] listAll();

}

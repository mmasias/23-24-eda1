package listas.basica;

public class List {

    private Nodo first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        } else {
            int count = 1;
            Nodo iterator = first;
            while (iterator.getSiguiente() != null) {
                count++;
                iterator = iterator.getSiguiente();
            }
            return count;
        }
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertar(String dato) {
        Nodo nodoQueEntra = new Nodo(dato);
        if (this.first == null)
            this.first = nodoQueEntra;
        else {
            Nodo iterator = this.first;
            while (iterator.getSiguiente() != null) {
                iterator = iterator.getSiguiente();
            }
            iterator.setSiguiente(nodoQueEntra);
        }
    }

    public void DeleteIni() {
        if (this.first != null) {
            this.first = this.first.getSiguiente();
        }
    }

    public String[] ListAll() {
        String[] list = new String[this.size()];
        Nodo iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getDato();
            count++;
            iterator = iterator.getSiguiente();
        }
        return list;
    }

}

package listas.basica;

public class List {

    private Nodo first = null;

    public int Size() {
        if (this.first == null)
            return 0;

        int count = 1;
        Nodo iterator = first;
        while (iterator.getSiguiente() != null) {
            count++;
            iterator = iterator.getSiguiente();
        }
        return count;
    }

    public boolean IsEmpty() {
        return this.Size() > 0 ? false : true;
    }

    public void InsertIni(String dato) {
        Nodo n = new Nodo(dato);
        if (this.first == null)
            this.first = n;
        else {
            n.setSiguiente(this.first);
            this.first = n;
        }
    }

    public void InsertEnd(String dato) {
        Nodo n = new Nodo(dato);
        if (this.first == null)
            this.first = n;
        else {
            Nodo iterator = this.first;
            while (iterator.getSiguiente() != null) {
                iterator = iterator.getSiguiente();
            }
            iterator.setSiguiente(n);
        }
    }

    public void DeleteIni() {
        if (this.first != null) {
            this.first = this.first.getSiguiente();
        }
    }

    public String[] ListAll() {
        String[] list = new String[this.Size()];
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

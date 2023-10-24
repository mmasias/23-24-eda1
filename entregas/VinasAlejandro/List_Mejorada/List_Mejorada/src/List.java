public class List {

    private Node first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        } else {
            int count = 1;
            Node iterator = first;
            while (iterator.getNext() != null) {
                count++;
                iterator = iterator.getNext();
            }
            return count;
        }
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    
    public void insert(String value,boolean imprimellegada,boolean imprimetamano,boolean insertaPrimero) {
        Node nodoQueEntra = new Node(value);
        
         if (this.first == null)
             this.first = nodoQueEntra;
        else if (!insertaPrimero){
             Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(nodoQueEntra);
        }
         else{
            nodoQueEntra.setNext(this.first);
            this.first= nodoQueEntra;

         }

        if (imprimellegada)
            System.out.println(">llego "+ value);
        if (imprimetamano)
            System.out.println("Tamaño: " + this.size());
    }

    public void insert(String value,boolean imprimellegada,boolean imprimetamano,int posicion){
         Node nodoQueEntra = new Node(value);
        int contador = 0;
         if(posicion<0 || posicion>this.size()-1){
                System.out.println("NO SE PUEDE INSERTAR ANTES DEL PRIMER ELEMENTO NI DESPUES DEL ULTIMO");
        }else{
         if (this.first == null)
             this.first = nodoQueEntra;
        else{
           
             Node iterator = this.first;
            while (iterator.getNext() != null) {
               if (contador==(posicion-1)){
                nodoQueEntra.setNext(iterator.getNext());
                iterator.setNext(nodoQueEntra);
                break;
               }
                iterator = iterator.getNext();
                contador ++;
            }
        
            
        }
    
        if (imprimellegada)
            System.out.println(">llego "+ value);
        if (imprimetamano)
            System.out.println("Tamaño: " + this.size());
         }
    }


    public void delete(boolean borraprimero) {
        if (this.first != null) {
            if(!borraprimero){
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
            System.out.println("se fue "+ iterator.getValue());

            }else{
                System.out.println("se fue "+ this.first.getValue());
                this.first = this.first.getNext();
            }
            System.out.println("Tamaño: " + this.size());
        }

    }

    public void delete(int posicion) {
        if (this.first != null) {
            if(posicion<0 || posicion>this.size()-1){
                System.out.println("NO SE PUEDE BORRAR ANTES DEL PRIMER ELEMENTO NI DESPUES DEL ULTIMO");
            }else{
            Node iterator = this.first;
            Node previous = null;
            int contador = 0;
            while (iterator.getNext() != null) {
                if (contador==(posicion)){
                    previous.setNext(iterator.getNext());
                    break;
                }
                previous = iterator;
                iterator = iterator.getNext();
                contador ++;
            }
            System.out.println("se fue "+ iterator.getValue());
            System.out.println("Tamaño: " + this.size());
            }
        }

    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

    public String[] imprimirDatos() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}

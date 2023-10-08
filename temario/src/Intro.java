class Intro {
    public static void main(String[] args) {

        imprimirTitulo("Primitivos");

        imprimirSubtitulo("Enteros");

        int precio = 12;
        int otroPrecio = precio;
        System.out.println(precio == otroPrecio);

        otroPrecio = 24;
        System.out.println(precio == otroPrecio);

        otroPrecio = 12;
        System.out.println(precio == otroPrecio);

        imprimirSubtitulo("Char");

        char unChar = 'a';
        char otroChar = unChar;
        char tercerChar = 'a';

        System.out.println(unChar + " - " + otroChar + " - " + tercerChar);
        System.out.println(unChar == otroChar);
        System.out.println(unChar == tercerChar);

        imprimirTitulo("String");

        String cadenaTexto = "Una cadena";
        String otraCadena = cadenaTexto;
        String terceraCadena = new String("Una cadena");

        System.out.println(cadenaTexto + " - " + otraCadena + " - " + terceraCadena);
        System.out.println(cadenaTexto == otraCadena);
        System.out.println(cadenaTexto == terceraCadena);

        System.out.println(verHashCode(cadenaTexto) + " - " + verHashCode(otraCadena) + " - " + verHashCode(terceraCadena));        

        cadenaTexto = "XYZ";
        System.out.println(cadenaTexto + " - " + otraCadena + " - " + terceraCadena);


        terceraCadena = "ABC";
        System.out.println(cadenaTexto + " - " + otraCadena + " - " + terceraCadena);

        imprimirTitulo("Arrays");

        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;
        int[] arr3 = new int[]{1, 2, 3};

        System.out.println(arr1 + " - " + arr2 + " - " + arr3);        

        System.out.println("Los arrays tienen el mismo contenido: " + java.util.Arrays.equals(arr1, arr3));
        System.out.println("Los arrays son el mismo objeto: " + (arr1 == arr2));
        System.out.println("Los arrays son diferentes objetos: " + (arr1 == arr3));

        arr2[0] = 100;
        System.out.println("Primer elemento de arr1: " + arr1[0]);

        imprimirTitulo("Objetos Personalizados");

        Persona p1 = new Persona("Alice");
        Persona p2 = p1;
        Persona p3 = new Persona("Alice");


        System.out.println(p1 + " - " + p2 + " - " + p3);        
        System.out.println("Los nombres son iguales: " + p1.getNombre().equals(p3.getNombre()));
        System.out.println("Los objetos son el mismo objeto: " + (p1 == p2));
        System.out.println("Los objetos son diferentes objetos: " + (p1 != p3));

        p2.setNombre("Bob");
        System.out.println("Nombre de p1: " + p1.getNombre());
    }

    static void imprimirLinea() {
        System.out.println("=".repeat(40));
    }

    static void imprimirLinea(int longitud) {
        System.out.println("-".repeat(longitud));
    }

    static void imprimirTitulo(String texto) {
        imprimirLinea();
        System.out.println(texto.toUpperCase());
        imprimirLinea(texto.length());
    }

    static void imprimirSubtitulo(String texto) {
        imprimirLinea(0);
        System.out.println(texto);
        imprimirLinea(texto.length());        
    }

    static int verHashCode(String unaCadena){
        return System.identityHashCode(unaCadena);
    }
 
    
    static class Persona {
        private String nombre;

        public Persona(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }
    
}


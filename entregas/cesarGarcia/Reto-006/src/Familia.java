public class Familia {

    public static void main(String[] args) {
        FamiliaTree<String> arbolFamiliar = new FamiliaTree<>();

        arbolFamiliar.agregarMiembro("Abuelo", null, false);
        arbolFamiliar.agregarMiembro("Padre", "Abuelo", true);
        arbolFamiliar.agregarMiembro("Madre", "Abuelo", false);
        arbolFamiliar.agregarMiembro("Hijo1", "Padre", true);
        arbolFamiliar.agregarMiembro("Hijo2", "Padre", false);
        arbolFamiliar.agregarMiembro("Hija", "Madre", true);

        arbolFamiliar.imprimirArbol();
    }
}

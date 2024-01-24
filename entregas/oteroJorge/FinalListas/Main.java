public class Main {

    public static void main(String[] args) {
        Encuesta encuesta = new Encuesta("01/01/2020");
        Paciente paciente = new Paciente("Jorge", "01/01/2020");
        paciente.insertarDia();
        encuesta.mostrarArbol(paciente);
        System.out.println();
        insertarAlimentos(paciente, 1, 1);
        encuesta.mostrarArbol(paciente);
        System.out.println("Fin del programa");

    }

    static void insertarAlimentos(Paciente paciente, int dia, int ingesta){
        System.out.println("Insertando alimentos");
        paciente.getDias().get(dia).getIngestas().get(ingesta).addAlimento(new Alimento("Manzana"));
        System.out.println();

    }
    
}

public class Main {

    public static void main(String[] args) {
        Encuesta encuesta = new Encuesta("01/01/2020");
        Paciente paciente = new Paciente("Jorge", "01/01/2020");
        paciente.insertarDia();
        encuesta.mostrarArbol(paciente);
    }
    
}

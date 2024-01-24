import core.Alimento;
import core.Encuesta;
import core.Paciente;

public class Test {

    public static void main(String[] args) {
        Paciente paciente = new Paciente("Juan", "2/7/2010",90,1.80);
        Encuesta encuesta = new Encuesta("Encuesta 1");

        paciente.getDia1().getAlmuerzo().addAlimento(new Alimento("Arroz"));
        paciente.getDia1().getCena().addAlimento(new Alimento("Fideos"));

        System.out.println("Añadido");
        encuesta.mostrarArbol(paciente);

        paciente.getDia2().getDesayuno().addAlimento(new Alimento("Leche"));
        paciente.getDia2().getDesayuno().addAlimento(new Alimento("Cafe"));

        System.out.println("Añadido");
        encuesta.mostrarArbol(paciente);
        System.out.println("Fin");
    }
    
}

package entregas.sergioMayen.Reto7;

import java.util.Scanner;

public class Paciente {
    private String nombre;
    private String fechaAlta;

    public Paciente(String nombre, String fechaAlta) {
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Paciente: " + nombre + "\nFecha de Alta: " + fechaAlta;
    }

    public static Paciente crearPaciente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la fecha de alta del paciente: ");
        String fechaAlta = scanner.nextLine();

        // Cerrar el scanner al finalizar
        scanner.close();

        return new Paciente(nombre, fechaAlta);
    }   
}

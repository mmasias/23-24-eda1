package entregas.garciaLydia.examenFinal;

import java.util.Optional;
import java.util.Scanner;

public class GestorEncuesta {
    private Scanner scanner;
    private EncuestaNutricional encuesta;

    public GestorEncuesta() {
        this.scanner = new Scanner(System.in);
    }

    public void simular() {
        scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();

        System.out.print("Ingrese la fecha de alta (dd/MM/yyyy): ");
        String fechaAlta = scanner.nextLine();

        encuesta = new EncuestaNutricional(nombrePaciente, fechaAlta);

